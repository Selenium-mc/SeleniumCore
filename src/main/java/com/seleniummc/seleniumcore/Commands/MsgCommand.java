package com.seleniummc.seleniumcore.commands;

import com.seleniummc.seleniumcore.SeleniumCore;
import com.seleniummc.seleniumcore.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class MsgCommand implements CommandExecutor
{
    private final SeleniumCore plugin;

    public MsgCommand(SeleniumCore plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length >= 2) {
            if (Bukkit.getPlayerExact(args[0]) != null) {
                String message = Utils.format(String.join(" ", Arrays.copyOfRange(args, 1, args.length)));
                Player target = Bukkit.getPlayer(args[0]);

                sender.sendMessage(String.format(ChatColor.DARK_PURPLE+"[TO: %s] "+ChatColor.RESET+"%s", args[0], message));
                target.sendMessage(String.format(ChatColor.DARK_PURPLE+"[FROM: %s] "+ChatColor.RESET+"%s", sender.getName(), message));
                return true;
            }
            sender.sendMessage(String.format(ChatColor.RED+"%s is either offline or doesn't exist!", args[0]));
            return false;
        }
        sender.sendMessage(ChatColor.RED+"Syntax: /pm <player> <message>");

        return false;
    }
}
