public class Node {

    Song song;
    String songName;
    String Author;
    Node left;
    Node right;

    public Node(Song song, String songName, String Author) {
        this.song = song;
        this.songName = songName;
        this.Author = Author;
        left = null;
        right = null;
        
    }
    
}
