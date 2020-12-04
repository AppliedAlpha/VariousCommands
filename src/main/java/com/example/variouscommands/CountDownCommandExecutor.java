package com.example.variouscommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CountDownCommandExecutor implements CommandExecutor {
    private VariousCommands variousCommands;

    public CountDownCommandExecutor() { this.variousCommands = VariousCommands.getInstance(); }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            int counter = Integer.parseInt(args[0]);
            if (counter <= 0)
                throw new IllegalArgumentException();

            BukkitRunnable countTask = new CountTask(counter);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.AQUA + "CountDown Started!");
            }

            countTask.runTaskTimer(variousCommands, 0, 20L);

            return true;
        }
        catch (Exception e) {
            sender.sendMessage("Not Worked.");
            return false;
        }
    }
}
