package com.etriacraft.bending.ChiBlocking;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;

public class BlockChi {

	public static HashMap<String, Long> blockedChis = new HashMap<String, Long>();

	public static boolean willChiBlock() {
		Random rand = new Random();
		int value = rand.nextInt(4) + 1; // This will return a number between 1 and Four.
		if (value <= 3) { // The value is between 1 and 3
			return true; // This will block the other bender's chi.
		}
		return false; // There is a 25% chance that a player's chi will not be blocked, that's why this is here
	}

	public static void blockChi(EntityPlayer bender) { // This blocks a player's chi.
		blockedChis.put(bender.username, System.currentTimeMillis());
		bender.addChatMessage("§6Your chi is blocked. You cannot bend for 20 seconds.");
	}

	public static boolean isChiBlocked(String bender) { // This returns true if the player's chi is blocked.
		return blockedChis.containsKey(bender);
	}

	public static void unBlockChi(EntityPlayer bender) { // Unblocks a Player's Chi.
		if (System.currentTimeMillis() > blockedChis.get(bender.username) + 20000) {
			blockedChis.remove(bender.username);
			bender.addChatMessage("§6Your chi is no longer blocked.");
		}
	}

}
