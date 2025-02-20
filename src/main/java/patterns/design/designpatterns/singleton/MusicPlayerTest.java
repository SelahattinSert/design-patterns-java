package patterns.design.designpatterns.singleton;

import java.util.Scanner;

public class MusicPlayerTest {

    public static void main(String[] args) {

        MusicPlayer musicPlayer = MusicPlayer.getInstance();
        musicPlayer.addMenuItem("1-Play MP3");
        musicPlayer.addMenuItem("2-Play FLAC");
        musicPlayer.addMenuItem("3-Play AAC");
        musicPlayer.addMenuItem("4-Add to Playlist");
        musicPlayer.addMenuItem("5-Remove from Playlist");
        musicPlayer.addMenuItem("6-Show Playlist");
        musicPlayer.addMenuItem("7-Authenticate User");
        musicPlayer.addMenuItem("8-Log Event");
        musicPlayer.addMenuItem("0-Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("===== Music Player Menu ====");
            musicPlayer.menuItemsToString();
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Playing MP3");
                        break;
                    case 2:
                        System.out.println("Playing FLAC");
                        break;
                    case 3:
                        System.out.println("Playing AAC");
                        break;
                    case 4:
                        System.out.print("Enter the song name to add to playlist: ");
                        scanner.nextLine();
                        String addSong = scanner.nextLine();
                        musicPlayer.addPlaylist(addSong);
                        System.out.println("Song added: " + addSong);
                        break;
                    case 5:
                        System.out.print("Enter the song name to remove from playlist: ");
                        scanner.nextLine();
                        String removeSong = scanner.nextLine();
                        musicPlayer.removePlaylist(removeSong);
                        System.out.println("Song removed: " + removeSong);
                        break;
                    case 6:
                        System.out.println("Playlist:");
                        musicPlayer.playlistToString();
                        break;
                    case 7:
                        System.out.println("User authenticated.");
                        break;
                    case 8:
                        System.out.println("Event logged.");
                        break;
                    case 0:
                        System.out.println("Exiting Music Player. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
