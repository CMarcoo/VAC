package studio.thevipershow.vac;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import studio.thevipershow.vac.metrics.Metrics;
import studio.thevipershow.vac.metrics.VacMetrics;
import studio.thevipershow.vac.model.VacPlayers;

@Getter
public class Vac extends JavaPlugin {

    private PaperCommandManager commandManager;
    private Metrics metrics;

    public void registerMetrics() {
        metrics = VacMetrics.getInstance(this);
    }

    public void startMetrics() {
        metrics.startService();
    }

    public void registerCommandManager() {
        if (commandManager != null) { // command manager should be null
            throw new RuntimeException("The command manager cannot register twice.");
        } else { // creating a new PaperCommandManager
            commandManager = new PaperCommandManager(this);
        }
    }

     public void registerCommands() {
        if (commandManager == null) { // command manager should never be null
            throw new RuntimeException("Command manager is null, cannot register commands.");
        } else { // register all commands

        }
    }

    public void registerListeners() {
        VacPlayers.enableSelfAdjusting(this);
    }

    @Override
    public void onEnable() { // Plugin startup logic
        registerMetrics();
        startMetrics();

        registerListeners();

        registerCommandManager();
        registerCommands();
    }
}
