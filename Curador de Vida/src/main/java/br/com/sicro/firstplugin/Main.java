package br.com.sicro.firstplugin;

import br.com.sicro.firstplugin.commands.FirstCommand;
import br.com.sicro.firstplugin.listeners.SicroListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getCommand("curar").setExecutor(new FirstCommand());
        System.out.println("Plugin de Cura ligado! Feito por pedrinpvp_YT");
        this.getServer().getPluginManager().registerEvents(new SicroListener(),this);
    }

    @Override
    public void onDisable() {
    }

    // plugin feito por pedrinpvp_YT
}
