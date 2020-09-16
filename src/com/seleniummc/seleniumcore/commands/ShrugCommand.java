package com.seleniummc.seleniumcore.commands;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShrugCommand implements CommandExecutor
{
    private static final String SHRUG = "¯\\_(ツ)_/¯";

    private final SeleniumCore plugin;

    public ShrugCommand(SeleniumCore plugin) { this.plugin = plugin; }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if ( !(sender instanceof Player) ) {
            sender.sendMessage(ChatColor.RED + "You must be a player to be able to use this command.");
        }

        Player p = (Player) sender;
        if (args.length == 0) {
            p.chat(SHRUG);
        } else {
            p.chat(String.join(" ", args) + " " + SHRUG);
        }

        return true;
    }
}