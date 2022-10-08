/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package Shop;

import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.Head;

public class Shop_items {
    public static ItemStack Heart() {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjg2OWJkZDlhOGY3N2VlZmY3NWQ4ZjY3ZWQwMzIyYmQ5YzE2ZGQ0OTQ5NzIzMTRlZDcwN2RkMTBhMzEzOWE1OCJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cHearts Trail");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Price: \u00a7e1000 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack smoke() {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg0YTY4ZmQ3YjYyOGQzMDk2NjdkYjdhNTU4NTViNTRhYmMyM2YzNTk1YmJlNDMyMTYyMTFiZTVmZTU3MDE0In19fQ=="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a77Smoke Trail");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Price: \u00a7e1000 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack ender() {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYThlMDc2OWQ4ZmY4Y2I5M2U1OGExZWM0YjI3ZTIzMDFmMDhjMDMyZjA4ODVkNDI1YjU5MjQ1YWJmZjM2ZGU5ZSJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a75End Trail");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Price: \u00a7e1000 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack FireTrail() {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzcxNzkzM2M0MGZiZjkzNmFhOTI4ODUxM2VmZTE5YmRhNDYwMWVmYzBlNGVjYWQyZTAyM2IwYzFkMjg0NDRiIn19fQ=="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a76Fire Trail");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Price: \u00a7e1000 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Slime() {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTAxY2U2ODg0MjA3NGRkZTA1MzE4NWIyMThlMzRlZTMyNTljYjM2YWM0NzFkODA5OThmOWNiMDFmMzJlNTFjNyJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a72Slime Trail");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Price: \u00a7e1000 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

