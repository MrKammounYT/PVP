/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package Shop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopMenu {
    public static ItemStack Myinv() {
        ItemStack item = new ItemStack(Material.CHEST);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a72My Items");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack BowTrails() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cBow Trails");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Others() {
        ItemStack item = new ItemStack(Material.BEACON);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7eOthers");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack ArmorShop() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7aKit Upgrade");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Battlecry() {
        ItemStack item = new ItemStack(Material.JUKEBOX);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7bBattle Cry");
        item.setItemMeta(meta);
        return item;
    }
}

