<<<<<<< HEAD:src/main/java/com/seleniummc/seleniumcore/DataManager.java
package com.seleniummc.seleniumcore;

import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataManager
{
    private final SeleniumCore plugin;
    private final String dataFolder;
    private final Map<UUID, PlayerData> players = new HashMap();

    public DataManager(SeleniumCore plugin)
    {
        this.plugin = plugin;
        this.dataFolder = plugin.getDataFolder() + File.separator + "players";

        File folder = new File(this.dataFolder);
        folder.mkdirs();
    }

    public String getDataFolder()
    {
        return this.dataFolder;
    }

    public PlayerData getData(Player player)
    {
        return this.players.get(player.getUniqueId());
    }

    public void registerPlayer(Player player)
    {
        this.players.put(player.getUniqueId(), new PlayerData(this.plugin, player));

        this.getData(player).load();
    }

    public void unregisterPlayer(Player player)
    {
        this.getData(player).save();
        this.players.remove(player.getUniqueId());
    }

    public void unregisterAll()
    {
        for(Player player : this.plugin.getServer().getOnlinePlayers())
        {
            this.unregisterPlayer(player);
        }
    }
}
=======
package com.seleniummc.seleniumcore;

import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataManager
{
    private final SeleniumCore plugin;
    private final String dataFolder;
    private final Map<UUID, PlayerData> players = new HashMap<>();

    public DataManager(SeleniumCore plugin)
    {
        this.plugin = plugin;
        this.dataFolder = plugin.getDataFolder() + File.separator + "players";

        File folder = new File(this.dataFolder);
        folder.mkdirs();
    }

    public String getDataFolder()
    {
        return this.dataFolder;
    }

    public PlayerData getData(Player player)
    {
        return this.players.get(player.getUniqueId());
    }

    public void registerPlayer(Player player)
    {
        this.players.put(player.getUniqueId(), new PlayerData(this.plugin, player));


    }
}
>>>>>>> 1c1c4ae97a2faf67a1c13ee067b1743a237b4414:src/com/seleniummc/seleniumcore/DataManager.java
