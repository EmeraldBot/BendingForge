package com.etriacraft.bending.entities;

import com.etriacraft.bending.Bending;
import com.etriacraft.bending.items.PeltItem;
import com.etriacraft.bending.models.ModelCatDeer;
import com.etriacraft.bending.renders.RenderCatDeer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EntityCatDeer extends EntityAnimal {
	public EntityAIControlledByPlayer aiControlledByPlayer;

	public EntityCatDeer(World par1World) {
		super(par1World);
		this.setSize(0.9F, 1.8F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
		//		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, 349, false));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	protected void func_110147_ax()
	{
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
	}

	protected void updateAITasks()
	{
		super.updateAITasks();
	}

	/**
	 * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
	 * by a player and the player is holding a carrot-on-a-stick
	 */
	public boolean canBeSteered()
	{
		return true;
		//		ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
		//		return itemstack != null && itemstack.itemID == Item.carrotOnAStick.itemID;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Saddle", this.getSaddled());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setSaddled(par1NBTTagCompound.getBoolean("Saddle"));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.cat.purr";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.cat.hitt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.cat.hitt";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}

	public void moveEntityWithHeading(float par1, float par2)
	{
		if (this.riddenByEntity != null) {
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
		}
		if (!this.worldObj.isRemote) {
			this.setAIMoveSpeed(0.1F);
			super.moveEntityWithHeading(par1, par2);
		}

		this.prevLimbYaw = this.limbYaw;
		double d0 = this.posX - this.prevPosX;
		double d1 = this.posZ - this.prevPosZ;
		float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

		if (f4 > 1.0F)
		{
			f4 = 1.0F;
		}

		this.limbYaw += (f4 - this.limbYaw) * 0.4F;
		this.limbSwing += this.limbYaw;
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if (super.interact(par1EntityPlayer))
		{
			return true;
		}

		else if ( !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
		{
			//			this.setAIMoveSpeed((float) 0.5F);
			par1EntityPlayer.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return PeltItem.peltItem.itemID;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
	 * par2 - Level of Looting used to kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

		for (int k = 0; k < j; ++k)
		{
			this.dropItem(PeltItem.peltItem.itemID, 1);
		}
	}

	/**
	 * Returns true if the pig is saddled.
	 */
	public boolean getSaddled()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Set or remove the saddle of the pig.
	 */
	public void setSaddled(boolean par1)
	{
		if (par1)
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
		}
		else
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
		}
	}


	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */

	/**
	 * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
	 */
	public EntityCatDeer spawnBabyAnimal(EntityAgeable par1EntityAgeable)
	{
		return new EntityCatDeer(this.worldObj);
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	public boolean isBreedingItem(ItemStack par1ItemStack)
	{
		return par1ItemStack != null && par1ItemStack.itemID == 349;
	}

	/**
	 * Return the AI task for player control.
	 */
	public EntityAIControlledByPlayer getAIControlledByPlayer()
	{
		return this.aiControlledByPlayer;
	}

	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.spawnBabyAnimal(par1EntityAgeable);
	}

}