package com.etriacraft.bending.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SilverIngotItem extends Item {
	
public static Item silverIngotItem = new SilverIngotItem(6005);
	
	public SilverIngotItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("Silver Ingot");
		func_111206_d("Bending:silveringot");
	}
	
	public static void registerSilverIngotItem() {
		LanguageRegistry.addName(silverIngotItem, "Silver Ingot");
	}	

}

