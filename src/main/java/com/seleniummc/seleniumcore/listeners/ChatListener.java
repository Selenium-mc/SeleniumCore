package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
import com.seleniummc.seleniumcore.utils.TextUtil;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatListener implements Listener
{
    private final SeleniumCore plugin;

    public ChatListener(SeleniumCore plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        // Send message
        event.setMessage(TextUtil.format(message));
    }
}
