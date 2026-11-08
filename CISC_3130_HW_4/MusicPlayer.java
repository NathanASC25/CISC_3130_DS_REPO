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

  private static Map<String, Node> library = new HashMap<>();

  private static Deque<song> up_next = new ArrayDeque<>();

  private static Stack history = new Stack();

  private static Map<Integer, Integer> play_counts = new HashMap<>();

  // --------------
  
  // Head Node variable to keep pointer to head node (first song) for necessary reassignment
  
  private static Node head;
  
  // Current variable to track current song and latest song added to library and playlist

  private static Node current;

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

    printSong(findSong("F"));

    printSong(findSong("G"));

    showPlaylist();

  }

  private static void printSong(Node obj) {

    if (obj == null) {

      System.out.print("\nNo such song exists.\n");

      return;

    }

    System.out.printf("\n{ id: %d, title: %s, artist: %s }\n", obj.val.id, obj.val.title, obj.val.artist);

  }

  private static boolean addSong(int song_id, String title, String artist) {

    // If requested song id is less than universal id count and a song in the library or playlist already exists with that id, invalidate operation

    if (MusicPlayer.song_id > song_id && findSong(title) != null) {

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

    // If song dded to playlist is first song, current node will be first song. Otherwise, move to next node to add to the library.

    if (new_song.id == 0) {

      head = playlist.head;

      current = head;

    }

    else {

      current = current.next;

    }

    library.put(new_song.title, current);

    return true;

  }

  private static Node findSong(String song_title) {

    // OLD: If requested song id is greater than or equal to universal song id counter, the song doesn't exist

    /*if (MusicPlayer.song_id <= song_id) {

      return null;

    }*/

   return library.get(song_title);

  }

  private static void showPlaylist() {

    System.out.print(playlist);

  }
/*
  private static void play(int song_id) {

    

  }*/

}
