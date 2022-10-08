/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Effect
 *  org.bukkit.World
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.scheduler.BukkitRunnable
 */
package cooldowns;

import MySQL.Kills;
import MySQL.points;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;
import utils.locationAPI;

public class LeaderBoard
extends BukkitRunnable {
    int timer = 60;

    public void run() {
        if (this.timer == 0) {
            this.timer = 60;
            try {
                World w = locationAPI.getLocation("topkills").getWorld();
                w.playEffect(locationAPI.getLocation("topkills"), Effect.FLAME, 10);
                w.playEffect(locationAPI.getLocation("topkills"), Effect.FLAME, 10);
                for (Entity entitys : w.getEntities()) {
                    if (entitys.getType() != EntityType.ARMOR_STAND) continue;
                    ArmorStand as = (ArmorStand)entitys;
                    as.setHealth(0.0);
                }
                ArmorStand leaderboard = (ArmorStand)locationAPI.getLocation("topkills").getWorld().spawnEntity(locationAPI.getLocation("topkills").add(0.0, 1.4, 0.0), EntityType.ARMOR_STAND);
                leaderboard.setVisible(false);
                leaderboard.setCanPickupItems(true);
                leaderboard.setSmall(true);
                leaderboard.setGravity(false);
                leaderboard.setCustomName("\u00a7fLeaderboard - \u00a7aSorted By Kills");
                leaderboard.setCustomNameVisible(true);
                int i = 1;
                while (i <= 10) {
                    ArmorStand yellow = (ArmorStand)locationAPI.getLocation("topkills").getWorld().spawnEntity(locationAPI.getLocation("topkills").add(0.0, 1.0 - 0.4 * (double)i, 0.0), EntityType.ARMOR_STAND);
                    yellow.setVisible(false);
                    yellow.setCanPickupItems(true);
                    yellow.setSmall(true);
                    yellow.setGravity(false);
                    yellow.setCustomName(Kills.gettop(i));
                    yellow.setCustomNameVisible(true);
                    ++i;
                }
                ArmorStand leaderboard2 = (ArmorStand)locationAPI.getLocation("toppoints").getWorld().spawnEntity(locationAPI.getLocation("toppoints").add(0.0, 1.4, 0.0), EntityType.ARMOR_STAND);
                w.playEffect(locationAPI.getLocation("toppoints"), Effect.FLAME, 10);
                leaderboard2.setVisible(false);
                leaderboard2.setCanPickupItems(true);
                leaderboard2.setSmall(true);
                leaderboard2.setGravity(false);
                leaderboard2.setCustomName("\u00a7fLeaderboard - \u00a7aSorted By Points");
                leaderboard2.setCustomNameVisible(true);
                int i2 = 1;
                while (i2 <= 10) {
                    ArmorStand yellow = (ArmorStand)locationAPI.getLocation("toppoints").getWorld().spawnEntity(locationAPI.getLocation("toppoints").add(0.0, 1.0 - 0.4 * (double)i2, 0.0), EntityType.ARMOR_STAND);
                    yellow.setVisible(false);
                    yellow.setCanPickupItems(true);
                    yellow.setSmall(true);
                    yellow.setGravity(false);
                    yellow.setCustomName(points.gettop(i2));
                    yellow.setCustomNameVisible(true);
                    ++i2;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        --this.timer;
    }
}

