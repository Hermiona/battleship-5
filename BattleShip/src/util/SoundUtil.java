/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 *
 * @author truong
 * used to play some sounds for game
 */
public class SoundUtil {
    
    //play the fire sound, after the player or the computer fire
    public static void playFireSound(){
        AudioInputStream astream = null;
        try {
            File afile = new File("sounds/explosion.wav");
            astream = AudioSystem.getAudioInputStream(afile);
            Clip audio = AudioSystem.getClip();
            audio.open(astream);
            //audio.setFramePosition(0);
            audio.start();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                astream.close();
            } catch (IOException ex) {
                Logger.getLogger(SoundUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
