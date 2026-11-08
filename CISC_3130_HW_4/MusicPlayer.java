import java.util.Map;

import java.util.Deque;

import java.util.ArrayDeque;

import java.util.HashMap;

import java.util.Scanner;

class MusicPlayer {

  // Songs can be of type record, containing attributes but no methods

  // Song ids are primitive int data types

  // Song titles are Strings and artists are also Strings

  record song(int id, String title, String artist) {}

  // Universal incrementer to assign unique int id for each song

  private static int song_id = 0;

  // The Five Data Structures
  // --------------

  private static DoublyLinkedList playlist = new DoublyLinkedList();

  private static Map<Integer, song> library = new HashMap<>();

  private static Deque<song> up_next = new ArrayDeque<>();

  private static Stack history = new Stack();

  private static Map<Integer, Integer> play_counts = new HashMap<>();

  // --------------
  
  // Current variable to track current song

  Node current;

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    // Test Playlist entries

    int i = 1;

    while (i <= 6) {

      System.out.print("\nEnter a song title: ");

      String song_title = input.nextLine();

      System.out.print("\nEnter the song's artist: ");

      String song_artist = input.nextLine();

      addSong(song_id, song_title, song_artist);

      i += 1;

    }

    input.close();

    printSong(findSong(5));

    printSong(findSong(6));

    showPlaylist();

  }

  private static void printSong(song obj) {

    if (obj == null) {

      System.out.print("\nNo such song exists.\n");

      return;

    }

    System.out.printf("\n{ id: %d, title: %s, artist: %s }\n", obj.id, obj.title, obj.artist);

  }

  private static boolean addSong(int song_id, String title, String artist) {

    // If requested song id is less than universal id count and a song in the library or playlist already exists with that id, invalidate operation

    if (MusicPlayer.song_id > song_id && findSong(song_id) != null) {

      return false;

    }

    song new_song = new song(song_id, title, artist);

    // If replacing missing song id, use prepend method

    if (MusicPlayer.song_id > song_id) {

      playlist.prepend(song_id, new_song);

    }

    else {

      playlist.append(new_song);

      MusicPlayer.song_id += 1;

    }

    library.put(song_id, new_song);

    return true;

  }

  private static song findSong(int song_id) {

    // If requested song id is greater than or equal to universal song id counter, the song doesn't exist

    if (MusicPlayer.song_id <= song_id) {

      return null;

    }

   return library.get(song_id);

  }

  private static void showPlaylist() {

    System.out.print(playlist);

  }

  private static void play(int song_id) {

    

  }

}
