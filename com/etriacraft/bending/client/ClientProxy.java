package com.etriacraft.bending.client;

import com.etriacraft.bending.CommonProxy;
import com.etriacraft.bending.entities.EntityCatDeer;
import com.etriacraft.bending.models.ModelCatDeer;
import com.etriacraft.bending.renders.RenderCatDeer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
       
        @Override
        public void registerRenderers() {
        	RenderingRegistry.registerEntityRenderingHandler(EntityCatDeer.class, new RenderCatDeer(new ModelCatDeer(), 0.5F));
        	
        }
}