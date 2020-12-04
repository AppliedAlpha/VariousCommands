package com.example.variouscommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CountTask extends BukkitRunnable {
    private int counter;

    public CountTask(int arg) {
        this.counter = arg;
    }

    @Override
    public void run() {
        String message = ChatColor.RED + Integer.toString(counter);
        if (counter > 1)
            message += " seconds left!";
        else if (counter == 1)
            message += " second left!";
        else if (counter == 0)
            message = ChatColor.GREEN + "Time's Up!";

        if (counter <= 10) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(message);
            }
        }
        if (counter > 0) counter--;
        else this.cancel();
    }
}
