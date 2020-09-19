package com.seleniummc.seleniumcore.listeners;

import com.seleniummc.seleniumcore.SeleniumCore;
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

        // Emoticons
        //   (?i) makes the target case insensitive
        message = message.replaceAll("(?i):shrug:", "¯\\_(ツ)_/¯");
        message = message.replaceAll("(?i):tableflip:", "(╯°□°）╯︵ ┻━┻");
        message = message.replaceAll("(?i):up:|:upvote:", ChatColor.RED+"↑");
        message = message.replaceAll("(?i):down:|:downvote:", ChatColor.BLUE+"↓");

        // Colors

        event.setMessage(message);
    }
}
