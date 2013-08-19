package com.etriacraft.bending.items;

import com.etriacraft.bending.Bending;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PeltItem extends Item {

	public static Item peltItem = new PeltItem(6000);
	
	public PeltItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("Pelt");
		func_111206_d("Bending:pelt");
	}
	
	public static void registerPelt() {
		LanguageRegistry.addName(peltItem, "Pelt");
	}	

}
