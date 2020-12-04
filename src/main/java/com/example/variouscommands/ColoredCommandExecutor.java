package com.example.variouscommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColoredCommandExecutor implements CommandExecutor {
    ChatColor[] list = {ChatColor.AQUA, ChatColor.BLUE, ChatColor.GOLD,
            ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED,
            ChatColor.YELLOW, ChatColor.WHITE};

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args.length < 2) throw new Exception();
            ChatColor textColor = list[Integer.parseInt(args[0])];

            StringBuilder text = new StringBuilder();
            text.append(textColor);

            for (int i=1; i<args.length; i++) {
                text.append(args[i]);
            }

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(text.toString());
            }
            return true;
        }
        catch (Exception e) {
            sender.sendMessage("Not Worked.");
            sender.sendMessage("AQUA, BLUE, GOLD, GREEN, LIGHT_PURPLE, RED, YELLOW, WHITE");
            return false;
        }
    }
}
