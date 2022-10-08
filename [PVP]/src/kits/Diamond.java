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

public class Diamond {
    public static void DiamondKit(Player p) {
        PlayerInventory inv = p.getInventory();
        inv.setItem(0, Diamond.SwordDiamond(p));
        inv.setItem(1, Diamond.RodDiamond(p));
        inv.setItem(2, Diamond.BowDiamond(p));
        inv.setItem(3, Diamond.FlintDiamond(p));
        inv.setItem(8, Diamond.ArrowDiamond(p));
        inv.setHelmet(Diamond.helmetDiamond(p));
        inv.setChestplate(Diamond.chestplatDiamond(p));
        inv.setLeggings(Diamond.leggingsDiamond(p));
        inv.setBoots(Diamond.bootsDiamond(p));
    }

    private static ItemStack helmetDiamond(Player p) {
        ItemStack item = new ItemStack(Material.IRON_HELMET);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&bDiamond Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    private static ItemStack chestplatDiamond(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&bDiamond Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    private static ItemStack leggingsDiamond(Player p) {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&bDiamond Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    private static ItemStack bootsDiamond(Player p) {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta armor = item.getItemMeta();
        armor.setDisplayName(main.color("&bDiamond Kit"));
        armor.spigot().setUnbreakable(true);
        item.setItemMeta(armor);
        return item;
    }

    private static ItemStack SwordDiamond(Player p) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&bDiamond Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack BowDiamond(Player p) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&bDiamond Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack ArrowDiamond(Player p) {
        ItemStack item = new ItemStack(Material.ARROW, 5);
        return item;
    }

    private static ItemStack RodDiamond(Player p) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&bDiamond Kit"));
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack FlintDiamond(Player p) {
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(main.color("&bDiamond Kit"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§f  ");
        lore.add("§eFuel: §c" + (main.PlayerInfo.get(p.getName()).getFlint()-1));
        lore.add("§f§l   ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

