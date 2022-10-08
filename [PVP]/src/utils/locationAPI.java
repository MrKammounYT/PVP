/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class locationAPI {
    static File file = new File("plugins/PvP", "Locations.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);

    public static void create() {
        try {
            file.createNewFile();
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLocation(Location loc, String name) {
        String world = loc.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();
        cfg.set(String.valueOf(String.valueOf(name)) + ".world", (Object)world);
        cfg.set(String.valueOf(String.valueOf(name)) + ".x", (Object)x);
        cfg.set(String.valueOf(String.valueOf(name)) + ".y", (Object)y);
        cfg.set(String.valueOf(String.valueOf(name)) + ".z", (Object)z);
        cfg.set(String.valueOf(String.valueOf(name)) + ".yaw", (Object)yaw);
        cfg.set(String.valueOf(String.valueOf(name)) + ".pitch", (Object)pitch);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location getLocation(String name) {
        String world = cfg.getString(String.valueOf(String.valueOf(name)) + ".world");
        double x = cfg.getDouble(String.valueOf(String.valueOf(name)) + ".x");
        double y = cfg.getDouble(String.valueOf(String.valueOf(name)) + ".y");
        double z = cfg.getDouble(String.valueOf(String.valueOf(name)) + ".z");
        double yaw = cfg.getDouble(String.valueOf(String.valueOf(name)) + ".yaw");
        double pitch = cfg.getDouble(String.valueOf(String.valueOf(name)) + ".pitch");
        Location loc = new Location(Bukkit.getWorld((String)world), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        return loc;
    }
}

