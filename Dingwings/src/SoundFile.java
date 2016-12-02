import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundFile
{
	boolean loops;
	Clip c;
	
	public SoundFile(String name, boolean loops)
	{
		this.loops = loops;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(name));
			c = AudioSystem.getClip();
			c.open(ais);
			if(!loops)
			{
				FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(-5.0f);
			}
			//stop();
		} catch(Exception e) {}
	}
	
	public void play()
	{
		if(true)
		{
			if(c==null) return;
			if(c.isRunning())
			{
				c.stop();
			}
			c.start();
			if(loops)
			{
				c.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				c.loop(1);
			}
		}
	}
	
	public void stop()
	{
		if(c==null) return;
		if(c.isRunning())
		{
			c.stop();
		}
	}
}