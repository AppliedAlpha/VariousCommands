package com.example.variouscommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TpAllCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args.length != 1) throw new Exception();
            String sendCommand = "tp @a " + args[0];
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), sendCommand);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
