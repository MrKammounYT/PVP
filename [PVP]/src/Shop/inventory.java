/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.luckperms.api.LuckPerms
 *  net.luckperms.api.LuckPermsProvider
 *  net.luckperms.api.model.user.User
 *  net.luckperms.api.node.Node
 *  net.luckperms.api.node.types.PermissionNode
 *  org.bukkit.Bukkit
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.Inventory
 */
package Shop;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.deaths;
import MySQL.points;
import OtherMysql.BattleCry;
import OtherMysql.Perks;
import PerksAndKits.Trails;
import PerksAndKits.battlecry;
import PerksAndKits.kits;
import PerksAndKits.others;
import Shop.ShopMenu;
import Shop.Shop_items;
import Shop.battlecry_items;
import Shop.inv_items;
import cmd.pvp;
import kits.Diamond;
import kits.Emerald;
import kits.Gold;
import kits.member;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import src.main;
import utils.ScoreBoard;

public class inventory
implements Listener {
    @EventHandler
    public void onint(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (e.getClickedInventory() != p.getInventory() && e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
            String target;
            Inventory inv;
            Inventory shop;
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7e\u2199Go Back")) {
                shop = Bukkit.createInventory(null, (int)45, (String)"PvP-Shop");
                shop.setItem(12, ShopMenu.BowTrails());
                shop.setItem(14, ShopMenu.Battlecry());
                shop.setItem(29, ShopMenu.ArmorShop());
                shop.setItem(31, ShopMenu.Myinv());
                shop.setItem(33, ShopMenu.Others());
                p.openInventory(shop);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7bBattle Cry")) {
                inv = Bukkit.createInventory(null, (int)36, (String)"Battle Cry");
                inv.setItem(11, battlecry_items.mewo());
                inv.setItem(15, battlecry_items.xp());
                inv.setItem(31, inv_items.returnpage());
                p.openInventory(inv);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a77Member Kit")) {
                main.PlayerInfo.get(p.getName()).setPlayerKit(kits.member);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have Selected the \u00a77Member \u00a76Kit");
                p.getInventory().clear();
                member.memberKit(p);
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a76Gold Kit")) {
                main.PlayerInfo.get(p.getName()).setPlayerKit(kits.gold);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have Selected the \u00a76Gold \u00a76Kit");
                p.getInventory().clear();
                Gold.GoldKit(p);
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7bDiamond Kit")) {
                main.PlayerInfo.get(p.getName()).setPlayerKit(kits.diamond);
                p.closeInventory();
                p.getInventory().clear();
                Diamond.DiamondKit(p);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have Selected the \u00a7bDiamond \u00a76Kit");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a79Eagle Kit")) {
                main.PlayerInfo.get(p.getName()).setPlayerKit(kits.emerald);
                p.closeInventory();
                p.getInventory().clear();
                Emerald.EmeraldKit(p);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have Selected the \u00a79Eagle \u00a76Kit");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7aKit Upgrade")) {
                shop = Bukkit.createInventory(null, (int)36, (String)"\u00a7eKit-Shop");
                shop.setItem(13, inv_items.vipkit());
                shop.setItem(31, inv_items.returnpage());
                p.openInventory(shop);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a76Buy Gold Kit") && Coins.getcoins(p.getUniqueId()) >= 750) {
                if (p.hasPermission("eaglemc.gold") || p.hasPermission("eaglemc.diamond") || p.hasPermission("eaglemc.eagle")) {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday Have A better Kit");
                    p.closeInventory();
                } else if (p.hasPermission("pvp.permentkit.gold")) {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday Have This Kit");
                    p.closeInventory();
                } else {
                    Coins.removecoins(p.getUniqueId(), 750);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7aVip \u00a7eKit");
                    LuckPerms lp = LuckPermsProvider.get();
                    User user = lp.getUserManager().getUser(p.getUniqueId());
                    user.data().add((Node)PermissionNode.builder((String)"pvp.permentkit.gold").build());
                    lp.getUserManager().saveUser(user);
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7eOthers")) {
                inv = Bukkit.createInventory(null, (int)36, (String)"Others...");
                inv.setItem(11, inv_items.tnt());
                inv.setItem(15, inv_items.web());
                inv.setItem(13, inv_items.speed());
                inv.setItem(31, inv_items.returnpage());
                p.openInventory(inv);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cTnT")) {
                if (Coins.getcoins(p.getUniqueId()) >= 500) {
                    if (Perks.hasperk(p.getUniqueId(), "TNTPERK")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Perk");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7cTnT \u00a7ePerk");
                    Coins.removecoins(p.getUniqueId(), 500);
                    Perks.addperk(p.getUniqueId(), "TNTPERK");
                    ScoreBoard.bord(p);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7aSpeed")) {
                if (Coins.getcoins(p.getUniqueId()) >= 500) {
                    if (Perks.hasperk(p.getUniqueId(), "SPEEDPERK")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Perk");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7aSpeed \u00a7ePerk");
                    Coins.removecoins(p.getUniqueId(), 500);
                    Perks.addperk(p.getUniqueId(), "SPEEDPERK");
                    ScoreBoard.bord(p);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cCobWeb")) {
                if (Coins.getcoins(p.getUniqueId()) >= 500) {
                    if (Perks.hasperk(p.getUniqueId(), "WEBPERK")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Perk");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7cCobWeb \u00a7ePerk");
                    Coins.removecoins(p.getUniqueId(), 500);
                    ScoreBoard.bord(p);
                    Perks.addperk(p.getUniqueId(), "WEBPERK");
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cNo \u00a77(Dont Reset Profile)") && pvp.reset.containsKey(p)) {
                target = pvp.reset.get(p);
                p.closeInventory();
                pvp.reset.remove(p, target);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7aYes \u00a77(To Reset Profile)") && pvp.reset.containsKey(p)) {
                Player t;
                target = pvp.reset.get(p);
                if (Bukkit.getPlayer((String)target) != null) {
                    t = Bukkit.getPlayer((String)target);
                    Kills.deleteplayer(t);
                    points.deleteplayer(t);
                    deaths.deleteplayer(t);
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a76The Profile Of \u00a7e" + t.getName() + " \u00a76Have Been Reseted");
                    p.closeInventory();
                    pvp.reset.remove(p, t.getName());
                    t.kickPlayer("\u00a7cConnection Timed Out!");
                    Bukkit.getServer().getPlayer(target).remove();
                } else {
                    t = (Player) Bukkit.getOfflinePlayer((String)target);
                    Kills.deleteplayer(t.getPlayer());
                    points.deleteplayer(t.getPlayer());
                    deaths.deleteplayer(t.getPlayer());
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a76The Profile Of \u00a7e" + t.getName() + " \u00a76Have Been Reseted");
                    p.closeInventory();
                    Bukkit.getServer().getPlayer(target).remove();
                    pvp.reset.remove(p, t.getName());
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7aSpeed \u00a77(Right Click To Select\u00a77)")) {
                Perks.addCT(p.getUniqueId(), "SPEEDPERK");
                main.PlayerInfo.get(p.getName()).setKillStreakPerk(others.speed);
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have selected \u00a7aSpeed \u00a76Perk");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7eTNT \u00a77(Right Click To Select\u00a77)")) {
                Perks.addCT(p.getUniqueId(), "TNTPERK");
                main.PlayerInfo.get(p.getName()).setKillStreakPerk(others.tnt);
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have selected \u00a7cTnT \u00a76Perk");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7eCOBWEB  \u00a77(Right Click To Select\u00a77)")) {
                Perks.addCT(p.getUniqueId(), "WEBPERK");
                main.PlayerInfo.get(p.getName()).setKillStreakPerk(others.cobweb);
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a76You Have selected \u00a7eCobWeb \u00a76Perk");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cBow Trails")) {
                e.setCancelled(true);
                Inventory shop2 = Bukkit.createInventory(null, (int)45, (String)"Bow-trails");
                shop2.setItem(11, Shop_items.FireTrail());
                shop2.setItem(13, Shop_items.Slime());
                shop2.setItem(15, Shop_items.Heart());
                shop2.setItem(30, Shop_items.smoke());
                shop2.setItem(32, Shop_items.ender());
                shop2.setItem(40, inv_items.returnpage());
                p.openInventory(shop2);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cHearts-Trail")) {
                OtherMysql.Trails.addCT(p.getUniqueId(), "HEART");
                main.PlayerInfo.get(p.getName()).setPlayerTrail(Trails.hearts);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a7cHearts-Trail \u00a7aAs a Current BowTrail");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a76Fire-Trail")) {
                OtherMysql.Trails.addCT(p.getUniqueId(), "FIRE");
                main.PlayerInfo.get(p.getName()).setPlayerTrail(Trails.fire);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a76Fire Trail \u00a7aAs a Current BowTrail");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7c\u00a7lMeow")) {
                BattleCry.addCT(p.getUniqueId(), "MEOW");
                main.PlayerInfo.get(p.getName()).setPlayerBattleCry(battlecry.meow);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a7c\u00a7lMeow \u00a7aAs a Current BattleCry");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7e\u00a7lLevel-Up")) {
                BattleCry.addCT(p.getUniqueId(), "XP");
                main.PlayerInfo.get(p.getName()).setPlayerBattleCry(battlecry.levelup);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a7e\u00a7lLevelUp \u00a7aAs a Current BattleCry");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a72Slime-Trail")) {
                OtherMysql.Trails.addCT(p.getUniqueId(), "SLIME");
                main.PlayerInfo.get(p.getName()).setPlayerTrail(Trails.slime);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a72Slime Trail \u00a7aAs a Current BowTrail");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a75End-Trail")) {
                OtherMysql.Trails.addCT(p.getUniqueId(), "ENDER");
                main.PlayerInfo.get(p.getName()).setPlayerTrail(Trails.end);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a75End Trail \u00a7aAs a Current BowTrail");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a77Smoke-Trail")) {
                OtherMysql.Trails.addCT(p.getUniqueId(), "SMOKE");
                main.PlayerInfo.get(p.getName()).setPlayerTrail(Trails.smoke);
                p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Selected \u00a77Smoke Trail \u00a7aAs a Current BowTrail");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cHearts Trail")) {
                if (Coins.getcoins(p.getUniqueId()) >= 1000) {
                    if (OtherMysql.Trails.hastrail(p.getUniqueId(), "HEART")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Trail");
                        p.closeInventory();
                        return;
                    }
                    OtherMysql.Trails.addtrail(p.getUniqueId(), "HEART");
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Bought The \u00a7cHeart Effect \u00a7aBow Trail");
                    Coins.removecoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    ScoreBoard.bord(p);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a76Fire Trail")) {
                if (Coins.getcoins(p.getUniqueId()) >= 1000) {
                    if (OtherMysql.Trails.hastrail(p.getUniqueId(), "FIRE")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Trail");
                        p.closeInventory();
                        return;
                    }
                    OtherMysql.Trails.addtrail(p.getUniqueId(), "FIRE");
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Bought The \u00a76Fire Effect \u00a7aBow Trail");
                    Coins.removecoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    ScoreBoard.bord(p);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a72My Items")) {
                shop = Bukkit.createInventory(null, (int)54, (String)"My-Items");
                shop.setItem(9, inv_items.Myinv());
                shop.setItem(18, inv_items.Myinv2());
                shop.setItem(27, inv_items.Myinv3());
                shop.setItem(36, inv_items.juke());
                shop.setItem(29, inv_items.memberkit(p));
                if (p.hasPermission("eaglemc.gold") || p.hasPermission("pvp.permentkit.gold")) {
                    shop.setItem(30, inv_items.vipkit(p));
                } else {
                    shop.setItem(30, inv_items.glass());
                }
                if (p.hasPermission("eaglemc.diamond")) {
                    shop.setItem(31, inv_items.vipPluskit(p));
                } else {
                    shop.setItem(31, inv_items.glass());
                }
                if (p.hasPermission("eaglemc.eagle")) {
                    shop.setItem(32, inv_items.mvpkit(p));
                } else {
                    shop.setItem(32, inv_items.glass());
                }
                if (Perks.hasperk(p.getUniqueId(), "TNTPERK")) {
                    shop.setItem(20, inv_items.myTnt(p));
                } else {
                    shop.setItem(20, inv_items.glass());
                }
                if (Perks.hasperk(p.getUniqueId(), "WEBPERK")) {
                    shop.setItem(21, inv_items.myweb(p));
                } else {
                    shop.setItem(21, inv_items.glass());
                }
                if (Perks.hasperk(p.getUniqueId(), "SPEEDPERK")) {
                    shop.setItem(22, inv_items.myspeed(p));
                } else {
                    shop.setItem(22, inv_items.glass());
                }
                if (OtherMysql.Trails.hastrail(p.getUniqueId(), "HEART")) {
                    shop.setItem(11, inv_items.Heart(p));
                } else {
                    shop.setItem(11, inv_items.glass());
                }
                if (OtherMysql.Trails.hastrail(p.getUniqueId(), "FIRE")) {
                    shop.setItem(12, inv_items.FireEffect(p));
                } else {
                    shop.setItem(12, inv_items.glass());
                }
                if (OtherMysql.Trails.hastrail(p.getUniqueId(), "SLIME")) {
                    shop.setItem(13, inv_items.Slime(p));
                } else {
                    shop.setItem(13, inv_items.glass());
                }
                if (OtherMysql.Trails.hastrail(p.getUniqueId(), "ENDER")) {
                    shop.setItem(14, inv_items.Ender(p));
                } else {
                    shop.setItem(14, inv_items.glass());
                }
                if (OtherMysql.Trails.hastrail(p.getUniqueId(), "SMOKE")) {
                    shop.setItem(15, inv_items.Smoke(p));
                } else {
                    shop.setItem(15, inv_items.glass());
                }
                if (BattleCry.hasperk(p.getUniqueId(), "MEOW")) {
                    shop.setItem(38, inv_items.mewo(p));
                } else {
                    shop.setItem(38, inv_items.glass());
                }
                if (BattleCry.hasperk(p.getUniqueId(), "XP")) {
                    shop.setItem(39, inv_items.xp(p));
                } else {
                    shop.setItem(39, inv_items.glass());
                }
                int i = 0;
                while (i < 54) {
                    if (shop.getItem(i) == null) {
                        shop.setItem(i, inv_items.glass2());
                    }
                    ++i;
                }
                p.openInventory(shop);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a72Slime Trail")) {
                if (Coins.getcoins(p.getUniqueId()) >= 1000) {
                    if (OtherMysql.Trails.hastrail(p.getUniqueId(), "SLIME")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Trail");
                        p.closeInventory();
                        return;
                    }
                    OtherMysql.Trails.addtrail(p.getUniqueId(), "SLIME");
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Bought The \u00a72Slime Effect \u00a7aBow Trail");
                    Coins.removecoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    ScoreBoard.bord(p);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a75End Trail")) {
                if (Coins.getcoins(p.getUniqueId()) >= 1000) {
                    if (OtherMysql.Trails.hastrail(p.getUniqueId(), "ENDER")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Trail");
                        p.closeInventory();
                        return;
                    }
                    OtherMysql.Trails.addtrail(p.getUniqueId(), "ENDER");
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Bought The \u00a75End Effect \u00a7aBow Trail");
                    Coins.removecoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    ScoreBoard.bord(p);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a77Smoke Trail")) {
                if (Coins.getcoins(p.getUniqueId()) >= 1000) {
                    if (OtherMysql.Trails.hastrail(p.getUniqueId(), "SMOKE")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Trail");
                        p.closeInventory();
                        return;
                    }
                    OtherMysql.Trails.addtrail(p.getUniqueId(), "SMOKE");
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7aYou Have Bought The \u00a77Smoke Effect \u00a7aBow Trail");
                    Coins.removecoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    ScoreBoard.bord(p);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7e\u00a7lLevel Up")) {
                if (Coins.getcoins(p.getUniqueId()) >= 250) {
                    if (BattleCry.hasperk(p.getUniqueId(), "XP")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Perk");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7e&lXP \u00a7eBattle Cry");
                    Coins.removecoins(p.getUniqueId(), 250);
                    BattleCry.addperk(p.getUniqueId(), "XP");
                    ScoreBoard.bord(p);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7c\u00a7lMeow !")) {
                if (Coins.getcoins(p.getUniqueId()) >= 250) {
                    if (BattleCry.hasperk(p.getUniqueId(), "MEOW")) {
                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Alerday have This Perk");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7eYou Have Bought The \u00a7cMewo \u00a7eBattle Cry");
                    Coins.removecoins(p.getUniqueId(), 250);
                    BattleCry.addperk(p.getUniqueId(), "MEOW");
                    ScoreBoard.bord(p);
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 8.0f, 5.0f);
                    p.closeInventory();
                } else {
                    p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYou Don't Have Enough Coins :(");
                    p.closeInventory();
                }
            }
        }
    }
}

