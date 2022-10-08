/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  fr.minuskube.netherboard.Netherboard
 *  fr.minuskube.netherboard.bukkit.BPlayerBoard
 *  org.bukkit.entity.Player
 */
package utils;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.deaths;
import MySQL.points;
import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import org.bukkit.entity.Player;
import src.main;

public class ScoreBoard {
    public static void bord(Player p) {
        BPlayerBoard board = Netherboard.instance().getBoard(p);
        board.setName(main.color("&e&lPvP BETA"));
        board.set(main.color("&f&l  "), Integer.valueOf(13));
        board.set(main.color("&e&lKillStreaks"), Integer.valueOf(12));
        board.set(main.color("&e\u2502 &f" + main.PlayerInfo.get(p.getName()).getPlayerStreaks()), Integer.valueOf(11));
        board.set(main.color("&6&l  "), Integer.valueOf(10));
        board.set(main.color("&e&lStats Info"), Integer.valueOf(9));
        board.set(main.color("&e\u2502 &fKills: &a" + Kills.getKills(p.getUniqueId())), Integer.valueOf(8));
        board.set(main.color("&e\u2502 &fPoints: &a" + points.getpoints(p.getUniqueId())), Integer.valueOf(7));
        board.set(main.color("&e\u2502 &fDeaths: &a" + deaths.getdeaths(p.getUniqueId())), Integer.valueOf(6));
        board.set(main.color("&e\u2502 &fCoins: &a" + Coins.getcoins(p.getUniqueId())), Integer.valueOf(5));
        board.set(String.valueOf(main.color("&e\u2502 &fPrestige: &r")) + ScoreBoard.getPs(p), Integer.valueOf(4));
        board.set(main.color("&a  "), Integer.valueOf(3));
        board.set(main.color("&eEagleMc.net"), Integer.valueOf(2));
        board.set(main.color("&7&m------------------------"), Integer.valueOf(1));
    }

    static String getPs(Player p) {
        if (Kills.getKills(p.getUniqueId()) >= 6000) {
            return "&4The Master";
        }
        if (Kills.getKills(p.getUniqueId()) >= 4000) {
            return "\u00a74Champoin II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 3500) {
            return "\u00a74Champoin I";
        }
        if (Kills.getKills(p.getUniqueId()) >= 3000) {
            return "\u00a7bDiamond III";
        }
        if (Kills.getKills(p.getUniqueId()) >= 2800) {
            return "\u00a7bDiamond II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 2500) {
            return "\u00a7bDiamond I";
        }
        if (Kills.getKills(p.getUniqueId()) >= 2250) {
            return "\u00a73Platinum III";
        }
        if (Kills.getKills(p.getUniqueId()) >= 2000) {
            return "\u00a73Platinum II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 1800) {
            return "\u00a73Platinum I";
        }
        if (Kills.getKills(p.getUniqueId()) >= 1650) {
            return "\u00a76Gold III";
        }
        if (Kills.getKills(p.getUniqueId()) >= 1300) {
            return "\u00a76Gold II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 1000) {
            return "\u00a76Gold I";
        }
        if (Kills.getKills(p.getUniqueId()) >= 700) {
            return "\u00a77Silver  III";
        }
        if (Kills.getKills(p.getUniqueId()) >= 500) {
            return "\u00a77Silver II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 400) {
            return "\u00a77Silver I";
        }
        if (Kills.getKills(p.getUniqueId()) >= 300) {
            return "\u00a7eBronze III";
        }
        if (Kills.getKills(p.getUniqueId()) >= 200) {
            return "\u00a7eBronze II";
        }
        if (Kills.getKills(p.getUniqueId()) >= 100) {
            return "\u00a7eBronze I";
        }
        return "UNRANKED";
    }
}

