package com.etriacraft.bending.Utils;

import java.util.Arrays;

import com.etriacraft.bending.BendingCommand;

public enum Element {
	
	Air, Water, Earth, Fire, Chi;
	
	public static Element getElement(String string) {
		for (Element type: Element.values()) {
			if (type.toString().equalsIgnoreCase(string));
			return type;
		}
		return null;
	}
	
	public static Element elementFromString(String elementAsString) {
		if (Arrays.asList(BendingCommand.airbendingAliases).contains(elementAsString.toLowerCase())) return Air;
		if (Arrays.asList(BendingCommand.waterbendingAliases).contains(elementAsString.toLowerCase())) return Water;
		if (Arrays.asList(BendingCommand.earthbendingAliases).contains(elementAsString.toLowerCase())) return Earth;
		if (Arrays.asList(BendingCommand.firebendingAliases).contains(elementAsString.toLowerCase())) return Fire;
		if (Arrays.asList(BendingCommand.chiblockingAliases).contains(elementAsString.toLowerCase())) return Chi;
		
		return null;

	}

}
