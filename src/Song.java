import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {
    String Location;
    Song next;
    Song prev;

    public Song(String Location) {
        this.Location = Location;
        next = null;
        prev = null;
    }

    public Clip playMusic() {
        try {
            File musicPath = new File(Location);

            if (!musicPath.exists()) return null;

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            // JOptionPane.showMessageDialog(null, "Press STOP to stop playing");
            return clip;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}