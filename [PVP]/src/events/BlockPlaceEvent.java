/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.TNTPrimed
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.entity.EntityExplodeEvent
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import src.main;

public class BlockPlaceEvent
implements Listener {
    @SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        final Block b = e.getBlockPlaced();
        Player p = e.getPlayer();
        if (!e.isCancelled()) {
            if (b.getType() == Material.TNT) {
                b.setType(Material.AIR);
                TNTPrimed tnt = (TNTPrimed)p.getWorld().spawnEntity(b.getLocation(), EntityType.PRIMED_TNT);
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                tnt.setFuseTicks(30);
                tnt.setTicksLived(30);
                e.setCancelled(false);
                e.setBuild(true);
            } else if (b.getType() == Material.WEB) {
                Bukkit.getScheduler().runTaskLater((Plugin)main.getInstance(), new BukkitRunnable(){

                    public void run() {
                        b.setType(Material.AIR);
                    }
                }, 140L);
                e.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onBlockExplode(EntityExplodeEvent e) {
        if (e.getEntity() instanceof TNTPrimed) {
            e.setCancelled(true);
        }
    }
}

