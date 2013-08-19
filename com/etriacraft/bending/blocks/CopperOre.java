package com.etriacraft.bending.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CopperOre extends Block {

	public CopperOre(int id, Material material) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
		func_111022_d("Bending:copperore");
		setHardness(3.0F);
		setUnlocalizedName("CopperOre");
	}

	public int idDropped(int par1, Random random, int zero) {
		return BlockRegistry.CopperOre.blockID;
	}
}
