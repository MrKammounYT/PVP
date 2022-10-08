package cmd;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import MySQL.Coins;
import MySQL.Kills;
import MySQL.deaths;
import MySQL.points;
import src.main;
import utils.Prefix;
import utils.locationAPI;

public class PlayerCommand implements CommandExecutor {
    public static ArrayList<Player> intp = new ArrayList<Player>();
    ArrayList<Player> waitingForStats = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		Player p = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("spawn")) {
			 if (!intp.contains(p)) {
		            intp.add(p);
		            p.sendMessage(String.valueOf(main.prefix) + "\u00a7aTeleporting in \u00a7e5 \u00a7aseconds. Dont Move!");
		            new BukkitRunnable(){

		                public void run() {
		                    if (intp.contains(p)) {
		                        p.sendMessage(String.valueOf(main.prefix) + "\u00a7aBack To Spawn");
		                        p.teleport(locationAPI.getLocation("spawn"));
		                        intp.remove(p);
		                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 3.0f, 4.0f);
		                        p.setHealth(20.0);
		                    }
		                }
		            }.runTaskLater((Plugin)main.getInstance(), 100L);
		        }
		}else if(cmd.getName().equalsIgnoreCase("save")) {
			int i = 0;
	        if (i < p.getInventory().getSize()) {
	            if (p.getInventory().getItem(i).getType() == Material.TNT || p.getInventory().getItem(i).getType() == Material.WEB) {
	                p.sendMessage("\u00a7cYou Cant Save You Inventory While Caring you perks Item ");
	            } else if (p.getInventory().getHelmet() == null || p.getInventory().getChestplate() == null || p.getInventory().getLeggings() == null || p.getInventory().getBoots() == null) {
	                p.sendMessage("\u00a7cYou Cant Save You Inventory Without wearing your armors ");
	            } else {
	                main.PlayerInfo.get(p.getName()).setHasSavedInv(true);
	                main.PlayerInfo.get(p.getName()).savePlayerArmor(p);
	                main.PlayerInfo.get(p.getName()).savePlayerItems(p);
	                p.sendMessage(String.valueOf(main.prefix) + "\u00a76Your inventory has been saved until you logout!");
	            }
	        }
		}
		else if (cmd.getName().equalsIgnoreCase("ps") || cmd.getName().equalsIgnoreCase("ranks")) {
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + "\u00a77\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a76Bronze I \u00a77\u00bb 100 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a76Bronze II \u00a77\u00bb 200 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a76Bronze III \u00a77\u00bb 300 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a77Silver I \u00a77\u00bb 400 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a77Silver II \u00a77\u00bb 500 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a77Silver III \u00a77\u00bb 700 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7eGold I \u00a77\u00bb 1000 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7eGold II \u00a77\u00bb 1300 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7eGold III \u00a77\u00bb 1650 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a78Platinum I \u00a77\u00bb 1800 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a78Platinum II \u00a77\u00bb 2000 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a78Platinum III \u00a77\u00bb 2250 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7bDiamond I \u00a77\u00bb 2500 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7bDiamond II \u00a77\u00bb 2800 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a7bDiamond III \u00a77\u00bb 3000 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a74Champion I \u00a77\u00bb 3500 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a74Champion II \u00a77\u00bb 4000 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a70Master \u00a77\u00bb 6000 \u00a76Kills");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + "\u00a77\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501");
            p.sendMessage(String.valueOf(String.valueOf(main.prefix)) + " \u00a77Next Prestige \u00bb " + getnextPs(p));
        }
		if(cmd.getName().equalsIgnoreCase("stats")) {
		  if (args.length == 1) {
              String st = args[0];
              if (Bukkit.getPlayer((String)st) != null) {
                  Player t = Bukkit.getPlayer((String)st);
                  if (waitingForStats.contains(p)) {
                      p.sendMessage(String.valueOf(main.prefix) + "\u00a7cPlease Wait...");
                  } else {
                	  waitingForStats.add(p);
                      final ArrayList<String> state = new ArrayList<String>();
                      p.sendMessage("\u00a7aGetting " + t.getName() + " States Please Wait :)");
                      state.add("\u00a76\u00a7m---------------------------------------");
                      state.add(this.color("&bName&f: " + Prefix.getPrefix(t)));
                      state.add("\u00a7cRank\u00a77: " + getPs(t));
                      state.add("\u00a76Kills\u00a77: \u00a7f" + Kills.getKills(t.getUniqueId()));
                      state.add("\u00a76Points\u00a77: \u00a7f" + points.getpoints(t.getUniqueId()));
                      state.add("\u00a76Deaths\u00a77: \u00a7f" + deaths.getdeaths(t.getUniqueId()));
                      state.add("\u00a76Coins\u00a77: \u00a7f" + Coins.getcoins(t.getUniqueId()));
                      state.add("\u00a76\u00a7m---------------------------------------");
                      Bukkit.getScheduler().runTaskLater((Plugin)main.getInstance(), new BukkitRunnable(){

                          public void run() {
                              int i = 0;
                              while (i < state.size()) {
                                  p.sendMessage((String)state.get(i));
                                  waitingForStats.remove(p);
                                  ++i;
                              }
                          }
                      }, 100L);
                  }
              } else {
                  p.sendMessage(String.valueOf(main.prefix) + "\u00a7cThis Player is not Online :(");
              }
          } else if (args.length == 0) {
              if (waitingForStats.contains(p)) {
                  p.sendMessage(String.valueOf(main.prefix) + "\u00a7cPlease Wait...");
              } else {
            	  waitingForStats.add(p);
                  final ArrayList<String> state = new ArrayList<String>();
                  p.sendMessage("\u00a7aGetting Your States Please Wait :)");
                  state.add("\u00a76\u00a7m---------------------------------------");
                  state.add(this.color("&bName&f: " + Prefix.getPrefix(p)));
                  state.add("\u00a7cRank\u00a77: " + getPs(p));
                  state.add("\u00a76Kills\u00a77: \u00a7f" + Kills.getKills(p.getUniqueId()));
                  state.add("\u00a76Points\u00a77: \u00a7f" + Kills.getKills(p.getUniqueId()));
                  state.add("\u00a76Deaths\u00a77: \u00a7f" + deaths.getdeaths(p.getUniqueId()));
                  state.add("\u00a76Coins\u00a77: \u00a7f" + Coins.getcoins(p.getUniqueId()));
                  state.add("\u00a76\u00a7m---------------------------------------");
                  Bukkit.getScheduler().runTaskLater((Plugin)main.getInstance(), new BukkitRunnable(){

                      public void run() {
                          int i = 0;
                          while (i < state.size()) {
                              p.sendMessage((String)state.get(i));
                              waitingForStats.remove(p);
                              ++i;
                          }
                      }
                  }, 100L);
              }
          } else {
              p.sendMessage(String.valueOf(main.prefix) + "\u00a7c/stats \u00a77(To View Your Own States)");
              p.sendMessage(String.valueOf(main.prefix) + "\u00a7c/stats [Player] \u00a77(To View Other Online Players States)");
          }
		}
		
		return true;
	}
	   public String color(String p) {
	        return ChatColor.translateAlternateColorCodes((char)'&', (String)p);
	    }

	    public static String getPs(Player p) {
	        if (Kills.getKills(p.getUniqueId()) >= 6000) {
	            return "The Master";
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
	 public static String getnextPs(Player p) {
	        if (Kills.getKills(p.getUniqueId()) >= 6000) {
	            return "The Master";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 6000) {
	            return "The Master";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 3500) {
	            return "\u00a74Champoin II";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 3000) {
	            return "\u00a74Champoin I";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 2800) {
	            return "\u00a7bDiamond III";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 2500) {
	            return "\u00a7bDiamond II";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 2250) {
	            return "\u00a7bDiamond I";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 2000) {
	            return "\u00a73Platinum III";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 1800) {
	            return "\u00a73Platinum II";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 1650) {
	            return "\u00a73Platinum I";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 1300) {
	            return "\u00a76Gold III";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 1000) {
	            return "\u00a76Gold II";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 700) {
	            return "\u00a76Gold I";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 500) {
	            return "\u00a77Silver III";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 400) {
	            return "\u00a77Silver II";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 300) {
	            return "\u00a77Silver I";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 200) {
	            return "\u00a7eBronze III";
	        }
	        if (Kills.getKills(p.getUniqueId()) >= 100) {
	            return "\u00a7eBronze II";
	        }
	        return "\u00a7eBronze I";
	    }

}
