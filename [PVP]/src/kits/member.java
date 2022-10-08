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

public class member {
    public static void memberKit(Player p) {
        PlayerInventory inv = p.getInventory();
        inv.setItem(0, member.Sword(p));
        inv.setItem(1, member.Rod(p));
        inv.setItem(2, member.Bow(p));
        inv.setItem(3, member.Flint(p));
        inv.setItem(8, member.Arrow(p));
        inv.setHelmet(member.helmet(p));
        inv.setChestplate(member.chestplate(p));
        inv.setLeggings(member.leggings(p));
        inv.setBoots(member.boots(p));
    }

    static ItemStack helmet(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&7Member Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack chestplate(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&7Member Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack leggings(Player p) {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&7Member Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack boots(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&7Member Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack Sword(Player p) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&7Member Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack Bow(Player p) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&7Member Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack Arrow(Player p) {
        ItemStack item = new ItemStack(Material.ARROW, 5);
        return item;
    }

    static ItemStack Rod(Player p) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&7Member Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack Flint(Player p) {
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&7Member Kit"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§f  ");
        lore.add("§eFuel: §c" + (main.PlayerInfo.get(p.getName()).getFlint()-1));
        lore.add("§f§l   ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

