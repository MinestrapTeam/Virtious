package teamm.mods.virtious.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import teamm.mods.virtious.entity.item.EntityStickyBomb;


import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler implements IPacketHandler{
	
	public void handleStickyBomb(StickyBombPacket packet) {
		if(FMLClientHandler.instance().getSide() == Side.CLIENT){
			EntityStickyBomb entity = new EntityStickyBomb(FMLClientHandler.instance().getClient().theWorld, (double)packet.posX, (double)packet.posY, (double)packet.posZ);
	        entity.serverPosX = packet.posX;
	        entity.serverPosY = packet.posY;
	        entity.serverPosZ = packet.posZ;//add owner
	        entity.rotationYaw = 0.0F;
	        entity.rotationPitch = 0.0F;
	        entity.entityId = packet.entityId;
	        FMLClientHandler.instance().getClient().theWorld.addEntityToWorld(packet.entityId, entity);
			System.out.println("packet recived bomb");

		}
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		try
		{
			int packetID = data.read();
			switch (packetID) {

				case PacketIds.STICKY_BOMB:				

					StickyBombPacket packet2 = new StickyBombPacket();
					packet2.readData(data);
					handleStickyBomb(packet2);
					
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
