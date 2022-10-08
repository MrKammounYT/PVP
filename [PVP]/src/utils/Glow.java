/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.enchantments.EnchantmentTarget
 *  org.bukkit.inventory.ItemStack
 */
package utils;

import java.lang.reflect.Field;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Glow
extends Enchantment {
    public Glow(int id) {
        super(id);
    }

    public boolean canEnchantItem(ItemStack arg0) {
        return false;
    }

    public boolean conflictsWith(Enchantment arg0) {
        return false;
    }

    public EnchantmentTarget getItemTarget() {
        return null;
    }

    public int getMaxLevel() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public int getStartLevel() {
        return 0;
    }

    public static void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glow glow = new Glow(70);
            Enchantment.registerEnchantment((Enchantment)glow);
        }
        catch (IllegalArgumentException glow) {
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

