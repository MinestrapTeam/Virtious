package teamm.mods.virtious.lib;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class VirtiousSound
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
            event.manager.soundPoolSounds.addSound("virtious:burfalaunt_living.wav");            
            event.manager.soundPoolSounds.addSound("virtious:burfalaunt_hurt.wav");            
            event.manager.soundPoolSounds.addSound("virtious:burfalaunt_death.wav");            
            event.manager.soundPoolSounds.addSound("virtious:laser.wav");            
        } 
        catch (Exception e)
        {
            System.err.println("Virtious: Failed to register one or more sounds.");
        }
    }
}