package com.etriacraft.bending.airbending;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SpeedBoosts {
	
	public static void addSpeedBoost(EntityPlayer player) {
		if (!player.isPotionActive(Potion.moveSpeed)) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 70, 1));
		}
		if (!player.isPotionActive(Potion.jump)) {
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 70, 2));
		}
	}
	

}
