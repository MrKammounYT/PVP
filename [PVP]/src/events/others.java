/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.block.BlockFace
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.FoodLevelChangeEvent
 *  org.bukkit.event.entity.ProjectileHitEvent
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.event.player.PlayerDropItemEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.event.player.PlayerItemBreakEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerPickupItemEvent
 *  org.bukkit.util.Vector
 */
package events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.util.Vector;

import MySQL.points;
import cmd.PlayerCommand;
import cmd.pvp;
import src.main;

public class others
implements Listener {
    @EventHandler
    public void food(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void EntityDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            e.setDamage(e.getDamage() / 2.0);
        }
    }

    @EventHandler
    public void onbreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.TNT || e.getBlock().getType() == Material.WEB || e.getBlock().getType() == Material.FIRE) {
            e.getBlock().getDrops().clear();
            return;
        }
      
        e.setCancelled(true);
    }

    @EventHandler
    public void onAntiLogDmg(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onplace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TNT || e.getBlock().getType() == Material.WEB || e.getBlock().getType() == Material.FIRE) {
            return;
        }
        
        e.setCancelled(true);
    }

    @EventHandler(ignoreCancelled=true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && event.getDamager() != null && event.getDamager().getType() == EntityType.ARROW && ((Arrow)event.getDamager()).getShooter() == event.getEntity()) {
            event.setCancelled(false);
            event.getEntity().setVelocity(event.getEntity().getLocation().getDirection().setY(0).normalize().multiply(2));
        }
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        Arrow arrow;
        if (event.getEntity() instanceof Arrow && (arrow = (Arrow)event.getEntity()).isOnGround()) {
            arrow.remove();
        }
    }

    @EventHandler
    public void onint(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand().getType() == Material.FLINT_AND_STEEL) {
            if (e.getPlayer().getItemInHand().getDurability() < 0) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
                if (e.getClickedBlock().getType() == Material.GLASS) {
                    e.getClickedBlock().getRelative(BlockFace.UP).setType(Material.FIRE);
                }
            }
        }
    }

    @EventHandler
    public void onitemb(PlayerItemBreakEvent e) {
        if (e.getBrokenItem().getType() == Material.FLINT_AND_STEEL) {
            e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (e.getFrom().getZ() != e.getTo().getZ() && e.getFrom().getX() != e.getTo().getX() && PlayerCommand.intp.contains(p)) {
            PlayerCommand.intp.remove(p);
            p.sendMessage(String.valueOf(main.prefix) + "\u00a7cYour Teleport Was Canceled Cause you moved!");
        }
        if (e.getTo().getBlock().getType() == Material.GOLD_PLATE) {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0, e.getPlayer().getVelocity().getZ()));
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
        }
        if (e.getTo().getBlock().getType() == Material.IRON_PLATE) {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 3.0, e.getPlayer().getVelocity().getZ()));
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 3.0f, 2.0f);
        }
    }

    @EventHandler
    public void onthrow(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onpick(PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }

   
}

