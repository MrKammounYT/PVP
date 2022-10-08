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

public class Gold {
    public static void GoldKit(Player p) {
        PlayerInventory inv = p.getInventory();
        inv.setItem(0, Gold.SwordGold(p));
        inv.setItem(1, Gold.RodGold(p));
        inv.setItem(2, Gold.BowGold(p));
        inv.setItem(3, Gold.FlintGold(p));
        inv.setItem(8, Gold.ArrowGold(p));
        inv.setHelmet(Gold.helmetGold(p));
        inv.setChestplate(Gold.chestplateGold(p));
        inv.setLeggings(Gold.leggingsGold(p));
        inv.setBoots(Gold.bootsGold(p));
    }

    static ItemStack helmetGold(Player p) {
        ItemStack item = new ItemStack(Material.IRON_HELMET);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&6Gold Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack chestplateGold(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&6Gold Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack leggingsGold(Player p) {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&6Gold Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack bootsGold(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&6Gold Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    static ItemStack SwordGold(Player p) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&6Gold Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack BowGold(Player p) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&6Gold Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack ArrowGold(Player p) {
        ItemStack item = new ItemStack(Material.ARROW, 5);
        return item;
    }

    static ItemStack ArrowGoldD(Player p) {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        return item;
    }

    static ItemStack RodGold(Player p) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&6Gold Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    static ItemStack FlintGold(Player p) {
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&6Gold Kit"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§f  ");
        lore.add("§eFuel: §c" + (main.PlayerInfo.get(p.getName()).getFlint()-1));
        lore.add("§f§l   ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

