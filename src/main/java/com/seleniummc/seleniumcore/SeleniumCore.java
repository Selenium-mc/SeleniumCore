<<<<<<< HEAD:src/main/java/com/seleniummc/seleniumcore/SeleniumCore.java
package com.seleniummc.seleniumcore;

import com.seleniummc.seleniumcore.listeners.PlayerListener;
import com.seleniummc.seleniumcore.listeners.SleepListener;
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
=======
package com.seleniummc.seleniumcore;

import com.seleniummc.seleniumcore.listeners.SleepListener;
import com.seleniummc.seleniumcore.commands.ShrugCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SeleniumCore extends JavaPlugin
{
    private FileConfiguration config = getConfig();

    @Override
    public void onEnable()
    {
        // Fired when the server enables the plugin
        config.addDefault("singlePlayerSleepEnabled", true);
        config.addDefault("singlePlayerSleepSleepTicks", 101);
        config.addDefault("singlePlayerSleepWakeUpTick", 0);
        config.options().copyDefaults(true);
        saveConfig();

        // Register commands
        this.getCommand("shrug").setExecutor(new ShrugCommand(this));

        // Register event listeners
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
>>>>>>> 1c1c4ae97a2faf67a1c13ee067b1743a237b4414:src/com/seleniummc/seleniumcore/SeleniumCore.java
