package com.seleniummc.seleniumcore;

import com.seleniummc.seleniumcore.listeners.PlayerListener;
import com.seleniummc.seleniumcore.listeners.SleepListener;
import com.seleniummc.seleniumcore.listeners.ChatListener;
import com.seleniummc.seleniumcore.commands.MsgCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SeleniumCore extends JavaPlugin
{
    private FileConfiguration config = getConfig();
    private DataManager dataManager;

    @Override
    public void onEnable()
    {
        // Fired when the server enables the plugin
        config.addDefault("singlePlayerSleepEnabled", true);
        config.addDefault("singlePlayerSleepSleepTicks", 101);
        config.addDefault("singlePlayerSleepWakeUpTick", 0);
        config.options().copyDefaults(true);
        saveConfig();

        // Commands
        this.getCommand("pm").setExecutor(new MsgCommand(this));
        this.getCommand("w").setExecutor(new MsgCommand(this));
        this.getCommand("msg").setExecutor(new MsgCommand(this));


        if(this.getConfig().getBoolean("singlePlayerSleepEnabled"))
            getServer().getPluginManager().registerEvents(new SleepListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        this.dataManager = new DataManager(this);
    }

    @Override
    public void onDisable()
    {
        //Fired when the server stops and disables all plugins
        this.getDataManager().unregisterAll();
    }

    public FileConfiguration getPluginConfig()
    {
        return config;
    }

    public DataManager getDataManager()
    {
        return dataManager;
    }
}
