package com.etriacraft.bending.ChiBlocking;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ChiSpeed {
	
	public static void applySpeed(EntityPlayer player) {
		if (!player.isPotionActive(Potion.moveSpeed.id)) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 70, 0));
		}
		if (!player.isPotionActive(Potion.jump.id)) {
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 70, 1));
		}
	}

}
