package com.setupsafari.welcomemessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.setupsafari.welcomemessage.listeners.PlayerJoinListener;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Main.instance = this;
        if(!(this.getConfig().getBoolean("modules.join")) && !(this.getConfig().getBoolean("modules.motd"))){
            this.getLogger().info("No modules enabled, disabling plugin.");
            this.getPluginLoader().disablePlugin(this);
        }
        else Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }


    public static Main getInstance () {
        return Main.instance;
    }
}