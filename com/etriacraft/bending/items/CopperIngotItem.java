package com.etriacraft.bending.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CopperIngotItem extends Item {
	
public static Item copperIngotItem = new CopperIngotItem(6004);
	
	public CopperIngotItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("Copper Ingot");
		func_111206_d("Bending:copperingot");
	}
	
	public static void registerCopperIngot() {
		LanguageRegistry.addName(copperIngotItem, "Copper Ingot");
	}	

}

