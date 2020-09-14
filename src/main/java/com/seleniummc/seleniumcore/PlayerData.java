package com.seleniummc.seleniumcore;

import com.google.gson.annotations.Expose;
import com.seleniummc.seleniumcore.utils.GsonUtil;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

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

    public void load(){
        try{
            this.dataFile.getParentFile().mkdirs();

            if(!this.dataFile.exists())
            {
                this.plugin.getLogger().log(Level.INFO, "No data file exists for " + this.player.getName() + ", creating one!");
                this.dataFile.createNewFile();
                this.save();
            }

            PlayerData data = GsonUtil.getInstance().fromJson(new FileReader(this.dataFile), PlayerData.class);
            this.setIsWhitelisted(data.isWhitelisted);
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void save()
    {
        try
        {
            this.dataFile.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(this.dataFile);
            GsonUtil.getInstance().toJson(this, writer);
            writer.close();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setIsWhitelisted(boolean isWhitelisted)
    {
        this.isWhitelisted = isWhitelisted;
    }

    public boolean getIsWhitelisted(){
        return isWhitelisted;
    }


}
