package com.seleniummc.seleniumcore.recipes;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class DropperRecipe
{
    private final SeleniumCore plugin;

    public DropperRecipe(SeleniumCore plugin)
    {
        this.plugin = plugin;
    }

    public void init() {
        ItemStack item = new ItemStack(Material.DISPENSER);
        NamespacedKey key = new NamespacedKey(plugin, "dispenser");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(
                " s|",
                "sd|",
                " s|"
        );
        recipe.setIngredient('s', Material.STICK);
        recipe.setIngredient('d', Material.DROPPER);
        recipe.setIngredient('|', Material.STRING);
        Bukkit.addRecipe(recipe);
    }
}
