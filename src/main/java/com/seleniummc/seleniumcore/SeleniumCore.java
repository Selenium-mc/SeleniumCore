package com.seleniummc.seleniumcore;

import com.seleniummc.seleniumcore.listeners.PlayerListener;
import com.seleniummc.seleniumcore.listeners.SleepListener;
import com.seleniummc.seleniumcore.listeners.ChatListener;
import com.seleniummc.seleniumcore.recipes.DropperRecipe;
import com.seleniummc.seleniumcore.recipes.RepeaterRecipe;
import org.bukkit.block.data.type.Repeater;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SeleniumCore extends JavaPlugin
{
    private FileConfiguration config = getConfig();
    private DataManager dataManager;

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
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        this.dataManager = new DataManager(this);

        //Recipes
        DropperRecipe dropper = new DropperRecipe(this);
        dropper.init();
        RepeaterRecipe repeater = new RepeaterRecipe(this);
        repeater.init();
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
