/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.GameMode
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.event.player.PlayerRespawnEvent
 *  org.bukkit.inventory.ItemStack
 */
package events;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.deaths;
import MySQL.points;
import PerksAndKits.battlecry;
import PerksAndKits.kits;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import kits.Diamond;
import kits.Emerald;
import kits.Gold;
import kits.member;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import src.main;
import utils.ScoreBoard;
import utils.locationAPI;
import utils.titles;

public class Dead
implements Listener {
    @EventHandler
    public void ondeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.setDeathMessage(null);
        e.getDrops().clear();
        e.setDroppedExp(0);
        if (e.getEntity().getKiller() != null) {
            Player k = e.getEntity().getKiller();
            DecimalFormat df = new DecimalFormat("##.##");
            String health = df.format(k.getHealth() / 2.0);
            int tot = points.getpoints(p.getUniqueId()) * 5 / 100;
            p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Been Killed By \u00a7c" + k.getName());
            p.sendMessage(String.valueOf(main.prefix) + "\u00a7eWith \u00a7c" + health + " \u00a7c\u2764 \u00a7eAnd You Lost \u00a7c" + tot + " \u2742");
            if (tot == 0) {
                points.addpoints(k.getUniqueId(), 5);
                k.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Killed \u00a7e" + p.getName());
                k.sendMessage(String.valueOf(main.prefix) + "\u00a7aWith \u00a7c" + health + " \u00a7c\u2764 \u00a7aAnd you Got \u00a7e5 \u2742");
            } else {
                k.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Killed \u00a7e" + p.getName());
                k.sendMessage(String.valueOf(main.prefix) + "\u00a7aWith \u00a7c" + health + " \u00a7c\u2764 \u00a7aAnd you Got \u00a7e" + tot + " \u2742");
                points.addpoints(k.getUniqueId(), tot);
                points.removepoints(p.getUniqueId(), tot);
            }
            Random rd = new Random();
            int coins = rd.nextInt(8);
            Coins.addcoins(k.getUniqueId(), coins);
            titles.sendActionBar(k, main.color("&a+ &f" + coins + "&c\u2707"));
            deaths.adddeaths(p.getUniqueId(), 1);
            main.PlayerInfo.get(k.getName()).addPlayerKillStreak(k, 1);
            main.PlayerInfo.get(p.getName()).setPlayerKillStreak(0);
            main.PlayerInfo.get(k.getName()).setflint(main.PlayerInfo.get(k.getName()).getFlint() + 1);
            main.PlayerInfo.get(p.getName()).setflint(1);
            
            Kills.addkills(k.getUniqueId(), 1);
            if (main.PlayerInfo.get(k.getName()).getPlayerBattleCry(battlecry.levelup)) {
                k.playSound(k.getLocation(), Sound.LEVEL_UP, 6.0f, 5.0f);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 6.0f, 5.0f);
            }
            else  if (main.PlayerInfo.get(k.getName()).getPlayerBattleCry(battlecry.meow)) {
                k.playSound(k.getLocation(), Sound.CAT_MEOW, 6.0f, 5.0f);
                p.playSound(p.getLocation(), Sound.CAT_MEOW, 6.0f, 5.0f);
            }
            
            k.setHealth(20.0);
            updateflint(k);
            k.setFireTicks(0);
            k.setHealth(20.0);
            ScoreBoard.bord(k);
            k.getInventory().addItem(new ItemStack[]{new ItemStack(Material.ARROW, 2)});
            return;
        }
        p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Died!");
        deaths.adddeaths(p.getUniqueId(), 1);
    }

    @EventHandler
    public void onrespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        e.setRespawnLocation(locationAPI.getLocation("spawn"));
        p.setGameMode(GameMode.SURVIVAL);
        p.setFoodLevel(20);
        p.setHealth(20.0);
        ScoreBoard.bord(p);
        p.setLevel(0);
        p.getInventory().clear();
        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0f, 3.0f);
        if (main.PlayerInfo.get(p.getName()).HasSavedInv()) {
            p.getInventory().setArmorContents(main.PlayerInfo.get(p.getName()).getPlayerArmor(p));
            p.getInventory().setContents(main.PlayerInfo.get(p.getName()).getPlayeritems(p));
            return;
        }
        if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.emerald)) {
            Emerald.EmeraldKit(p);
        } else if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.diamond)) {
            Diamond.DiamondKit(p);
        } else if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.gold)) {
            Gold.GoldKit(p);
        } else if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.member)) {
            member.memberKit(p);
        } else if (p.hasPermission("eaglemc.mvp")) {
            Emerald.EmeraldKit(p);
        } else if (p.hasPermission("eaglemc.vip+")) {
            Diamond.DiamondKit(p);
        } else if (p.hasPermission("eaglemc.vip")) {
            Gold.GoldKit(p);
        } else {
            member.memberKit(p);
        }
    }

    public static String color(String ff) {
        return ChatColor.translateAlternateColorCodes((char)'\u00a7', (String)ff);
    }
    public void updateflint(Player p) {
    	for(int i=0;i<p.getInventory().getSize();i++) {
    		if(p.getInventory().getItem(i) == null)return;
    		ItemStack item = p.getInventory().getItem(i);
    		if(item.getType() == Material.FLINT_AND_STEEL) {
    		ItemMeta meta = item.getItemMeta();
    		ArrayList<String> lore = new ArrayList<>();
            lore.add("§f  ");
            lore.add("§eFuel: §c" + main.PlayerInfo.get(p.getName()).getFlint());
            lore.add("§f§l   ");
            meta.setLore(lore);
            item.setItemMeta(meta);
            p.getInventory().setItem(i, item);
    		}
    	}
		
		
	}
}

