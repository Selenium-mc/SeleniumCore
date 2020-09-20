package com.seleniummc.seleniumcore.recipes;

import com.seleniummc.seleniumcore.SeleniumCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RepeaterRecipe
{
    private final SeleniumCore plugin;

    public RepeaterRecipe(SeleniumCore plugin)
    {
        this.plugin = plugin;
    }

    public void init() {
        ItemStack item = new ItemStack(Material.REPEATER);
        NamespacedKey key = new NamespacedKey(plugin, "repeater");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(
                "r r",
                "trt",
                "sss"
        );
        recipe.setIngredient('s', Material.STONE);
        recipe.setIngredient('t', Material.STICK);
        recipe.setIngredient('r', Material.REDSTONE);
        Bukkit.addRecipe(recipe);
    }
}
