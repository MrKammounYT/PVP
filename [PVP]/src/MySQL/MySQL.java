/*
 * Decompiled with CFR 0.151.
 */
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import src.main;

public class MySQL {
    private static String host = main.getInstance().getConfig().getString("host");
    private static String port = main.getInstance().getConfig().getString("port");
    private static String database = main.getInstance().getConfig().getString("database");
    private static String username = main.getInstance().getConfig().getString("username");
    private static String password = main.getInstance().getConfig().getString("password");
    private static Connection connection;

    public static boolean isConnected() {
        return connection != null;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        if (!MySQL.isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
        }
    }

    public static boolean isClosed() {
        try {
            if (connection.isClosed()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void disconnect() {
        if (MySQL.isConnected()) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

