import javax.sound.sampled.Clip;

public class Playlist {

    Song first;
    Song last;
    Song current;
    boolean loop = false;
    MusicManager m = new MusicManager();
    // Implement using a circular linked list. Make linked list circular only when
    // looping becomes true

    public void addtoQueue(String filename, String songName, String Author) {
        Song s = new Song(filename);
        m.insertSong(s, songName, Author);

        if (first == null) {
            first = s;
            last = s;
            return;
        }

        if (!loop) {
            last.next = s;
            s.prev = last;
            last = s;
        } else {
            last.next = s;
            s.prev = last;
            s.next = first;
            first.prev = s;
            last = s;
        }

    }

    public void LoopPlaylist() {
        loop = true;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void StartPlaying() {
        Clip currentClip = null;
        if (current == null) {
            current = first;
            currentClip = current.playMusic();
        }
        if (currentClip == null)
            return;

        if (loop) {
            while (true) {
                while (currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition()) {
                }
                current = current.next;
                currentClip = current.playMusic();
            }
        } else {
            while (current != null) {
                while (currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition()) {
                }
                current = current.next;
                currentClip = current.playMusic();
            }
        }
    }

    public String searchByName(String songName) {
        String s = "";
        Node n = m.find(songName);
        s = s + "Song name: " + n.songName + " By :" + n.Author;
        return s;
    }

    public String toString() {
        Song temp = first;
        String s = "";
        while (temp.next != null && temp.next != first) {
            s = s + temp.Location + "\n";
            temp = temp.next;
        }
        s = s + temp.Location;
        return s;
    }

}