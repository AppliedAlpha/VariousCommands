package com.example.variouscommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class VariousCommands extends JavaPlugin {
    private static VariousCommands instance;

    public static VariousCommands getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Plugin Successfully Loaded.");
        getCommand("countdown").setExecutor(new CountDownCommandExecutor());
        getCommand("random").setExecutor(new RandomCommandExecutor());
        getCommand("colored").setExecutor(new ColoredCommandExecutor());
        getCommand("tpall").setExecutor(new TpAllCommandExecutor());
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
