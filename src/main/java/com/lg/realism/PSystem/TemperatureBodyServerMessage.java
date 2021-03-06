package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class TemperatureBodyServerMessage extends AbstractPacket<TemperatureBodyServerMessage> {
	
	private static float temp;
	
	public TemperatureBodyServerMessage() {}
	
	public TemperatureBodyServerMessage(float i) {
		temp = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		temp = buf.readFloat();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(temp);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {

	}
	
	@Override
	public void handleServerSide(EntityPlayerMP player) {
		if(player!= null){
			IBarLevel cap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			cap.setTempBody(temp);
		}
	}
}