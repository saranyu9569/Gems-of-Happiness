/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splenderdemo01;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ClickSound {

    Map<String, Clip> sounds = new HashMap<>();

    public ClickSound() {
        loadResources("src\\click1.wav");
        loadResources("src\\click2.wav");
        loadResources("src\\Error.wav");
        loadResources("src\\gemm.wav");
        loadResources("src\\card.wav");
        loadResources("src\\win.wav");
    }

    private void loadResources(String sound) {
        try {
            AudioInputStream adi = AudioSystem.getAudioInputStream(new File(sound));
            Clip clip = AudioSystem.getClip();
            clip.open(adi);
            sounds.put(sound,clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void playSound(String sound){
        Clip c = sounds.get(sound);
        c.setFramePosition(0);
        c.start();
    }
}
