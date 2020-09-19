package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener
{
    private final SeleniumCore plugin;

    public PlayerListener(SeleniumCore plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event)
    {

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        this.plugin.getDataManager().registerPlayer(event.getPlayer());

        //If the player is whitelisted
        if(this.plugin.getDataManager().getData(event.getPlayer()).getIsWhitelisted())
        {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            event.setJoinMessage(event.getPlayer().getDisplayName() + " has joined the game!");
        }else
        {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
            event.getPlayer().sendMessage("You are currently not whitelisted, but you can spectate. And existing member will need to whitelist you!");
            event.setJoinMessage(event.getPlayer().getDisplayName() + " has joined the game as a spectator!");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR) // Runs very last
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(event.getPlayer().getDisplayName() + " no longer exists.");

        this.plugin.getDataManager().unregisterPlayer(event.getPlayer());
    }
}
