package events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import MySQL.Kills;
import MySQL.points;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import src.main;

public class Chat implements Listener {
	 @EventHandler(priority=EventPriority.MONITOR)
	    public void onchat(AsyncPlayerChatEvent e) {
	        e.setFormat(main.color(getPs(e.getPlayer()) + " &8❘ "+ getRankcolor(e.getPlayer()) +  e.getPlayer().getDisplayName() + " &8» &7" + e.getMessage()));
	    }
	    
	    
	 public String getRankcolor(Player p) {
		    LuckPerms api = LuckPermsProvider.get();
		 User user = api.getUserManager().getUser(p.getName());
		 if(user.getPrimaryGroup().equalsIgnoreCase("owner")) {
			 return "&e";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("Admin")) {
			 return "&c";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("dev")) {
			 return "&3";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("moderator")) {
			 return "&2";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("Helper")) {
			 return "&a";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("builder")) {
			 return "&d";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("trial")) {
			 return "&f";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("youtuber")) {
			 return "&4";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("eagle")) {
			 return "&9";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("diamond")) {
			 return "&b";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("gold")) {
			 return "&6";
		 }
		 else if(user.getPrimaryGroup().equalsIgnoreCase("member")) {
			 return "&7";
		 }else {
			 return "&7";
		 }
		 
	 }
	    
	    
	   
	    public String color(String s) {
	        return ChatColor.translateAlternateColorCodes('&', s);
	    }

	    public String getPs(Player p) {
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
