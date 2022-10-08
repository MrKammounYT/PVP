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

public class BattleCry {
    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS battle (NAME VARCHAR(100),UUID VARCHAR(100),XP int(1),MEOW int(1),CT VARCHAR(100),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPlayer(Player p) {
        try {
            UUID uuid = p.getUniqueId();
            if (!BattleCry.Playerexists(uuid)) {
                PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO battle (NAME,UUID,XP,MEOW) VALUES (?,?,?,?)");
                ps2.setString(1, p.getName());
                ps2.setString(2, uuid.toString());
                ps2.setInt(3, 0);
                ps2.setInt(4, 0);
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
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM battle WHERE UUID=" + uuid);
            ps.executeUpdate();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean Playerexists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM battle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            return results.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void addperk(UUID uuid, String battleQl) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE battle SET " + battleQl + "=? WHERE UUID=?");
            ps.setInt(1, BattleCry.getperk(uuid, battleQl) + 1);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    public static boolean hasperk(UUID uuid, String battleql) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + battleql + " FROM battle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(battleql) >= 1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addCT(UUID uuid, String trailSQl) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE battle SET CT=? WHERE UUID=?");
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
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT CT FROM battle WHERE UUID=?");
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

    static int getperk(UUID uuid, String battleql) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + battleql + " FROM battle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(battleql);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean hasCT(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT CT FROM battle WHERE UUID=?");
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

