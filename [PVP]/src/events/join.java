/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  fr.minuskube.netherboard.Netherboard
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerJoinEvent
 */
package events;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.MySQL;
import MySQL.deaths;
import MySQL.points;
import OtherMysql.BattleCry;
import OtherMysql.Perks;
import PerksAndKits.Trails;
import PerksAndKits.battlecry;
import PerksAndKits.kits;
import PerksAndKits.others;
import fr.minuskube.netherboard.Netherboard;
import kits.Diamond;
import kits.Emerald;
import kits.Gold;
import kits.member;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import src.main;
import utils.PlayerInfo;
import utils.ScoreBoard;
import utils.locationAPI;

public class join
implements Listener {
    @EventHandler
    public void onjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        Netherboard.instance().createBoard(p, "board");
        if (!MySQL.isConnected()) {
            p.kickPlayer("\u00a7cServer run into a problem Try Again");
            Bukkit.getServer().shutdown();
        }
        if (!main.PlayerInfo.containsKey(p.getName())) {
            main.PlayerInfo.put(p.getName(), new PlayerInfo(null, null, null, null,1));
        }
        PlayerInfo pi = main.PlayerInfo.get(p.getName());
        p.getInventory().clear();
        p.setLevel(0);
        ScoreBoard.bord(p);
        pi.setflint(2);

        p.setFoodLevel(20);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 8.0f, 5.0f);
        try {
            p.teleport(locationAPI.getLocation("spawn"));
        }
        catch (Exception e0) {
            p.sendMessage("\u00a7cSpawn Is Not Set!");
        }
        if (p.hasPermission("eaglemc.eagle")) {
            pi.setPlayerKit(kits.emerald);
            p.getInventory().clear();
            Emerald.EmeraldKit(p);
        } else if (p.hasPermission("eaglemc.diamond")) {
            pi.setPlayerKit(kits.diamond);
            Diamond.DiamondKit(p);
        } else if (p.hasPermission("eaglemc.gold")) {
            pi.setPlayerKit(kits.gold);
            Gold.GoldKit(p);
        } else {
            pi.setPlayerKit(kits.member);
            member.memberKit(p);
        }
        if (!points.Playerexists(p.getUniqueId())) {
            deaths.createPlayer(p);
            Kills.createPlayer(p);
            points.createPlayer(p);
            Coins.createPlayer(p);
            OtherMysql.Trails.createPlayer(p);
            Perks.createPlayer(p);
            BattleCry.createPlayer(p);
            points.addpoints(p.getUniqueId(), 100);
            return;
        }
        if (OtherMysql.Trails.hasCT(p.getUniqueId())) {
            if (OtherMysql.Trails.getCt(p.getUniqueId()).equalsIgnoreCase("HEART")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Trail: \u00a7cHeart");
                pi.setPlayerTrail(Trails.hearts);
            } else if (OtherMysql.Trails.getCt(p.getUniqueId()).equalsIgnoreCase("FIRE")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Trail: \u00a76Fire");
                pi.setPlayerTrail(Trails.fire);
            } else if (OtherMysql.Trails.getCt(p.getUniqueId()).equalsIgnoreCase("SLIME")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Trail: \u00a72Slime");
                pi.setPlayerTrail(Trails.slime);
            } else if (OtherMysql.Trails.getCt(p.getUniqueId()).equalsIgnoreCase("ENDER")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Trail: \u00a75The End");
                pi.setPlayerTrail(Trails.end);
            } else if (OtherMysql.Trails.getCt(p.getUniqueId()).equalsIgnoreCase("SMOKE")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Trail: \u00a77Smoke");
                pi.setPlayerTrail(Trails.smoke);
            }
        }
        if (Perks.hasCT(p.getUniqueId())) {
            if (Perks.getCt(p.getUniqueId()).equalsIgnoreCase("TNTPERK")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Perk: \u00a7cTNT");
                pi.setKillStreakPerk(others.tnt);
            } else if (Perks.getCt(p.getUniqueId()).equalsIgnoreCase("WEBPERK")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Perk: \u00a7eCobWeb");
                pi.setKillStreakPerk(others.cobweb);
            } else if (Perks.getCt(p.getUniqueId()).equalsIgnoreCase("SPEEDPERK")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Perk: \u00a7aSpeed");
                pi.setKillStreakPerk(others.speed);
            }
        }
        if (BattleCry.hasCT(p.getUniqueId())) {
            if (BattleCry.getCt(p.getUniqueId()).equalsIgnoreCase("XP")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Battle Cry: \u00a7e\u00a7lXp");
                pi.setPlayerBattleCry(battlecry.levelup);
            } else if (BattleCry.getCt(p.getUniqueId()).equalsIgnoreCase("MEOW")) {
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7fCurrent Selected Battle Cry: \u00a7c\u00a7lMeow");
                pi.setPlayerBattleCry(battlecry.meow);
            }
        }
    }

    public String color(String p) {
        return ChatColor.translateAlternateColorCodes((char)'&', (String)p);
    }
}

