package com.example.variouscommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args.length != 2) throw new Exception();
            int from = Integer.parseInt(args[0]);
            int to = Integer.parseInt(args[1]);

            if (from > to) throw new Exception();

            Random random = new Random(); // 1 ~ 8
            int result = random.nextInt(to - from + 1) + from;
            String resultMessage = ChatColor.AQUA + "Result is " + result + "!";

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(resultMessage);
            }
            return true;
        }
        catch (Exception e) {
            sender.sendMessage("Not Worked.");
            return false;
        }
    }
}
