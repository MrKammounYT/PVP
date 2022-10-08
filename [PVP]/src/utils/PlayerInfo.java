/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package utils;

import PerksAndKits.Trails;
import PerksAndKits.battlecry;
import PerksAndKits.kits;
import PerksAndKits.others;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import src.main;
import utils.Prefix;

public class PlayerInfo {
    private battlecry battlecry = null;
    private Trails trail = null;
    private others other = null;
    private kits kit = null;
    private int killstreaks = 0;
    private Player lastTager = null;
    private boolean HasSavedInv = false;
    private int flint;
    private ItemStack[] armor;
    private ItemStack[] items;

    public PlayerInfo(battlecry bt, Trails t, others o, kits k,int flint) {
        this.battlecry = bt;
        this.trail = t;
        this.other = o;
        this.kit = k;
        this.flint = flint;
    }

    public void savePlayerArmor(Player p) {
        this.armor = p.getInventory().getArmorContents();
    }

    public void savePlayerItems(Player p) {
        this.items = p.getInventory().getContents();
    }

    public ItemStack[] getPlayerArmor(Player p) {
        return this.armor;
    }

    public ItemStack[] getPlayeritems(Player p) {
        return this.items;
    }
    public int getFlint() {
    	return flint;
    }

    public Player getLastTager() {
        return this.lastTager;
    }

    public boolean HasSavedInv() {
        return this.HasSavedInv;
    }

    public boolean getPlayerBattleCry(battlecry b) {
        return this.battlecry == b;
    }

    public boolean getPlayerTrail(Trails t) {
        return this.trail == t;
    }

    public boolean getPlayerKillStreakPerk(others o) {
        return this.other == o;
    }

    public boolean getPlayerCurrentKit(kits k) {
        return this.kit == k;
    }

    public void setHasSavedInv(boolean d) {
        this.HasSavedInv = d;
    }

    public int getPlayerStreaks() {
        return this.killstreaks;
    }

    public void setLastTager(Player k) {
        this.lastTager = k;
    }

    public void addflint(int amount) {
    	flint +=amount;
    }
    public void removeflint(int amount) {
    	flint -= amount;
    }
    public void addPlayerKillStreak(Player p, int n) {
        this.killstreaks += n;
        if (this.killstreaks > 0 && this.killstreaks % 5 == 0) {
            Bukkit.broadcastMessage((String)(String.valueOf(main.prefix) + main.color(String.valueOf(Prefix.getPrefix(p)) + " &fIs on &a" + this.killstreaks + " &fKillStreaks!")));
            if (this.getPlayerKillStreakPerk(others.tnt)) {
                ItemStack item = new ItemStack(Material.TNT);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("\u00a7cInstant TnT");
                item.setItemMeta(meta);
                p.getInventory().addItem(new ItemStack[]{item});
            } else if (this.getPlayerKillStreakPerk(others.cobweb)) {
                ItemStack item = new ItemStack(Material.WEB);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("\u00a7eTrap Web");
                item.setItemMeta(meta);
                p.getInventory().addItem(new ItemStack[]{item});
            } else if (this.getPlayerKillStreakPerk(others.speed)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7a+5 Second Speed II");
            }
        }
    }

    public void setflint(int amount) {
    	this.flint = amount;
    }
    public void setPlayerKillStreak(int n) {
        this.killstreaks = n;
    }

    public void setPlayerCurrentKit(kits kit) {
        this.kit = kit;
    }

    public void setKillStreakPerk(others o) {
        this.other = o;
    }

    public void setPlayerBattleCry(battlecry b) {
        this.battlecry = b;
    }

    public void setPlayerKit(kits k) {
        this.kit = k;
    }

    public void setPlayerTrail(Trails trail) {
        this.trail = trail;
    }
}

