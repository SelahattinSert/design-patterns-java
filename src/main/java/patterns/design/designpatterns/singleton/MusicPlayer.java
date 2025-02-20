package patterns.design.designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    private final List<String> menuItems;

    private final List<String> playlist;

    private static MusicPlayer instance = null;

    private MusicPlayer() {
        menuItems = new ArrayList<>();
        playlist = new ArrayList<>();
    }

    public static MusicPlayer getInstance(){
        if (instance == null) instance = new MusicPlayer();

        return instance;
    }

    public void addMenuItem(String item){
        menuItems.add(item);
    }

    public void removeMenuItem(String item){
        menuItems.remove(item);
    }

    public void menuItemsToString(){
        for (String item : menuItems) {
            System.out.println(item);
        }
    }

    public void addPlaylist(String item){
        playlist.add(item);
    }

    public void removePlaylist(String item){
        playlist.remove(item);
    }

    public void playlistToString(){
        for (String item : playlist) {
            System.out.println(item);
        }
    }
}
