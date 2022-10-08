/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.World
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package src;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.MySQL;
import MySQL.deaths;
import MySQL.points;
import OtherMysql.BattleCry;
import OtherMysql.Perks;
import OtherMysql.Trails;
import Shop.Interact;
import Shop.inventory;
import cmd.PlayerCommand;
import cmd.pvp;
import cooldowns.LeaderBoard;
import events.BlockPlaceEvent;
import events.BowTrail_event;
import events.Chat;
import events.Dead;
import events.Flint;
import events.join;
import events.others;
import events.quit;
import java.sql.SQLException;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import utils.Glow;
import utils.PlayerInfo;

public class main
extends JavaPlugin {
    public static HashMap<String, PlayerInfo> PlayerInfo = new HashMap();
    public static String prefix = main.color("\u00a73PvP \u00a77\u00bb ");
    public static String noperms = main.color("&cSorry But You Don`t Have Permission To Use this command!");
    private static main instance;

    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        Glow.registerGlow();
        try {
            MySQL.connect();
        }
        catch (ClassNotFoundException | SQLException e) {
            Bukkit.getConsoleSender().sendMessage("\u00a7cData Base not connected!");
        }
        if (MySQL.isConnected()) {
            Bukkit.getConsoleSender().sendMessage("\u00a7aData Base Is connected");
        }
        Kills.createTable();
        points.createTable();
        deaths.createTable();
        Coins.createTable();
        BattleCry.createTable();
        Perks.createTable();
        Trails.createTable();
        Bukkit.getConsoleSender().sendMessage("\u00a7cPvP 2.0 &fWas Enabled ");
        Bukkit.getConsoleSender().sendMessage("\u00a7cSrkammounYT Was Here ");
        this.register();
        this.getCommand("ps").setExecutor(new PlayerCommand());
        this.getCommand("pvp").setExecutor(new pvp());
        this.getCommand("save").setExecutor(new PlayerCommand());
        this.getCommand("spawn").setExecutor(new PlayerCommand());
        this.getCommand("stats").setExecutor(new PlayerCommand());
        LeaderBoard board = new LeaderBoard();
        board.runTaskTimer(this, 0L, 20L);
        for (World w : Bukkit.getWorlds()) {
            w.setAnimalSpawnLimit(0);
            w.setMonsterSpawnLimit(0);
            w.setWeatherDuration(0);
            w.setStorm(false);
            w.setThundering(false);
            w.setTime(100);
            w.setFullTime(100);
        }
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("\u00a7cPvP 2.0 &fWas Disabled ");
        Bukkit.getConsoleSender().sendMessage("\u00a7cSrkammounYT Was Here ");
    }

    public static main getInstance() {
        return instance;
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(new join(), this);
        Bukkit.getPluginManager().registerEvents(new quit(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new Dead(), this);
        Bukkit.getPluginManager().registerEvents(new BowTrail_event(), this);
        Bukkit.getPluginManager().registerEvents(new Interact(), this);
        Bukkit.getPluginManager().registerEvents(new inventory(), this);
        Bukkit.getPluginManager().registerEvents(new others(), this);
        Bukkit.getPluginManager().registerEvents(new Flint(), this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);


    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes((char)'&', (String)s);
    }
}

