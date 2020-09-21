package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
import com.seleniummc.seleniumcore.Utils;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;

public class ChatListener implements Listener
{
    private final SeleniumCore plugin;

    public ChatListener(SeleniumCore plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        // Send message
        event.setMessage(Utils.format(message));
    }
}
