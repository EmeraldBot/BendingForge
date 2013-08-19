package com.etriacraft.bending;

import java.util.Random;

import com.etriacraft.bending.ChiBlocking.BlockChi;
import com.etriacraft.bending.ChiBlocking.ChiSpeed;
import com.etriacraft.bending.Utils.Element;
import com.etriacraft.bending.airbending.SpeedBoosts;
import com.etriacraft.bending.entities.EntityCatDeer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class BendingEvents {

	Random generator = new Random();

	@ForgeSubscribe
	public void onHurtAttack(LivingHurtEvent e) {
		if (e.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.entity;
			if (!player.worldObj.isRemote) {
				player.addChatMessage("You took damage.");
			}
		}
	}
	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent e) {
		if (e.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.entity;
			if (!player.worldObj.isRemote) { 
				if (BlockChi.isChiBlocked(player.username)) {
					BlockChi.unBlockChi(player);
				}
				if (BendingPlayerTracker.benders.containsKey(player.username)) {
					if (BendingMethods.isBender(player, Element.Air)) { // This checks that the player is an Airbender
						if (player.isSprinting()) {
							SpeedBoosts.addSpeedBoost(player); // Gives the player the Airbending Speed Boosts
						}
					}
					if (BendingMethods.isBender(player, Element.Chi)) { // This checks if the player is a ChiBlocker
						if (player.isSprinting()) {
							ChiSpeed.applySpeed(player); // Gives the player the Chi Speed Boosts.
						}
					}
				}

			}
		}
	}
	//	@ForgeSubscribe
	//	public void onLivingUpdate(LivingUpdateEvent e) {
	//		if (e.entity instanceof EntityPlayer) {
	//			EntityPlayer player = (EntityPlayer) e.entity;
	//			if (BendingPlayerTracker.benders.containsKey(player.username)) {
	//				if (BendingMethods.isBender(player, "air")) {
	//					if (player.isSprinting()) {
	//					} else {
	//						
	//					}
	//				}
	//			}
	//		}
	//	}
	//	@ForgeSubscribe
	//	public void EntityInteract(EntityInteractEvent e) {
	//		EntityPlayer player = (EntityPlayer) e.entityPlayer;
	//		if (e.target instanceof EntityCatDeer) {
	//			if (!player.worldObj.isRemote) {
	//				EntityCatDeer catDeer = (EntityCatDeer) e.target;
	//				if (catDeer.isTamed()) {
	//					player.mountEntity(catDeer);
	//					
	//				}
	//				if (!catDeer.isTamed()) {
	//					if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().itemID == 349) {
	//						--player.inventory.getCurrentItem().stackSize;
	//						if (generator.nextInt(5) == 0) {
	//							catDeer.setTamed(true);
	//							catDeer.setOwner(player.getCommandSenderName());
	//							catDeer.playTameEffect(true, catDeer.worldObj);
	//							return;
	//						} else {
	//							catDeer.playTameEffect(false, catDeer.worldObj);
	//							return;
	//						}
	//
	//					}
	//				}
	//			}
	//		}
	//	}

}
