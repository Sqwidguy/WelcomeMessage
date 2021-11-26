package com.setupsafari.welcomemessage.commands;

import com.setupsafari.welcomemessage.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

// remember to register this in plugin.yml
public class RootCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final String message = Main.getInstance().getConfig().getString("messages.from-command");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        return true;
    }
}
