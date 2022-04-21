package test_20;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class BGM {
	
	public BGM() {
		try {
			//소리 입력
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound/bgm.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			//볼륨 조절
			FloatControl control = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(-40.0f);
			//재생
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
