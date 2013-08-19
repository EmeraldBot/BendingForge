package com.etriacraft.bending.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GoldPieceItem extends Item {

	public static Item goldPieceItem = new GoldPieceItem(6003);

	public GoldPieceItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("Gold Piece");
		func_111206_d("Bending:goldpiece");
	}

	public static void registerGoldPiece() {
		LanguageRegistry.addName(goldPieceItem, "Gold Piece");
	}	

}
