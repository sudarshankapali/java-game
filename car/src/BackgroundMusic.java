import  javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic{
    Clip clip;
    AudioInputStream sound;
    public void setFile(String soundFieName){
        try{
            File file = new File(soundFieName);
            sound = AudioSystem.getAudioInputStream(file);
            AudioFormat format = sound.getFormat();
            System.out.println("Sound file format: "+format);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }catch (Exception e){
            System.err.println("Error loading sound file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void play(){
        clip.start();
    }
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }
}
