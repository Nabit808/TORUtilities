package io.github.nabit808.tORUtilities;

import io.github.nabit808.tORUtilities.commands.CommandHeight;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public final class TORUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("height").setExecutor(new CommandHeight());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
