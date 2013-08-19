package com.etriacraft.bending;

import com.etriacraft.bending.blocks.BlockRegistry;
import com.etriacraft.bending.entities.EntityCatDeer;
import com.etriacraft.bending.items.CopperIngotItem;
import com.etriacraft.bending.items.CopperPieceItem;
import com.etriacraft.bending.items.GoldPieceItem;
import com.etriacraft.bending.items.PeltItem;
import com.etriacraft.bending.items.SilverIngotItem;
import com.etriacraft.bending.items.SilverPieceItem;
import com.etriacraft.bending.models.ModelCatDeer;
import com.etriacraft.bending.renders.RenderCatDeer;

import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Bending", name="Bending", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, packetHandler=BendingPacketHandler.class, channels={"Bending"})
public class Bending {

	// Variables
	public static Configuration config;
	public static String modid = "Bending";
	// The instance of your mod that Forge uses.
	@Instance("Bending")
	public static Bending instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="com.etriacraft.bending.client.ClientProxy", serverSide="com.etriacraft.bending.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler // used in 1.6.2
	public void load(FMLInitializationEvent event) {
		
		//Register our Entities
		//CatDeer
//		RenderingRegistry.registerEntityRenderingHandler(EntityCatDeer.class, new RenderCatDeer(new ModelCatDeer(), 0.5F));
		EntityRegistry.addSpawn(EntityCatDeer.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills);
		EntityRegistry.registerGlobalEntityID(EntityCatDeer.class, "CatDeer", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
		EntityRegistry.registerModEntity(EntityCatDeer.class, "CatDeer", 1, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("entity.CatDeer.name", "CatDeer");
        
        // Register our items.
        PeltItem.registerPelt();
        CopperPieceItem.registerCopperPiece();
        SilverPieceItem.registerSilverPiece();
        GoldPieceItem.registerGoldPiece();
        CopperIngotItem.registerCopperIngot();
        SilverIngotItem.registerSilverIngotItem();
        
        BlockRegistry.RegisterBlocks(); // Registers blocks.
                
        CraftingRecipes.registerRecipes(); // Registers all Crafting Recipes
        SmeltingRecipes.registerRecipes(); // Registers all Smelting Recipes
        
        GameRegistry.registerWorldGenerator(new BendingOreGenerator()); // Register Bending Ore Generator.
        
        GameRegistry.registerPlayerTracker(new BendingPlayerTracker()); // Register Player Tracker
        // Register our events.
        MinecraftForge.EVENT_BUS.register(new BendingEvents());
        MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler // used in 1.6.2
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		ICommandManager manager = MinecraftServer.getServer().getCommandManager();
		ServerCommandManager servermanager = (ServerCommandManager) manager;
		
		servermanager.registerCommand(new BendingCommand());
	}


}