package minestrapteam.virtious.network;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import minestrapteam.virtious.Virtious;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public abstract class VirtiousPacket 
{
	protected boolean isChunkDataPacket = false;
	protected String channel = Virtious.CHANNEL_NAME;
	public abstract int getID();
	
	public Packet getPacket()
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		
		try
		{
			data.writeByte(getID());
			writeData(data);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = channel;
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		packet.isChunkDataPacket = this.isChunkDataPacket;
		
		return packet;
	}

	public abstract void writeData(DataOutputStream data) throws IOException;
	
	public abstract void readData(DataInputStream data) throws IOException;

	
}
