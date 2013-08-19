package com.etriacraft.bending;

import net.minecraft.item.ItemStack;

import com.etriacraft.bending.blocks.BlockRegistry;
import com.etriacraft.bending.items.CopperIngotItem;
import com.etriacraft.bending.items.SilverIngotItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipes {
	
	public static void registerRecipes() {
		GameRegistry.addSmelting(BlockRegistry.CopperOre.blockID, new ItemStack(CopperIngotItem.copperIngotItem), 0.1F); //Copper Ore -> Copper Ingot
		GameRegistry.addSmelting(BlockRegistry.SilverOre.blockID, new ItemStack(SilverIngotItem.silverIngotItem), 0.1F); // Silver Ore -> Silver Ingot
	}

}
