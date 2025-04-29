package me.framesend.magicpowder;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UnrefinedCocaine extends SlimefunItem {
    public UnrefinedCocaine(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        event.getItem().setAmount(event.getItem().getAmount() - 1);
        event.getPlayer().setHealth(Math.max(0, event.getPlayer().getHealth() - 4));
        event.getPlayer().sendMessage(ChatColor.RED + "Your nose and eyes burn.");
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20, 1));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10, 3));
    }
}
