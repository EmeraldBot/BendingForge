package com.etriacraft.bending;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

import com.etriacraft.bending.Utils.Element;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class BendingMethods {

	public static int AIR = 0;
	public static int WATER = 1;
	public static int EARTH = 2;
	public static int FIRE = 3;
	public static int CHI = 3;

	static Side side = FMLCommonHandler.instance().getEffectiveSide();

	public static void setElement(EntityPlayer player, Element element) {
		NBTTagCompound nbt = player.getEntityData();
		nbt.setString("Element", element.toString());
	}

	public static boolean hasElement(EntityPlayer player) {
		if (player.getEntityData().hasKey("Element")) {
			return true;
		}
		return false;

		//		if (isBender(player, "air")) return true;
		////		if (isBender(player, "water")) return true;
		//		if (isBender(player, "earth")) return true;
		//		if (isBender(player, "fire")) return true;
		//		if (isBender(player, "chi")) return true;
	}

	public static Element getElement(EntityPlayer player) {
		NBTTagCompound nbt = player.getEntityData();
		return Element.elementFromString(nbt.getString("Element"));
	}

	public static boolean isBender(EntityPlayer player, Element element) {
		if (element == Element.Air) {
			if (player.getEntityData().getString("Element").equalsIgnoreCase(Element.Air.toString())) {
				return true;
			}
			return false;

		}
		if (element == Element.Water) {
			if (player.getEntityData().getString("Element").equalsIgnoreCase(Element.Water.toString())) {
				return true;
			}
			return false;
		}
		if (element == Element.Earth) {
			if (player.getEntityData().getString("Element").equalsIgnoreCase(Element.Earth.toString())) {
				return true;
			}
			return false;
		}
		if (element == Element.Fire) {
			if (player.getEntityData().getString("Element").equalsIgnoreCase(Element.Fire.toString())) {
				return true;
			}
			return false;
		}
		if (element == Element.Chi) {
			if (player.getEntityData().getString("Element").equalsIgnoreCase(Element.Chi.toString())) {
				return true;
			}
			return false;
		}
		return false;

	}

}
