<<<<<<< HEAD:src/main/java/com/seleniummc/seleniumcore/listeners/SleepListener.java
package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepListener implements Listener
{
    private final SeleniumCore plugin;
    private int advanceTimeTaskId;

    public SleepListener(SeleniumCore plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event)
    {
        //Fired when a player enters a bed
        if(event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK){return;}

        this.advanceTimeTaskId = this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
            @Override
            public void run()
            {
                event.getPlayer().getWorld().setTime(plugin.getPluginConfig().getInt("singlePlayerSleepWakeUpTick"));
                if(event.getPlayer().getWorld().isThundering()){
                    event.getPlayer().getWorld().setThundering(false);
                    event.getPlayer().getWorld().setStorm(false);
                }
                //Broadcast that the player has slept.
                for(Player player : event.getPlayer().getWorld().getPlayers())
                {
                    player.sendMessage(event.getPlayer().getDisplayName() + " has slept. Good morning!");
                }
            }
        }, plugin.getPluginConfig().getInt("singlePlayerSleepSleepTicks"));
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event)
    {
        event.getPlayer().getServer().getScheduler().cancelTask(this.advanceTimeTaskId);
    }
}
=======
package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepListener implements Listener
{
    private final SeleniumCore plugin;
    private int advanceTimeTaskId;

    public SleepListener(SeleniumCore plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event)
    {
        //Fired when a player enters a bed
        if(event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK){return;}

        this.advanceTimeTaskId = this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
            @Override
            public void run()
            {
                event.getPlayer().getWorld().setTime(plugin.getPluginConfig().getInt("singlePlayerSleepWakeUpTick"));
                if(event.getPlayer().getWorld().isThundering()){
                    event.getPlayer().getWorld().setThundering(false);
                    event.getPlayer().getWorld().setStorm(false);
                }
                //Broadcast that the player has slept.
                for(Player player : event.getPlayer().getWorld().getPlayers())
                {
                    player.sendMessage(event.getPlayer().getDisplayName() + " has slept. Good morning!");
                }
            }
        },
                plugin.getPluginConfig().getInt("singlePlayerSleepSleepTicks"));
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event)
    {
        event.getPlayer().getServer().getScheduler().cancelTask(this.advanceTimeTaskId);
    }
}
>>>>>>> 1c1c4ae97a2faf67a1c13ee067b1743a237b4414:src/com/seleniummc/seleniumcore/listeners/SleepListener.java
