package me.framesend.magicpowder;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class CocaLeaf extends SlimefunItem {
	public CocaLeaf(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
	
	@Override
	public void preRegister() {
		ItemUseHandler itemUseHandler = this::onItemRightClick;
	    addItemHandler(itemUseHandler);
	}
	
	private void onItemRightClick(PlayerRightClickEvent event) {
		
	}
}
