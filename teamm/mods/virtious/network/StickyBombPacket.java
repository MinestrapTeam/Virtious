package teamm.mods.virtious.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import teamm.mods.entity.item.EntityStickyBomb;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;

public class StickyBombPacket extends VirtiousPacket{
	public int entityId;
	public int posX;
	public int posZ;
	public int posY;

	public StickyBombPacket(){}

	public StickyBombPacket(EntityStickyBomb entity){
		this.isChunkDataPacket = true;
		
		this.entityId = entity.entityId;
        this.posX = MathHelper.floor_double(entity.posX * 32.0D);
        this.posY = MathHelper.floor_double(entity.posY * 32.0D);
        this.posZ = MathHelper.floor_double(entity.posZ * 32.0D);
	}
	
	@Override
	public int getID() {
		return PacketIds.STICKY_BOMB;
	}

	@Override
	public void writeData(DataOutputStream data) throws IOException {
		data.writeInt(this.entityId);
		data.writeInt(this.posX);
		data.writeInt(this.posY);
		data.writeInt(this.posZ);
	}

	@Override
	public void readData(DataInputStream data) throws IOException {
		this.entityId = data.readInt();
        this.posX = data.readInt();
        this.posY = data.readInt();
        this.posZ = data.readInt();
	}

}
