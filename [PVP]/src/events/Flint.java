package events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import src.main;

public class Flint implements Listener {
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void flint(org.bukkit.event.block.BlockPlaceEvent e) {
		final Block b = e.getBlockPlaced();
        Player p = e.getPlayer();
        if (!e.isCancelled()) {
		 if (b.getType() == Material.FIRE) {
				 
				 if((main.PlayerInfo.get(p.getName()).getFlint()) > 0) {
	            e.setCancelled(false);
			 main.PlayerInfo.get(p.getName()).removeflint(1);
			 updateflint(p);
            Bukkit.getScheduler().runTaskLater((Plugin)main.getInstance(), new BukkitRunnable(){
                public void run() {
                    b.setType(Material.AIR);
                }
            }, 140L);
        	}else {
        		e.setCancelled(true);
				 p.playSound(p.getLocation(),Sound.DOOR_CLOSE, 7.0f, 3.0f);
				 return;
        	}
		 }
        }
	}

	public void updateflint(Player p) {
		ItemStack item = p.getItemInHand();
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<>();
        lore.add("§f  ");
        lore.add("§eFuel: §c" + main.PlayerInfo.get(p.getName()).getFlint());
        lore.add("§f§l   ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        p.setItemInHand(item);
		
	}
	
	
}
