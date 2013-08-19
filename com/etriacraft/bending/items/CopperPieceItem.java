package com.etriacraft.bending.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CopperPieceItem extends Item {
	
	public static Item copperPieceItem = new CopperPieceItem(6001);
	
	public CopperPieceItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("Copper Piece");
		func_111206_d("Bending:copperpiece");
	}
	
	public static void registerCopperPiece() {
		LanguageRegistry.addName(copperPieceItem, "Copper Piece");
	}	

}
