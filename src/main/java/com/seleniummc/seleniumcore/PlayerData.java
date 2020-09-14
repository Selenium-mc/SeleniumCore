package com.seleniummc.seleniumcore;

import com.google.gson.annotations.Expose;
import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.entity.Player;

import java.io.File;

public class PlayerData
{
    private final SeleniumCore plugin;
    private final Player player;
    private final File dataFile;

    @Expose
    private boolean isWhitelisted = false;

    public PlayerData(SeleniumCore plugin, Player player)
    {
        this.plugin = plugin;
        this.player = player;
        this.dataFile = new File(plugin.getDataManager().getDataFolder(), player.getUniqueId() + ".json");
    }


}
