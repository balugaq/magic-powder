package me.framesend.magicpowder;

import org.bukkit.Effect;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;

public class UnrefinedCocaine extends SlimefunItem {
	public UnrefinedCocaine(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
	
	@Override
	public void preRegister() {
		ItemUseHandler itemUseHandler = this::onItemRightClick;
	    addItemHandler(itemUseHandler);
	}
	
	private void onItemRightClick(PlayerRightClickEvent event) {
		event.getItem().setAmount(event.getItem().getAmount() - 1);
		event.getPlayer().setHealth(event.getPlayer().getHealth() - 4);
		event.getPlayer().sendMessage(ChatColor.RED + "Your nose and eyes burn.");
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20, 1));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10, 3));
	}
}
