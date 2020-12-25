package studio.thevipershow.vac;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Vac extends JavaPlugin {

    private PaperCommandManager commandManager;

    private void registerCommandManager() {
        if (commandManager != null) { // command manager should be null
            throw new RuntimeException("The command manager cannot register twice.");
        } else { // creating a new PaperCommandManager
            commandManager = new PaperCommandManager(this);
        }
    }

    private void registerCommands() {
        if (commandManager == null) { // command manager should never be null
            throw new RuntimeException("Command manager is null, cannot register commands.");
        } else { // register all commands

        }
    }

    @Override
    public void onEnable() { // Plugin startup logic

    }

    @Override
    public void onDisable() { // Plugin shutdown logic
    }
}
