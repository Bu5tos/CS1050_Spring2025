import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class MusicPlaylist {

	public static void main(String[] args) {
		
		/**Unit testing song info
		Song unitTestSong = new Song("Joji", "Pixelated Kisses", 109);
		System.out.println(unitTestSong.toString());
		**/
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your choice (1–7): ");
		int choice = input.nextInt();
		
		System.out.println("Enter CSV filename: ");
		String fileName = input.next();
		
		ArrayList<Song> songs = PlaylistLoader.loadSongsFromCsv(fileName);
		
		Playlist playlist = new Playlist("ow", 5); //Hard code unit test
		
		//Loop through each song of the song ArrayList 
		for(Song song : songs) {
			playlist.addSongs(song);
		}
		playlist.displayPlaylist();
		
		playlist.playCertainSong();
		
		playlist.addSongToQueue();
		
		playlist.PlayNextFromQueue();
	
		/** User story 7
		do {
			//Playlist menu selection 
			System.out.println("=== Music Playlist Menu ===");
			System.out.println("1. Load Songs from CSV");
			System.out.println("2. Display Playlist");
			System.out.println("3. Play a Song by Index");
			System.out.println("4. Add Song to Up-Next Queue");
			System.out.println("5. Show Up-Next Queue");
			System.out.println("6. Play Next from Queue");
			System.out.println("7. Exit");
		} while(input.equals(playlist));
		*/

	}//End main
	
	
}//End class

class Song {
	
	/**
	 * Encapsulating variables to be private
	 * Provide getters and setters to access or modify these instances
	 */
	private String artist;
	private String title;
	private int songLength;
	
	/**
	 * Constructor:
	 * A new object is created by this special method
	 * "this" keyword gives the current object's variables
	 * Initialize object's instances with given values 
	 */
	public Song(String artist, String title, int songLength) {
		
		this.artist = artist;
		this.title = title;
		this.songLength = songLength;
	}
	
	//Methods
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setSongLength(int songLength) {
		this.songLength = songLength;
	}
	
	public int getSongLength() {
		return songLength;
	}
	
	public String convertSecondsToFormat() {
		int minutes = songLength / 60;
		int seconds = songLength % 60;
		
		return "(" + minutes + ":" + seconds + ")";
	}
	
	//returns a string that describes the Song object
	@Override // Overrides Playlist Class method to it's own version(behavior)
	public String toString() {
		
		//Prints artist, title, songLength together as a string
		return artist + ", "+ title + ", " + convertSecondsToFormat();
	}
	
}//End Song class

class Playlist {
	
	private String name;
	private ArrayList<Song> musicLibrary;
	private SinglyLinkedList<Song> upNextQueue = new SinglyLinkedList<>();
	private int playlistCapacity;
	private int currentSongsInPlaylist;
	private int currentTotalSongs;
	private boolean isFull;
	
	public Playlist(String name, int playlistCapacity) {
		this.name = name;
		this.playlistCapacity = playlistCapacity;
		this.currentTotalSongs = 0;
		this.musicLibrary = new ArrayList<>(playlistCapacity);
		
		//Initialize ArrayList
		musicLibrary = new ArrayList<>(playlistCapacity);
		
		for(int col = 0; col < playlistCapacity; col++) {
			musicLibrary.add(null); //Add song/s to be null
		}
	}
	
	public void addSongs(Song song) {
		if(currentTotalSongs < playlistCapacity) {
			musicLibrary.set(currentTotalSongs, song);
			currentTotalSongs++;
		}
	}
	
	public void displayPlaylist() {
		for(int i = 0; i < currentTotalSongs; i++) {
			Song song = musicLibrary.get(i);
			if(song != null) {
				System.out.println("[" + i + "] \"" + song.getTitle() + "\" by " + song.getArtist() + song.convertSecondsToFormat());
			}
		}
		if(currentTotalSongs == 0) {
			System.out.println("Playlist is empty");
		}
	}
	
	//come back later. do-while??
	public void playCertainSong() {	
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter index to play: ");
		int choice = input.nextInt();
		
		if(choice < 0 || choice >= currentTotalSongs) {
			System.out.println("\nInvalid index");
			System.out.println("Please enter a number between 0 and 6");
			
		}

		Song song = musicLibrary.get(choice);
		System.out.println("Now playing: " + "\"" + song.getTitle() + "\" by " + song.getArtist() + song.convertSecondsToFormat());
	}
	
	public void addSongToQueue () {
        Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter song number to add to Up-Next List (queue): ");
		int choice = input.nextInt();
		
		if(choice < 0 || choice >= currentTotalSongs) {
			System.out.println("Invalid index. Nothing enqueued");
			System.out.println("Please enter a number between 0 and 6");
		}
		
		Song chosenSong = musicLibrary.get(choice);
		upNextQueue.addLast(chosenSong);
		System.out.println("Song added to Up-Next");
		
		//Unit Test to confirm chosen song is queued
		//System.out.println(chosenSong);
	}
	
	public void PlayNextFromQueue() {
		for(int i = 0; i < currentTotalSongs; i++) {
			Song song = musicLibrary.get(i);
			if(song != null) {
				System.out.println("[" + i + "] \"" + song.getTitle() + "\" by " + song.getArtist() + song.convertSecondsToFormat());
			}
		}
		
		if(musicLibrary == null) {
			System.out.println("Queue is empty");
		}
		else {
			Song song = musicLibrary.get(currentSongsInPlaylist);
			System.out.println("Now playing: " + "\"" + song.getTitle() + "\" by " + song.getArtist() + song.convertSecondsToFormat());
		}
		
	}
		
	
}//End Playlist class

class PlaylistLoader {
	
	public static ArrayList<Song> loadSongsFromCsv(String filename) {
	
		ArrayList<Song> songs = new ArrayList<>();
		
		try (Scanner fileScan = new Scanner(new File(filename))){
		int lineNumber = 0;
		int numOfSongsLoaded = 0;
		
		while (fileScan.hasNextLine()){
			String line = fileScan.nextLine();
			lineNumber++;
			
			String[] parts = line.split(",");
			if(parts.length != 3) {
				System.out.println("Line " + lineNumber + "skipped: " + "invalid values.");
			}
			
			String title = parts[0].trim();
			String artist = parts[1].trim();
			String durationText = parts[2].trim();
			
			int durationSeconds = 0;
			try {
				durationSeconds = Integer.parseInt(durationText);
			} catch (NumberFormatException ex) {
			     System.out.println("Line " + lineNumber + " skipped: bad number.");
			     numOfSongsLoaded--; //If invalid text, unload a song
		}
			//Print song's info
			Song song = new Song(artist, title, durationSeconds);
			songs.add(song);
			numOfSongsLoaded++;
			
			System.out.println(song.toString());
		}
		
		//Outside of while loop to prevent repetition of this line and only prints once after iteration
		//System.out.println("Loaded " + numOfSongsLoaded + " songs\n");
		
		} catch(FileNotFoundException e) {
        System.out.println("Could not open file: " + filename);
        System.out.println("No songs were loaded.");
	}
	return songs;
  }
}//End PlaylistLoader

class SinglyLinkedList<S> {
	
	Node<S> head;
	Node<S> tail;
	int count;
	
	public SinglyLinkedList() {
		
		//Head and tail is null when list is empty
		this.head = null;
		this.tail = null;
		this.count = 0; //Start count at 0
	}
	
	/**
	 * Returns the current number of elements in linkedlist
	 * In linkedlist, the number of elements can increase or decrease
	 * (nodes can be added or removed)
	 * @return
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Checks is linkedlist is empty
	 * @returns true if there are no nodes in the list
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	//Adds a value after tail(last node)
	public void addLast(S value) {
		Node<S> newNode = new Node<>(value);
		
		if(head == null) {
			tail = newNode;
		}
	}
	
	public S removeFirst() {
		
		
	}
	
	public void displayAll() {
		
	}
	
	private static class Node<S> {
	
        S value;
		Node<S> next;
		Node(S v) {
			value = v;
			next = null;
		}
	}
}//End LinkedList 