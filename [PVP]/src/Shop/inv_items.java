/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package Shop;

import PerksAndKits.Trails;
import PerksAndKits.battlecry;
import PerksAndKits.kits;
import PerksAndKits.others;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import src.main;
import utils.Glow;
import utils.Head;

public class inv_items {
    public static ItemStack Myinv() {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a74My Bow Trails");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Myinv2() {
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cMy Perks");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Myinv3() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7eMy kits");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack returnpage() {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7e\u2199Go Back");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack memberkit(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a77Member Kit");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.member)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a77");
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a7f");
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
            lore.add("\u00a76");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack vipkit(Player p) {
        ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a76Gold Kit");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.gold)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a77");
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a7f");
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
            lore.add("\u00a76");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack mvpkit(Player p) {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a79Eagle Kit");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.emerald)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a77");
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a7f");
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
            lore.add("\u00a76");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack vipPluskit(Player p) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7bDiamond Kit");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerCurrentKit(kits.diamond)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a77");
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a7f");
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
            lore.add("\u00a76");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack vipkit() {
        ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a76Buy Gold Kit");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Get a Permanent Vip Kit");
        lore.add("\u00a77Price: \u00a7e750 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack myTnt(Player p) {
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7eTNT \u00a77(Right Click To Select\u00a77)");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerKillStreakPerk(others.tnt)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack myspeed(Player p) {
        ItemStack item = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7aSpeed \u00a77(Right Click To Select\u00a77)");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerKillStreakPerk(others.speed)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack myweb(Player p) {
        ItemStack item = new ItemStack(Material.WEB);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7eCOBWEB  \u00a77(Right Click To Select\u00a77)");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerKillStreakPerk(others.cobweb)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
            lore.add("\u00a76");
        } else {
            lore.add("\u00a76Currently: \u00a7cNot Selected");
            lore.add("\u00a77Click to Set current Perk");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack tnt() {
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cTnT");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Get an instant tnt Every 5 kills");
        lore.add("\u00a77Price: \u00a7e500 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack speed() {
        ItemStack item = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7aSpeed");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Get an Speed II For 5 Second Every 5 Kills");
        lore.add("\u00a77Price: \u00a7e500 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack web() {
        ItemStack item = new ItemStack(Material.WEB);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cCobWeb");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("\u00a77Get an CobWeb Every 5 kills");
        lore.add("\u00a77That Last for 7 seconds");
        lore.add("\u00a77Price: \u00a7e500 Coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack glass() {
        ItemStack item = new ItemStack(Material.getMaterial((int)160), 1, (short) 0);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cYou Don't Own This Item");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack FireEffect(Player p) {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzcxNzkzM2M0MGZiZjkzNmFhOTI4ODUxM2VmZTE5YmRhNDYwMWVmYzBlNGVjYWQyZTAyM2IwYzFkMjg0NDRiIn19fQ=="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a76Fire-Trail");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.fire)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Slime(Player p) {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTAxY2U2ODg0MjA3NGRkZTA1MzE4NWIyMThlMzRlZTMyNTljYjM2YWM0NzFkODA5OThmOWNiMDFmMzJlNTFjNyJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a72Slime-Trail");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.slime)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Smoke(Player p) {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg0YTY4ZmQ3YjYyOGQzMDk2NjdkYjdhNTU4NTViNTRhYmMyM2YzNTk1YmJlNDMyMTYyMTFiZTVmZTU3MDE0In19fQ=="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a77Smoke-Trail");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.smoke)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Ender(Player p) {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYThlMDc2OWQ4ZmY4Y2I5M2U1OGExZWM0YjI3ZTIzMDFmMDhjMDMyZjA4ODVkNDI1YjU5MjQ1YWJmZjM2ZGU5ZSJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a75End-Trail");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.end)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack Heart(Player p) {
        ItemStack item = new ItemStack(Head.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjg2OWJkZDlhOGY3N2VlZmY3NWQ4ZjY3ZWQwMzIyYmQ5YzE2ZGQ0OTQ5NzIzMTRlZDcwN2RkMTBhMzEzOWE1OCJ9fX0="));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7cHearts-Trail");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.hearts)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack xp(Player p) {
        ItemStack item = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7e\u00a7lLevel-Up");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerBattleCry(battlecry.levelup)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack mewo(Player p) {
        ItemStack item = new ItemStack(Material.RAW_FISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7c\u00a7lMeow");
        ArrayList<String> lore = new ArrayList<String>();
        if (main.PlayerInfo.get(p.getName()).getPlayerBattleCry(battlecry.meow)) {
            Glow glow = new Glow(70);
            meta.addEnchant((Enchantment)glow, 1, true);
            lore.add("\u00a76Currently: \u00a7aSelected");
        } else {
            lore.add("\u00a77Click to Set current Item");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack glass2() {
        ItemStack item = new ItemStack(Material.getMaterial((int)160), 1, (short) 15);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a77\u00a7l");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack juke() {
        ItemStack item = new ItemStack(Material.JUKEBOX);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("\u00a7bBattle-Cry");
        item.setItemMeta(meta);
        return item;
    }
}

