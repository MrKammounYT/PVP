/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.ItemMeta
 */
package kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import src.main;

public class Emerald {
    public static void EmeraldKit(Player p) {
        PlayerInventory inv = p.getInventory();
        inv.setItem(0, Emerald.SwordEmerald(p));
        inv.setItem(1, Emerald.RodEmerald(p));
        inv.setItem(2, Emerald.BowEmerald(p));
        inv.setItem(3, Emerald.FlintEmerald(p));
        inv.setItem(8, Emerald.ArrowEmerald(p));
        inv.setHelmet(Emerald.helmetEmerald(p));
        inv.setChestplate(Emerald.chestplatEmerald(p));
        inv.setLeggings(Emerald.leggingsEmerald(p));
        inv.setBoots(Emerald.bootsEmerald(p));
    }

    static ItemStack helmetEmerald(Player p) {
        ItemStack item = new ItemStack(Material.IRON_HELMET);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&9Eagle Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack chestplatEmerald(Player p) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&9Eagle Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack leggingsEmerald(Player p) {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&9Eagle Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack bootsEmerald(Player p) {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&9Eagle Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack SwordEmerald(Player p) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&9Eagle Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack BowEmerald(Player p) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&9Eagle Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack ArrowEmerald(Player p) {
        ItemStack item = new ItemStack(Material.ARROW, 5);
        return item;
    }

    static ItemStack RodEmerald(Player p) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&9Eagle Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack FlintEmerald(Player p) {
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&9Eagle Kit"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§f  ");
        lore.add("§eFuel: §c" + (main.PlayerInfo.get(p.getName()).getFlint()-1));
        lore.add("§f§l   ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

