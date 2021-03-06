package com.lg.realism.event.WaterBarEvent;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.PSystem.HUDSyncMessage;
import com.lg.realism.PSystem.NetworkHandler;
import com.lg.realism.proxy.CommonProxy;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*
 * The basis of this code partially comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public class EventThirstUpdate {
	@SubscribeEvent
	public void updateTicker(LivingUpdateEvent event) {
		if(event.getEntity() instanceof EntityPlayer && !FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			
			EntityPlayer player = (EntityPlayer)event.getEntity();
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);

			if(player.ticksExisted % ConfigManager.powerThirst == 0) {
				
				Biome biome = player.getEntityWorld().getBiomeForCoordsBody(new BlockPos(player));
				
				if((biome == Biomes.DESERT_HILLS || biome == Biomes.DESERT)){
					if(player.isSprinting()) {
						capabilities.addWaterLevel(30);
			
					} else
						capabilities.addWaterLevel(20);
						
				} else
					if(player.isSprinting()) {
						capabilities.addWaterLevel(20);
			
					} else
						capabilities.addWaterLevel(10);

				NetworkHandler.INSTANCE.sendTo(new HUDSyncMessage(capabilities.getWaterLevel()),(EntityPlayerMP)player);

				capabilities.incrementTicker();
			}
		}
	}
}
