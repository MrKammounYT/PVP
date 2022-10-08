/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.plugin.Plugin
 */
package events;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import src.main;

public class EntityDamageByE
implements Listener {
    public static HashMap<String, String> antilog = new HashMap<String, String>();
    int timer = 30;

    @EventHandler
    public void onAntiLogDmg(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
        if (e.getDamager() instanceof Arrow && e.getEntity() instanceof Player) {
           Player player = (Player)e.getEntity();
            Arrow t = (Arrow)e.getDamager();
            if (e.getEntityType() == EntityType.PLAYER && e.getDamager() != null && e.getDamager().getType() == EntityType.ARROW && ((Arrow)e.getDamager()).getShooter() == e.getEntity()) {
                return;
            }
            if (t.getShooter() instanceof Player) {
                final Player target = (Player)t.getShooter();
                if (!(antilog.containsKey(player.getName()) && antilog.containsValue(target.getName()) || antilog.containsValue(player.getName()) && antilog.containsKey(target.getName()))) {
                    antilog.put(target.getName(), player.getName());
                    antilog.put(player.getName(), target.getName());
                    player.sendMessage("now in Combat! with " + target.getName());
                    player.sendMessage("not Logout!");
                    target.sendMessage("now in Combat! with " + player.getName());
                    target.sendMessage("not Logout!");
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            if (!(antilog.containsKey(player.getName()) && antilog.containsValue(target.getName()) || antilog.containsValue(player.getName()) && antilog.containsKey(target.getName()))) {
                                antilog.remove(player.getName());
                                antilog.remove(target.getName());
                                target.sendMessage("can now log out safely.");
                                player.sendMessage("can now log out safely.");
                            }
                        }
                    }, 1000L);
                }
            }
        }
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
          Player player = (Player)e.getEntity();
            final Player target = (Player)e.getDamager();
            if (!(antilog.containsKey(player.getName()) && antilog.containsValue(target.getName()) || antilog.containsValue(player.getName()) && antilog.containsKey(target.getName()))) {
                antilog.put(target.getName(), player.getName());
                antilog.put(player.getName(), target.getName());
                player.sendMessage("now in Combat! with" + target.getName());
                player.sendMessage("not Logout!");
                target.sendMessage("now in Combat! with " + player.getName());
                target.sendMessage("not Logout!");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.getInstance(), new Runnable(){

                    @Override
                    public void run() {
                        if (!(antilog.containsKey(player.getName()) && antilog.containsValue(target.getName()) || antilog.containsValue(player.getName()) && antilog.containsKey(target.getName()))) {
                            antilog.remove(player.getName());
                            antilog.remove(target.getName());
                            target.sendMessage("can now log out safely.");
                            player.sendMessage("can now log out safely.");
                        }
                    }
                }, 1000L);
            }
        }
    }
}

