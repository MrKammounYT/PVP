/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerInteractAtEntityEvent
 *  org.bukkit.inventory.Inventory
 */
package Shop;

import Shop.ShopMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;

public class Interact
implements Listener {
    public static Inventory inv;

    @EventHandler
    public void OnInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof Skeleton && e.getRightClicked().getCustomName().equalsIgnoreCase("\u00a7a\u00a7lShop")) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            Inventory shop = Bukkit.createInventory(null, (int)45, (String)"PvP-Shop");
            shop.setItem(12, ShopMenu.BowTrails());
            shop.setItem(14, ShopMenu.Battlecry());
            shop.setItem(29, ShopMenu.ArmorShop());
            shop.setItem(31, ShopMenu.Myinv());
            shop.setItem(33, ShopMenu.Others());
            p.openInventory(shop);
        }
    }
}

