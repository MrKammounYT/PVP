/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package MySQL;

import MySQL.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.bukkit.entity.Player;

public class deaths {
    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS deaths (NAME VARCHAR(100),UUID VARCHAR(100),DEATHS INT(100),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPlayer(Player p) {
        try {
            UUID uuid = p.getUniqueId();
            if (!deaths.Playerexists(uuid)) {
                PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO deaths (NAME,UUID) VALUES (?,?)");
                ps2.setString(1, p.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();
                return;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteplayer(Player p) {
        try {
            UUID uuid = p.getUniqueId();
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM deaths WHERE UUID=" + uuid);
            ps.executeUpdate();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean Playerexists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM deaths WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            return results.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void adddeaths(UUID uuid, int i) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE deaths SET DEATHS=? WHERE UUID=?");
            ps.setInt(1, deaths.getdeaths(uuid) + i);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getdeaths(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT deaths FROM deaths WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int points2 = 0;
            if (rs.next()) {
                points2 = rs.getInt("deaths");
                return points2;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

