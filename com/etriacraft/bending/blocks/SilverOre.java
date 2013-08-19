package com.etriacraft.bending.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SilverOre extends Block {
	
	public SilverOre(int id, Material material) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
		func_111022_d("Bending:silverore");
		setHardness(3.0F);
		setUnlocalizedName("SilverOre");
	}

	public int idDropped(int par1, Random random, int zero) {
		return BlockRegistry.SilverOre.blockID;
	}

}
