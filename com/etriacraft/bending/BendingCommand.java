package com.etriacraft.bending;

import java.util.Arrays;

import com.etriacraft.bending.ChiBlocking.BlockChi;
import com.etriacraft.bending.Utils.Element;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;

public class BendingCommand extends CommandBase {

	//Command Aliases
	public static String[] chooseAliases = {"choose", "ch", "c"};

	public final static String[] airbendingAliases = { "air", "a", "airbender",
		"airbending", "airbend" };
	public final static String[] earthbendingAliases = { "earth", "e", "earthbender",
		"earthbending", "earthbend" };
	public final static String[] firebendingAliases = { "fire", "f", "firebender",
		"firebending", "firebend" };
	public final static String[] waterbendingAliases = { "water", "w", "waterbender",
		"waterbending", "waterbend" };
	public final static String[] chiblockingAliases = { "chi", "c", "chiblock",
		"chiblocker", "chiblocking" };
	@Override
	public String getCommandName() {
		return "bending";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) {
		Side side = FMLCommonHandler.instance().getEffectiveSide();

		if (!(icommandsender instanceof EntityPlayerMP)) {
			return;
		}
		EntityPlayer player = (EntityPlayerMP) icommandsender;
		NBTTagCompound nbt = player.getEntityData();

		if (args.length == 0) {
			player.addChatMessage("§4/bending choose [element] §f- Picks an element.");
			player.addChatMessage("§4/bending who [Player] §f- Show a player's element.");
			return;
		}

		if (side.isServer()) {
			if (Arrays.asList(chooseAliases).contains(args[0].toLowerCase())) {
				if (args.length != 2) {
					player.addChatMessage("§eProper Usage: /bending choose [Air|Water|Earth|Fire|Chi]");
					return;
				}
				if (BendingMethods.hasElement(player)) {
					player.addChatMessage("§eYou already have an element.");
					return;
				}
				if (Arrays.asList(airbendingAliases).contains(args[1].toLowerCase())) {
					//					BendingMethods.setElement(player, "air");
					player.addChatMessage("§eYou are now an §7airbender.");
					BendingPlayerTracker.benders.put(player.username, Element.Air);
					BendingMethods.setElement(player, Element.Air);
					return;
				} 
				if (Arrays.asList(waterbendingAliases).contains(args[1].toLowerCase())) {
					//					BendingMethods.setElement(player, "water");
					player.addChatMessage("§eYou are now a §bwaterbender.");
					BendingPlayerTracker.benders.put(player.username, Element.Water);
					BendingMethods.setElement(player, Element.Water);
					return;
				}
				if (Arrays.asList(earthbendingAliases).contains(args[1].toLowerCase())) {
					//					BendingMethods.setElement(player, "earth");
					player.addChatMessage("§eYou are now an §aearthbender.");
					BendingPlayerTracker.benders.put(player.username, Element.Earth);
					BendingMethods.setElement(player, Element.Earth);

					return;
				}
				if (Arrays.asList(firebendingAliases).contains(args[1].toLowerCase())) {
					//					BendingMethods.setElement(player, "fire");
					player.addChatMessage("§eYou are now a §cfirebender.");
					BendingPlayerTracker.benders.put(player.username, Element.Fire);
					BendingMethods.setElement(player, Element.Fire);
					return;
				}
				if (Arrays.asList(chiblockingAliases).contains(args[1].toLowerCase())) {
					//					BendingMethods.setElement(player, "chi");
					player.addChatMessage("§eYou are now a §6chiblocker.");
					BendingPlayerTracker.benders.put(player.username, Element.Chi);
					BendingMethods.setElement(player, Element.Chi);
				} else {
					player.addChatMessage("§eProper Usage: /bending choose Air|Water|Earth|Fire|Chi");
					return;
				}
			}
		}
	}
} 