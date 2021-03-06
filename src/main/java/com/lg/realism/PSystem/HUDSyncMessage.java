package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class HUDSyncMessage extends AbstractPacket<HUDSyncMessage> {
	
	private static int level;
	
	public HUDSyncMessage() {}
	
	public HUDSyncMessage(int i) {
		level = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		level = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(level);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
		if(player!= null){
			IBarLevel cap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			cap.setWaterLevel(level);
		}
	}
	
	@Override
	public void handleServerSide(EntityPlayerMP player) {}
}