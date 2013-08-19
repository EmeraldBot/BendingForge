package com.etriacraft.bending;

import java.util.HashMap;

import com.etriacraft.bending.Utils.Element;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.relauncher.Side;

public class BendingPlayerTracker implements IPlayerTracker {

	public static HashMap<String, Element> benders = new HashMap<String, Element>();

	Side side = FMLCommonHandler.instance().getEffectiveSide();

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		if (side.isServer()) {
			if (BendingMethods.hasElement(player)) {
				player.addChatMessage("Element: " + BendingMethods.getElement(player).toString());
				benders.put(player.username, BendingMethods.getElement(player));
			}
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		if (side.isServer()) {
			if (benders.containsKey(player.username)) {
				benders.remove(player.username); // Removes the player from the HashMap.
			}
		}

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

}
