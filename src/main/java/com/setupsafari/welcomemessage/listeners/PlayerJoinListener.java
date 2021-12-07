package com.setupsafari.welcomemessage.listeners;

import com.setupsafari.welcomemessage.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {
    
    final Main instance = Main.getInstance();
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(final @NotNull PlayerJoinEvent event) {

        @NotNull final Player player = event.getPlayer();
        if(instance.getConfig().getBoolean("modules.join")) {
            @NotNull final String joinMessage = Main.getInstance().getConfig().getString("messages.join-message");
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                joinMessage.replaceAll("%player%", player.getDisplayName())));
        }
        if(instance.getConfig().getBoolean("modules.motd")) {
            @NotNull final String motdMessage = Main.getInstance().getConfig().getString("messages.motd-message");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                motdMessage.replaceAll("%player%", player.getDisplayName())));
        }
    }
}
