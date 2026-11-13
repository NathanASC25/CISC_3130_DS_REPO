import java.util.Map;

import java.util.Deque;

import java.util.ArrayDeque;

import java.util.HashMap;

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
  
  // Current variable to track current song in playlist

  private static Node current;

  // Currently Playing variable to track current playing song

  private static Node current_playing_song;

  // Loop Node Tracking variable as a buffer practice for convenient searching in general
  
  private static Node loop_node_tracker;

  public static void main(String[] args) {

    // Test Section 1

    System.out.print("\n--- 1. Build the playlist ---\n");

    // Test Playlist entries

    boolean add_attempt_1 = addSong(song_id, "Night Drive", "A");

    boolean add_attempt_2 = addSong(song_id, "Slow Tide", "B");

    boolean add_attempt_3 = addSong(song_id, "Copper Sky", "C");

    boolean add_attempt_4 = addSong(song_id, "Static Bloom", "D");

    boolean add_attempt_5 = addSong(song_id, "Low Orbit", "E");

    boolean add_attempt_6 = addSong(song_id, "Glass Rivers", "F");

    // Print validity of adding song attempts

    System.out.printf("%b\n", add_attempt_1);

    System.out.printf("%b\n", add_attempt_2);

    System.out.printf("%b\n", add_attempt_3);

    System.out.printf("%b\n", add_attempt_4);

    System.out.printf("%b\n", add_attempt_5);

    System.out.printf("%b\n", add_attempt_6);

    // Set head and current nodes to playlist head after list initialization

    head = playlist.head;

    // Current variable is reset to head once all songs are added to the playlist

    current = head;

    loop_node_tracker = head;

    // Check if duplicate of song 3 (count instances of song name)

    int name_instances = 0;

    boolean duplicate_s3 = false;

    Node temp = loop_node_tracker;

    for (int i = 1; i <= 6; i += 1) {

      if (current.val.title.equals("Copper Sky")) {

        name_instances += 1;

      }

      loop_node_tracker = loop_node_tracker.next;

    }

    loop_node_tracker = temp;

    if (name_instances > 1) {

      duplicate_s3 = true;

    }

    System.out.printf("duplicate s3: %b\n", duplicate_s3);

    //printSong(findSong("F"));

    //printSong(findSong("G"));

    System.out.print("playlist: ");

    showPlaylist();

    // Test Section 2

    System.out.print("\n--- 2. Look up songs ---");

    // Fourth song has the id number: 3

    Node find_fourth_song = findSong(3);

    // Ninth song would have the id number: 8

    Node find_ninth_song = findSong(8);

    // Handle Null Exceptions in case respective song doesn't exist, otherwise print title

    try {

      System.out.printf("\nfind s4: %s", find_fourth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nfind s4: null");

    }

    try {

      System.out.printf("\nfind s9: %s", find_ninth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nfind s9: null");

    }

    // LinkedList Print method

    // System.out.print(playlist);

    System.out.print("\n--- 3. Play and move forward ---");

    // First song starts at index 0

    Node play_first_song = play(0);

    Node play_ninth_song = play(8);

    try {

      System.out.printf("\nplay s1: %s", play_first_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nplay s1: null");

    }

    try {

      System.out.printf("\nplay s9: %s", play_ninth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nplay s9: null");

    }

    System.out.print("\n--- 4. Up next ---");

    boolean deque_mod_1 = queueLater(4);

    boolean deque_mod_2 = queueLater(5);

    boolean deque_mod_3 = queueNext(0);

    boolean deque_mod_4 = queueLater(8);

    DoublyLinkedList up_next_list = showUpNext();

    System.out.printf("\n%b", deque_mod_1);

    System.out.printf("\n%b", deque_mod_2);

    System.out.printf("\n%b", deque_mod_3);

    System.out.printf("\nqueue s9: %b", deque_mod_4);

    System.out.print("\nup next: [");

    loop_node_tracker = up_next_list.head;

    while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]", loop_node_tracker.val.title);

    loop_node_tracker = temp;

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

  // Overloaded help method: findSong using parameter: int song_id

  private static Node findSong(int song_id) {

    if (song_id == head.val.id) {

      // Give head node reference for playCounts method

      // Buffer node pointer practice for protection from modification

      Node buffer = head;

      return head;

    }

    // Keep Node reference to revert changes back to original current Node position in case target is non-existent, whether it was the head Node or elsewhere

    Node temp = loop_node_tracker;

    loop_node_tracker = head;

    // Searching works only for list of sorted ids

    // First general while loop attempt

   /* while (current != null) {

      if (song_id == current.val.id) {

        Node foundNode = current;

        current = temp;

        return foundNode;

      }

      if (current.val.id < song_id) {

        current = current.next;

      }

      if (current.val.id > song_id) {

        current = current.prev;

      }

    }*/

    // Second general while loop attempt

    while (loop_node_tracker != null) {

      if (loop_node_tracker.val.id == song_id) {

        Node foundNode = loop_node_tracker;

        loop_node_tracker = temp;

        return foundNode;

      }

      //System.out.println("Hello");

      loop_node_tracker = loop_node_tracker.next;

    }

  //  if (current == null)

    loop_node_tracker = temp;

  //  System.out.print("\nSong doesn't exist\n");

    return null;

  }

  private static void showPlaylist() {

    Node temp = loop_node_tracker;

    loop_node_tracker = head;

    System.out.print("\n[ ");

    while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]\n", loop_node_tracker.val.title);

    // Revert back to current variable's original Node position

    loop_node_tracker = temp;

  }

  private static Node play(int song_id) {

    if (current_playing_song != null) {

      history.push(current_playing_song.val);

    }

    if (song_id == head.val.id) {

      // Buffer node pointer practice for protection from modification

      start(findSong(song_id));

      Node foundNode = head;

      return foundNode;

    }

    // Preserve initial position of current node and reassign if target doesn't exist

    Node temp = loop_node_tracker;

    loop_node_tracker = head;

    // First general while loop attempt

    /*while (current != null) {

      if (song_id == current.val.id) {

        start(current);

        return;

      }

      if (song_id > current.val.id) {

        current = current.next;

      }

      if (song_id < current.val.id) {

        current = current.prev;

      }

    }*/

    // Second general while loop attempt

    while (loop_node_tracker != null) {

      if (loop_node_tracker.val.id == song_id) {

        Node foundNode = loop_node_tracker;

        loop_node_tracker = temp;

        start(foundNode);

	return foundNode;

      }

      //System.out.println("Hello");

      loop_node_tracker = loop_node_tracker.next;

    }

    loop_node_tracker = temp;

    //if (current == null)

    //System.out.print("\nSong doesn't exist\n");

    return null;

  }

  // Helper method -> parameter: song of type Node for retrieval from playlist

  private static void start(Node song) {

    if (findSong(song.val.title) == null) {

      System.out.print("\nSong doesn't exist.\n");

      return;

    }

    current_playing_song = song;

    //System.out.printf("\nPlaying: %s\n", current.val.title);
    
    if (play_counts.get(song.val.id) != null) {

      play_counts.put(song.val.id, play_counts.get(song.val.id) + 1);

    }

    else {

      play_counts.put(song.val.id, 1);

    }

  }

  // nowPlaying method

  private static Node nowPlaying() {

    if (current_playing_song == null) {

      System.out.print("\nNo song is currently playing.\n");

    }

    else {

      System.out.printf("\nSong (%s) is currently playing\n", current_playing_song.val.title);

    }

    return current_playing_song;

  }

  // playCount method

  private static int playCount(int song_id) {

    // Exception handling in case song doesn't exist

    try {

      // Uses findSong method utilizing integer id as parameter

      System.out.printf("\nSong (%s) has been played %d times.\n", findSong(song_id));

      return play_counts.get(song_id);

    }

    catch (Exception e) {

      System.out.print("\nSong doesn't exist\n");

      return 0;

    }

  }

  private static boolean queueLater(int song_id) {

    if (findSong(song_id) == null) {

      return false;

    }
    
    up_next.addLast(findSong(song_id).val);

    return true;

  }

  private static boolean queueNext(int song_id) {

    if (findSong(song_id) == null) {

      return false;

    }

    up_next.addFirst(findSong(song_id).val);

    return true;

  }

  private static DoublyLinkedList showUpNext() {

    if (up_next.size() == 0) {

      return null;

    }

    DoublyLinkedList up_next_list = new DoublyLinkedList();

    Deque<song> copy = new ArrayDeque<>(up_next);

    //Node temp = current;

    //current = up_next.getFirst();

    while (copy.size() > 0) {

      up_next_list.append(copy.pollFirst());

    }

    //current = temp;
    
    return up_next_list;

  }

  /*private static Node next() {

    return

  }*/

}
