package com.etriacraft.bending.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SilverPieceItem extends Item {

	public static Item silverPieceItem = new SilverPieceItem(6002);

	public SilverPieceItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("Silver Piece");
		func_111206_d("Bending:silverpiece");
	}

	public static void registerSilverPiece() {
		LanguageRegistry.addName(silverPieceItem, "Silver Piece");
	}


}
