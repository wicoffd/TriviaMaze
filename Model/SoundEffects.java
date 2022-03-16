package Model;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class SoundEffects {
    public static File runAway = new File("src/Model/RunCoward.wav");
    public static File strangeOccurence = new File("src/Model/ILLUMINATI CONFIRMED shorter.wav");
    public static File footsteps = new File("src/Model/footstep.wav");
    public static void PlaySound(File sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);

        }catch (Exception e){

        }
    }

}
