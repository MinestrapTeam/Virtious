package minestrapteam.virtious.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import minestrapteam.virtious.entity.item.EntityStickyBomb;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;

public class StickyBombPacket extends VirtiousPacket{
	public int entityId;
	public int posX;
	public int posZ;
	public int posY;
	
	public int dimID;

	public StickyBombPacket(){}

	public StickyBombPacket(EntityStickyBomb entity){
		this.isChunkDataPacket = true;
		
		this.entityId = entity.entityId;
        this.posX = MathHelper.floor_double(entity.posX);
        this.posY = MathHelper.floor_double(entity.posY);
        this.posZ = MathHelper.floor_double(entity.posZ);
        this.dimID = entity.dimension;
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
		data.writeInt(this.dimID);
	}

	@Override
	public void readData(DataInputStream data) throws IOException {
		this.entityId = data.readInt();
        this.posX = data.readInt();
        this.posY = data.readInt();
        this.posZ = data.readInt();
        this.dimID = data.readInt();
	}

}
