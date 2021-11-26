package com.setupsafari.welcomemessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.setupsafari.welcomemessage.listeners.PlayerJoinListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);

    }

    private static Main instance;

    public static Main getInstance () {
        return Main.instance;
    }
}