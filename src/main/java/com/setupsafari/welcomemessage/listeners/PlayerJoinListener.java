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
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(final @NotNull PlayerJoinEvent event) {
        @NotNull final String joinMessage = Main.getInstance().getConfig().getString("messages.join-message");
        @NotNull final String motdMessage = Main.getInstance().getConfig().getString("messages.motd-message");

        @NotNull final Player player = event.getPlayer();
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                joinMessage.replaceAll("%player%", player.getDisplayName())));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                motdMessage.replaceAll("%player%    ", player.getDisplayName())));
    }
}