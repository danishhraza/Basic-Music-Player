import java.io.File;

public class main {

    public static void main(String[] args) {
        Playlist a = new Playlist();
        File folder = new File("C:/Users/Shayan/Desktop/Coding/Music");
        File[] files = folder.listFiles();
        System.out.println("Scanning for songs...");
        int songCounter = 1;
        for (File file : files) {
            a.addtoQueue(file.getPath(), "song" + songCounter++, "author" + songCounter);
        }
        songCounter--;
        System.out.println("Found " + songCounter + " songs in your default folder");
        System.out.println("Putting your playlist on loop");
        a.LoopPlaylist();
        System.out.println("Finding sonng by the name: song1...");
        System.out.println("Found: " + a.searchByName("song1"));
        System.out.println("------------------------------------");
        System.out.println("Lets print out your whole playlist!");
        System.out.println(a.toString());
        System.out.println("--------------------------------------");
        System.out.println("Lets play some jazz!");
        a.StartPlaying();
    }

}