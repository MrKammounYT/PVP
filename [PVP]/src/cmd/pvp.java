/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.inventory.meta.SkullMeta
 */
package cmd;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.deaths;
import MySQL.points;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import src.main;
import utils.Prefix;
import utils.ScoreBoard;
import utils.locationAPI;

public class pvp
implements CommandExecutor {
    public static HashMap<Player, String> reset = new HashMap<Player, String>();
    public static ArrayList<Player> build = new ArrayList<Player>();

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("pvp.admin")) {
                if (args.length == 1) {
                    String tact = args[0];
                    if (tact.equalsIgnoreCase("setspawn")) {
                        locationAPI.setLocation(p.getLocation(), "spawn");
                        p.sendMessage(String.valueOf(main.prefix) + main.color("&aSpawn &fHas Been Set!"));
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 3.0f);
                    } else if (tact.equalsIgnoreCase("setshop")) {
                        locationAPI.setLocation(p.getLocation(), "shop");
                        p.sendMessage(String.valueOf(main.prefix) + main.color("&aShop &fHas Been Set!"));
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 3.0f);
                        Location lc = p.getLocation();
                        Skeleton v = (Skeleton)p.getLocation().getWorld().spawn(p.getLocation(), Skeleton.class);
                        net.minecraft.server.v1_8_R3.Entity nmc = ((CraftEntity)v).getHandle();
                        v.setCustomName("\u00a7a\u00a7lShop");
                        v.setCustomNameVisible(true);
                        v.setCanPickupItems(false);
                        nmc.setPositionRotation(lc.getX(), lc.getY(), lc.getZ(), lc.getYaw(), lc.getPitch());
                        NBTTagCompound tag = nmc.getNBTTag();
                        if (tag == null) {
                            tag = new NBTTagCompound();
                        }
                        nmc.c(tag);
                        tag.setInt("NoAI", 1);
                        nmc.f(tag);
                    } else if (tact.equalsIgnoreCase("deleteshop")) {
                        for (Entity sk : locationAPI.getLocation("shop").getWorld().getEntities()) {
                            if (sk.getType() != EntityType.SKELETON || !sk.getCustomName().equalsIgnoreCase("\u00a7a\u00a7lShop")) continue;
                            Skeleton s = (Skeleton)sk;
                            s.setHealth(0.0);
                            p.sendMessage(String.valueOf(main.prefix) + "\u00a7cShop Has Been Deleted");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 3.0f);
                        }
                    } else if (tact.equalsIgnoreCase("settopkills")) {
                        double x = 0.4;
                        locationAPI.setLocation(p.getLocation(), "topkills");
                        ArmorStand leaderboard = (ArmorStand)p.getWorld().spawnEntity(p.getLocation().add(0.0, 1.4, 0.0), EntityType.ARMOR_STAND);
                        leaderboard.setVisible(false);
                        leaderboard.setCanPickupItems(true);
                        leaderboard.setSmall(true);
                        leaderboard.setGravity(false);
                        leaderboard.setCustomName("\u00a7fLeaderboard - \u00a7aSorted By Kills");
                        leaderboard.setCustomNameVisible(true);
                        int i = 1;
                        while (i <= 10) {
                            ArmorStand yellow = (ArmorStand)p.getWorld().spawnEntity(p.getLocation().add(0.0, 1.0 - x * (double)i, 0.0), EntityType.ARMOR_STAND);
                            yellow.setVisible(false);
                            yellow.setCanPickupItems(true);
                            yellow.setSmall(true);
                            yellow.setGravity(false);
                            yellow.setCustomName(Kills.gettop(i));
                            yellow.setCustomNameVisible(true);
                            ++i;
                        }
                    } else if (tact.equalsIgnoreCase("settoppoints")) {
                        double x = 0.4;
                        locationAPI.setLocation(p.getLocation(), "toppoints");
                        ArmorStand leaderboard = (ArmorStand)p.getWorld().spawnEntity(p.getLocation().add(0.0, 1.4, 0.0), EntityType.ARMOR_STAND);
                        leaderboard.setVisible(false);
                        leaderboard.setCanPickupItems(true);
                        leaderboard.setSmall(true);
                        leaderboard.setGravity(false);
                        leaderboard.setCustomName("\u00a7fLeaderboard - \u00a7aSorted By Points");
                        leaderboard.setCustomNameVisible(true);
                        int i = 1;
                        while (i <= 10) {
                            ArmorStand yellow = (ArmorStand)p.getWorld().spawnEntity(p.getLocation().add(0.0, 1.0 - x * (double)i, 0.0), EntityType.ARMOR_STAND);
                            yellow.setVisible(false);
                            yellow.setCanPickupItems(true);
                            yellow.setSmall(true);
                            yellow.setGravity(false);
                            yellow.setCustomName(points.gettop(i));
                            yellow.setCustomNameVisible(true);
                            ++i;
                        }
              
                    } else if (tact.equalsIgnoreCase("help")) {
                        p.sendMessage("\u00a77------------------------------------------");
                        p.sendMessage("      \u00a73Help PVP      ");
                        p.sendMessage("\u00a7f/pvp \u00a7asetspawn ");
                        p.sendMessage("\u00a7f/pvp \u00a7asetshop  ");
                        p.sendMessage("\u00a7f/pvp \u00a7adeleteshop");
                        p.sendMessage("\u00a7f/pvp \u00a7asettopkills");
                        p.sendMessage("\u00a7f/pvp \u00a7asettoppoints");
                        p.sendMessage("\u00a7f/pvp \u00a7abuild    ");
                        p.sendMessage("\u00a7f/pvp \u00a7aaddcoins [amount]  ");
                        p.sendMessage("\u00a7f/pvp \u00a7areset [Player]  ");
                        p.sendMessage("\u00a7f/pvp \u00a7aaddcoins [amount] [Player]  ");
                        p.sendMessage("\u00a77------------------------------------------");
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("addcoins")) {
                        String f = args[1];
                        int x = Integer.parseInt(f);
                        Coins.addcoins(p.getUniqueId(), x);
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7e" + x + " \u00a76Coins \u00a7aHave been added to your account!");
                        ScoreBoard.bord(p);
                    } else if (args[0].equalsIgnoreCase("reset")) {
                        String target = args[1];
                        if (Bukkit.getPlayer((String)target) != null) {
                            Player t = Bukkit.getPlayer((String)target);
                            if (t.hasPermission("pvp.admin")) {
                                p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou cant reset This Player stats");
                                return true;
                            }
                            Inventory inv = Bukkit.createInventory(null, (int)27, (String)("\u00a76Reset \u00a7c" + target + " \u00a76Profile?"));
                            inv.setItem(4, this.createskull(t));
                            inv.setItem(11, this.yes());
                            inv.setItem(15, this.no());
                            p.openInventory(inv);
                        } else {
                            p.sendMessage(String.valueOf(main.prefix) + "\u00a7cPlayer need To Be Online To Do this");
                        }
                    }
                } else if (args.length == 3 && args[0].equalsIgnoreCase("addcoins")) {
                    String name = args[1];
                    if (Bukkit.getPlayer((String)name) != null) {
                        String f = args[3];
                        int x = Integer.parseInt(f);
                        Player t = Bukkit.getPlayer((String)name);
                        Coins.addcoins(t.getUniqueId(), x);
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7e" + x + " \u00a76Coins \u00a7aHave been added to \u00a7a" + t.getName() + " \u00a76account!");
                        ScoreBoard.bord(t);
                    } else {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cThis Player isnt online");
                    }
                }
            } else {
                p.sendMessage(main.noperms);
            }
        }
        return false;
    }

    public ItemStack createskull(Player p) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("\u00a76Profile: " + Prefix.getPrefix(p));
        ArrayList<String> list = new ArrayList<String>();
        list.add("\u00a7eKills\u00a77:\u00a76 " + Kills.getKills(p.getUniqueId()));
        list.add("\u00a7eDeaths\u00a77:\u00a76 " + deaths.getdeaths(p.getUniqueId()));
        list.add("\u00a7ePoints\u00a77:\u00a76 " + points.getpoints(p.getUniqueId()));
        list.add("\u00a7eStatue: \u00a7aOnline");
        meta.setLore(list);
        meta.setOwner(p.getName());
        item.setItemMeta((ItemMeta)meta);
        return item;
    }

    public ItemStack yes() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 13);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7aYes \u00a77(To Reset Profile)");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack no() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 14);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cNo \u00a77(Dont Reset Profile)");
        item.setItemMeta(meta);
        return item;
    }
}

