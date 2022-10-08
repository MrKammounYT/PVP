/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Effect
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.ProjectileLaunchEvent
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package events;

import PerksAndKits.Trails;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import src.main;

public class BowTrail_event
implements Listener {
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onbow(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {
            final Arrow a = (Arrow)e.getEntity();
            Player p = (Player)e.getEntity().getShooter();
            if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.hearts)) {
                Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)main.getInstance(), (Runnable)new BukkitRunnable(){

                    public void run() {
                        if (!a.isOnGround() && !a.isDead()) {
                            a.getWorld().playEffect(a.getLocation(), Effect.HEART, 5);
                        }
                    }
                }, 0L, 3L);
            } else if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.fire)) {
                Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)main.getInstance(), (Runnable)new BukkitRunnable(){

                    public void run() {
                        if (!a.isOnGround() && !a.isDead()) {
                            a.getWorld().playEffect(a.getLocation(), Effect.LAVADRIP, 5);
                        }
                    }
                }, 0L, 3L);
            } else if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.slime)) {
                Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)main.getInstance(), (Runnable)new BukkitRunnable(){

                    public void run() {
                        if (!a.isOnGround() && !a.isDead()) {
                            a.getWorld().playEffect(a.getLocation(), Effect.SLIME, 5);
                        }
                    }
                }, 0L, 3L);
            } else if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.end)) {
                Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)main.getInstance(), (Runnable)new BukkitRunnable(){

                    public void run() {
                        if (!a.isOnGround() && !a.isDead()) {
                            a.getWorld().playEffect(a.getLocation(), Effect.ENDER_SIGNAL, 2);
                        }
                    }
                }, 0L, 3L);
            } else if (main.PlayerInfo.get(p.getName()).getPlayerTrail(Trails.smoke)) {
                Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)main.getInstance(), (Runnable)new BukkitRunnable(){

                    public void run() {
                        if (!a.isOnGround() && !a.isDead()) {
                            a.getWorld().playEffect(a.getLocation(), Effect.LARGE_SMOKE, 5);
                        }
                    }
                }, 0L, 3L);
            }
        }
    }
}

