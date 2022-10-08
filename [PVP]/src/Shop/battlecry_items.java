/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package Shop;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class battlecry_items {
    public static ItemStack xp() {
        ItemStack item = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7e\u00a7lLevel Up");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Play level up sound");
        lore.add("\u00a77Every Time You Kill a Person");
        lore.add("\u00a77Price: \u00a7e250 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack mewo() {
        ItemStack item = new ItemStack(Material.RAW_FISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7c\u00a7lMeow !");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Play Cat sound");
        lore.add("\u00a77Every Time You Kill a Person");
        lore.add("\u00a77Price: \u00a7e250 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

