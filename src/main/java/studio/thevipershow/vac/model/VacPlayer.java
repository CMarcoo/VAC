package studio.thevipershow.vac.model;

import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import studio.thevipershow.vac.model.data.FlagsData;

@Getter
public class VacPlayer {

    public VacPlayer(@NotNull Player player) {
        if (!player.isOnline()) {
            throw new RuntimeException("Player is not online, cannot build a VacPlayer!");
        } else {
            if (VacPlayers.instance.getVacPlayerMap().containsKey(player.getUniqueId())) {
                throw new RuntimeException("You cannot create a VacPlayer instance that is already existing!");
            } else {
                this.player = player;
                this.data = FlagsData.ofPlayer(this);
            }
        }
    }

    public VacPlayer(@NotNull UUID uuid) {
        this(Objects.requireNonNull(Bukkit.getPlayer(uuid), "Player is not online, cannot build a VacPlayer!"));
    }

    /**
     * Build a VacPlayer instance with a static method.
     *
     * @param player The player.
     * @return A VacPlayer object if the player was online, null otherwise.
     */
    public static VacPlayer ofPlayer(@NotNull Player player) {
        return new VacPlayer(player);
    }

    private final Player player;
    private final FlagsData data;
}
