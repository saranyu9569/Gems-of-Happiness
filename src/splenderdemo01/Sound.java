package splenderdemo01;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    public Sound() {
       loop("src\\sugarcooike.wav");
    }
    
    public void loop(String musicsound){
         try {
            File music = new File(musicsound);
            if (music.exists()) {
                AudioInputStream adi = AudioSystem.getAudioInputStream(music);
                Clip clip = AudioSystem.getClip();
                clip.open(adi);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{
                System.out.print("Cannot");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
