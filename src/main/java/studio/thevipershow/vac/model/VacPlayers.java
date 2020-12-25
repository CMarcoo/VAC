package studio.thevipershow.vac.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import studio.thevipershow.vac.Vac;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VacPlayers implements Listener {
    public final static VacPlayers instance = new VacPlayers();

    private final Map<UUID, VacPlayer> vacPlayerMap = new HashMap<>();

    @Setter
    private boolean selfAdjust = true;

    private boolean registered = false;

    public static void enableSelfAdjusting(@NotNull Vac vac) {
        if (instance.registered) {
            throw new UnsupportedOperationException("Cannot register twice!");
        } else {
            vac.getServer().getPluginManager().registerEvents(instance, vac);
            instance.registered = true;
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    private void onPlayerJoin(PlayerJoinEvent event) {
        val player = event.getPlayer();
        val uuid = player.getUniqueId();
        vacPlayerMap.put(uuid, VacPlayer.ofPlayer(player));
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    private void onPlayerQuit(PlayerQuitEvent event) {
        vacPlayerMap.remove(event.getPlayer().getUniqueId());
    }

    /**
     * Get all of the registered Vac Players currently online.
     *
     * @return All of the online Vac Players.
     * If none is online collection is empty.
     */
    @NotNull
    public static Collection<VacPlayer> getVacPlayers() {
        return instance.vacPlayerMap.values();
    }

    /**
     * Get a Vac Player from his UUID.
     *
     * @param uuid The UUID of the player.
     * @return The VacPlayer if online, null otherwise.
     */
    @Nullable
    public static VacPlayer getVacPlayer(@NotNull UUID uuid) {
        return instance.vacPlayerMap.get(uuid);
    }

    /**
     * Get a Vac Player from a Player instance.
     *
     * @param player The Player.
     * @return The VacPlayer if online, null otherwise.
     */
    @Nullable
    public static VacPlayer getVacPlayer(@NotNull Player player) {
        return getVacPlayer(player.getUniqueId());
    }
}
