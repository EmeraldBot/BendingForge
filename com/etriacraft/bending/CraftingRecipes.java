package com.etriacraft.bending;

import com.etriacraft.bending.items.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes {
	
	public static void registerRecipes() {
		// All of the possible recipes for a Gold Piece
		GameRegistry.addRecipe(new ItemStack(GoldPieceItem.goldPieceItem, 6), "xxx", "   ", "   ", 'x', Item.ingotGold);
		GameRegistry.addRecipe(new ItemStack(GoldPieceItem.goldPieceItem, 6), "   ", "xxx", "   ", 'x', Item.ingotGold);
		GameRegistry.addRecipe(new ItemStack(GoldPieceItem.goldPieceItem, 6), "   ", "   ", "xxx", 'x', Item.ingotGold);
		
		//All of the possible recipes for a Bronze Piece.
		GameRegistry.addRecipe(new ItemStack(CopperPieceItem.copperPieceItem, 6), "xxx", "   ", "   ", 'x', CopperIngotItem.copperIngotItem);
		GameRegistry.addRecipe(new ItemStack(CopperPieceItem.copperPieceItem, 6), "   ", "xxx", "   ", 'x', CopperIngotItem.copperIngotItem);
		GameRegistry.addRecipe(new ItemStack(CopperPieceItem.copperPieceItem, 6), "   ", "xxx", "   ", 'x', CopperIngotItem.copperIngotItem);
		
		//All of the possible recipes for a Silver Piece.
		GameRegistry.addRecipe(new ItemStack(SilverPieceItem.silverPieceItem, 6), "xxx", "   ", "   ", 'x', SilverIngotItem.silverIngotItem);
		GameRegistry.addRecipe(new ItemStack(SilverPieceItem.silverPieceItem, 6), "   ", "xxx", "   ", 'x', SilverIngotItem.silverIngotItem);
		GameRegistry.addRecipe(new ItemStack(SilverPieceItem.silverPieceItem, 6), "   ", "   ", "xxx", 'x', SilverIngotItem.silverIngotItem);
	}

}
