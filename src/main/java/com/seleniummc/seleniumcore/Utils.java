package com.seleniummc.seleniumcore;

import org.bukkit.ChatColor;

public class Utils
{
    public static String format(String message)
    {
        // (?i) makes the regex case-insensitive

        // Emoticons
        message = message.replaceAll("(?i):shrug:", "¯\\\\_(ツ)_/¯");
        message = message.replaceAll("(?i):tableflip:", "(╯°□°）╯︵ ┻━┻");
        message = message.replaceAll("(?i):up(vote)?:", ChatColor.RED + ChatColor.BOLD.toString() + "↑");
        message = message.replaceAll("(?i):down(vote)?:", ChatColor.BLUE + ChatColor.BOLD.toString() + "↓");

        // Colors
        message = message.replaceAll("(?i):black:|&0", ChatColor.BLACK.toString());
        message = message.replaceAll("(?i):darkblue:|&1", ChatColor.DARK_BLUE.toString());
        message = message.replaceAll("(?i):darkgreen:|&2", ChatColor.DARK_GREEN.toString());
        message = message.replaceAll("(?i):darkaqua:|&3", ChatColor.DARK_AQUA.toString());
        message = message.replaceAll("(?i):darkred:|&4", ChatColor.DARK_RED.toString());
        message = message.replaceAll("(?i):darkpurple:|&5", ChatColor.DARK_PURPLE.toString());
        message = message.replaceAll("(?i):(gold|orange):|&6", ChatColor.GOLD.toString());
        message = message.replaceAll("(?i):gr[ae]y:|&7", ChatColor.GRAY.toString());
        message = message.replaceAll("(?i):darkgr[ae]y:|&8", ChatColor.DARK_GRAY.toString());
        message = message.replaceAll("(?i):blue:|&9", ChatColor.BLUE.toString());
        message = message.replaceAll("(?i):green:|&a", ChatColor.GREEN.toString());
        message = message.replaceAll("(?i):aqua:|&b", ChatColor.AQUA.toString());
        message = message.replaceAll("(?i):red:|&c", ChatColor.RED.toString());
        message = message.replaceAll("(?i):lightpurple:|&d", ChatColor.LIGHT_PURPLE.toString());
        message = message.replaceAll("(?i):yellow:|&e", ChatColor.YELLOW.toString());
        message = message.replaceAll("(?i):white:|&f", ChatColor.WHITE.toString());

        // Text Styles
        message = message.replaceAll("(?i):bold:|&l", ChatColor.BOLD.toString());
        message = message.replaceAll("(?i):italic:|&o", ChatColor.ITALIC.toString());
        message = message.replaceAll("(?i):(obfuscated|crazy|magic):|&k", ChatColor.MAGIC.toString());
        message = message.replaceAll("(?i):strike(through|thru)?:|&m", ChatColor.STRIKETHROUGH.toString());
        message = message.replaceAll("(?i):under(line)?:|&n", ChatColor.UNDERLINE.toString());
        message = message.replaceAll("(?i):reset:|&r", ChatColor.RESET.toString());

        return message;
    }
}
