package com.seleniummc.seleniumcore;

import com.seleniummc.seleniumcore.listeners.SleepListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SeleniumCore extends JavaPlugin
{
    private FileConfiguration config = getConfig();

    @Override
    public void onEnable()
    {
        //Fired when the server enables the plugin
        config.addDefault("singlePlayerSleepEnabled", true);
        config.addDefault("singlePlayerSleepSleepTicks", 101);
        config.addDefault("singlePlayerSleepWakeUpTick", 0);
        config.options().copyDefaults(true);
        saveConfig();

        if(this.getConfig().getBoolean("singlePlayerSleepEnabled"))
            getServer().getPluginManager().registerEvents(new SleepListener(this), this);
    }

    @Override
    public void onDisable()
    {
        //Fired when the server stops and disables all plugins

    }

    public FileConfiguration getPluginConfig()
    {
        return config;
    }
}
