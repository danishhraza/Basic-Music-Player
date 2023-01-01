public class MusicManager {

    BST[] array = new BST[26];

    public MusicManager() {
        for (int i=0; i<26; i++) {
            array[i] = new BST();
        }
    }

    public void insertSong(Song song, String songName, String Author) {
        songName = songName.toUpperCase();
        int index = (int) (songName.charAt(0) - 65);
        array[index].insert(song, songName, Author);
    }
    public Node find(String songName) {
        songName = songName.toUpperCase();
        int index = (int) (songName.charAt(0) - 65);
        return (array[index].find(songName));
    }
    
}
