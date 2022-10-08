/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package OtherMysql;

import MySQL.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.bukkit.entity.Player;

public class Trails {
    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS trails (NAME VARCHAR(100),UUID VARCHAR(100),FIRE int(1),HEART int(1),SLIME int(1),ENDER int(1),SMOKE int(1),CT VARCHAR(100),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPlayer(Player p) {
        try {
            UUID uuid = p.getUniqueId();
            if (!Trails.Playerexists(uuid)) {
                PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO trails (NAME,UUID,FIRE,HEART,SLIME,ENDER,SMOKE) VALUES (?,?,?,?,?,?,?)");
                ps2.setString(1, p.getName());
                ps2.setString(2, uuid.toString());
                ps2.setInt(3, 0);
                ps2.setInt(4, 0);
                ps2.setInt(5, 0);
                ps2.setInt(6, 0);
                ps2.setInt(7, 0);
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
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM trails WHERE UUID=" + uuid);
            ps.executeUpdate();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean Playerexists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM trails WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            return results.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void addtrail(UUID uuid, String trailSQl) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE trails SET " + trailSQl + "=? WHERE UUID=?");
            ps.setInt(1, Trails.gettrail(uuid, trailSQl) + 1);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    public static boolean hastrail(UUID uuid, String trailSql) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + trailSql + " FROM trails WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(trailSql) >= 1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    static int gettrail(UUID uuid, String perksql) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + perksql + " FROM trails WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(perksql);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void addCT(UUID uuid, String trailSQl) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE trails SET CT=? WHERE UUID=?");
            ps.setString(1, trailSQl);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    public static String getCt(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT CT FROM trails WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CT");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean hasCT(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT CT FROM trails WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CT") != null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

