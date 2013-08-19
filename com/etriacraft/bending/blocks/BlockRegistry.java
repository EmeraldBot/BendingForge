package com.etriacraft.bending.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {
	
	public static Block CopperOre;
	public static Block SilverOre;
	public static void RegisterBlocks() {
		//Copper Ore
		CopperOre = new CopperOre(500, Material.rock);
		GameRegistry.registerBlock(CopperOre, "Copper Ore");
		LanguageRegistry.addName(CopperOre, "Copper Ore");
		MinecraftForge.setBlockHarvestLevel(CopperOre, "pickaxe", 1);
		
		//Silver
		SilverOre = new SilverOre(501, Material.rock);
		GameRegistry.registerBlock(SilverOre, "SilverOre");
		LanguageRegistry.addName(SilverOre, "Silver Ore");
		MinecraftForge.setBlockHarvestLevel(SilverOre, "pickaxe", 1);
	}
	
	

}
