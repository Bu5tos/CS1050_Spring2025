import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap; // Iteration 02 UPDATE (User Story 8): for fast lookup by ID
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator; // Iteration 02 UPDATE (User Story 9): for sorting


public class MusicPlaylist {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String fileName; //Stores filename when user user types in keyboard
		
		ArrayList<Song> songs = null; //variable songs will be holding songs from CSV file
		Playlist playlist = null; //Created an object to use playlist class in this class
		
		final int MENU_END = 9;
		final String menuPrompt = "Enter your choice (1–" + MENU_END + "): ";
		int choice;
		
		do {
			
			//Playlist menu selection 
			System.out.println("\n=== Music Playlist Menu ===");
			System.out.println("1. Load Songs from CSV");
			System.out.println("2. Display Playlist");
			System.out.println("3. Play Song by Index");
			System.out.println("4. Add Song to Up-Next Queue");
			System.out.println("5. Show Up-Next Queue");
			System.out.println("6. Play Next Song in Up-Next Queue");
			System.out.println("7. Search Songs (by ID or Artist)");
			//System.out.println("7. Exit");
			System.out.println("8. View Playlist Sorted");
			System.out.println("9. Exit");
			
			choice = getValidInt(input, menuPrompt, 1, MENU_END);
			
            switch (choice) {
			
            /**
             * Case 1: Loads songs from CSV file
             * Case 2: Displays songs in playlist
             * Case 3: Plays certain song by user's choice of index
             * Case 4: Adds song to queue (First line)
             * Case 5: Peek what songs are next
             * Case 6: Plays next Up-Next song
             * Then exit menu when user inputs 7
             */
            case 1:
            	System.out.println("Enter CSV filename: ");
        		fileName = input.next();
        		
        		songs = PlaylistLoader.loadSongsFromCsv(fileName);   		
        		playlist = new Playlist("Life debugger", 50); //Hard code unit test
        		
        		//Loop through each song of the song ArrayList 
        		for(Song song : songs) {
        			playlist.addSongs(song);
        		}
        		
        		/** ????
        		System.out.println("Enter CSV filename: ");
        		String filename = input.next();
        		boolean loaded = playlist.loadSongsFromCsv(fileName);  
        		if (!loaded)
				{
					System.out.println("No songs were loaded.");
					System.out.println("Working directory: " + java.nio.file.Paths.get("").toAbsolutePath());
				} else
				{
					// Iteration 02 UPDATE (User Story 8): build HashMap for ID lookup after loading
					playlist.buildByIdMap();
				}
        		*/
        		break;
        		
            case 2:
            	playlist.displayPlaylist(); 
            	break;
            
            case 3: 
            	playlist.playCertainSong();
            	break;
            	
            case 4:
            	playlist.addSongToQueue();
            	break;
            	
            case 5:
            	playlist.ShowUpNextQueue();
            	break;
            	
            case 6:
            	playlist.PlayNextFromQueue();
            	break;
            	
            case 7:
            	System.out.println("\nSearch Options");
            	System.out.println("1. Find song by ID");
            	System.out.println("2. List songs by artist");
            	
            	int searchChoice = getValidInt(input, "Enter search choice: ", 1, 2);

            	if (searchChoice == 1)
				{
					System.out.print("Enter song ID (e.g., S1000): ");
					String id = input.next();
					playlist.playSongById(id);
				} else
				{
					System.out.print("Enter artist name: ");
					String artist = input.next();
					playlist.displaySongsByArtist(artist);
				}
				break;
				
            case 8:
            	System.out.println("\nSort Options");
				System.out.println("1. Sort by title A–Z");
				System.out.println("2. Sort by duration longest first");
				int sortChoice = getValidInt(input, "Enter sort choice: ", 1, 2);
				if (sortChoice == 1)
				{
					playlist.displayPlaylistSortedByTitle();
				} else
				{
					playlist.displayPlaylistSortedByDuration();
				}
				break;
            }
		} while (choice != MENU_END);
		System.out.println("Menu exited");
	}//End main
	
	//Validate input between 0 to 7
	public static int getValidInt(Scanner inputKeyboard, String prompt, int min, int max) {
		System.out.println("\n" + prompt);
		
		int currentInt = inputKeyboard.nextInt();
		
	      while(currentInt < min || currentInt > max) {
	    	  System.out.println("Invalid input. Choose a number between (" + min + "-" + max + "): ");
	    	  currentInt = inputKeyboard.nextInt();
	      }
	            return currentInt; 
	}
	
}//End class

class Song {
	
	/**
	 * Encapsulating variables to be private
	 * Provide getters and setters to access or modify these instances
	 */
	private String artist;
	private String title;
	private int songLength;
	private static int nextSongID = 1000; //Start ID at 1000
	private int uniqueSongID;
	
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
		this.uniqueSongID = nextSongID;
		nextSongID++;
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
	
	//Convert seconds to m:ss
	public String convertSecondsToFormat() {
		int minutes = songLength / 60;
		int seconds = songLength % 60;
		
		return "(" + minutes + ":" + seconds + ")";
	}
	
	public String songID() {
		return "S" + uniqueSongID;
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
		} //Exit loop when musicLibrary reaches to 6 indexes
	}
	
	/**Adds songs if there's still space to be filled in
	 * (for each loop)
	 * @param song
	 */
	public void addSongs(Song song) {
		if(currentTotalSongs < playlistCapacity) {
			musicLibrary.set(currentTotalSongs, song); //Songs gets filled when loaded
			currentTotalSongs++;
		}
	}
	
	//Displays song's info in playlist
	public void displayPlaylist() {
		for(int i = 0; i < currentTotalSongs; i++) {
			Song song = musicLibrary.get(i);
			if(song != null) {
				System.out.println("[" + i + "]" + song.songID() + " \"" + song.getTitle() + "\" by " + song.getArtist() + " " + song.convertSecondsToFormat());
			}
		}
		if(currentTotalSongs == 0) {
			System.out.println("Playlist is empty");
		}
	}
	
	/**
	 * Plays searched song by index
	 * (come back later. do-while??)
	 */
	public void playCertainSong() {	
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter index to play: ");
		int choice = input.nextInt();
		
		while (choice < 0 || choice >= currentTotalSongs) {
			System.out.println("\nInvalid index");
			System.out.println("Please enter a number between 0 and " + (currentTotalSongs - 1));
			choice = input.nextInt();
		}
		
		Song song = musicLibrary.get(choice);
		System.out.println("Now playing: " + song.songID() + "\"" + song.getTitle() + "\" by " + song.getArtist() + song.convertSecondsToFormat());
	}
	
	//Adds song to Up-Next
	public void addSongToQueue () {
        Scanner input = new Scanner(System.in);
		
        System.out.println("\nEnter song number to add to Up-Next List (queue): ");
		int choice = input.nextInt();
		
		while (choice < 0 || choice >= currentTotalSongs) {
			System.out.println("Invalid index. Nothing enqueued");
			System.out.println("Please enter a number between 0 and " + (currentTotalSongs - 1));
			choice = input.nextInt();
		}
		
		Song chosenSong = musicLibrary.get(choice);
		upNextQueue.addLast(chosenSong);
		System.out.println("Song added to Up-Next");
		
		//Unit Test to confirm chosen song is queued
		//System.out.println(chosenSong);
	}
	
	//Displays queued song to be next
	public void ShowUpNextQueue() {
		upNextQueue.displayAll();
	}
	
	//Plays Up-Next songs from queue
	public void PlayNextFromQueue() {
		if(upNextQueue != null) {
			musicLibrary.removeFirst();
			System.out.println("Now playing: " + musicLibrary.getFirst());
		} else {
			System.out.println("Queue is empty.");
		}
	}
	
	public void playSongById(String searchId) {
		Map<String, Song> songMapById = new HashMap<>();
	
		for (Song currentSongId : musicLibrary) {
			songMapById.put(currentSongId.songID(), currentSongId);
		}
		
		if (songMapById.containsKey(searchId))
        {
        	System.out.println("Now playing: " + songMapById.get(searchId));
        } else
        {
        	System.out.println("ID not found.");
        }
	}
	
	public void displaySongsByArtist(String searchArtist) {
		Map<String, Song> songMapByArtist = new HashMap<>();
		
		for (Song currentSong : musicLibrary) {
			songMapByArtist.put(currentSong.getArtist(), currentSong);
		}
		
		if (songMapByArtist.containsKey(searchArtist)) {
			System.out.println(songMapByArtist.get(searchArtist));
	  }
    }
	
	//Display song's title by A-Z 
	public void displayPlaylistSortedByTitle() {
		LinkedList<Song> songInventory = new LinkedList<>();
		
		songInventory.addAll(musicLibrary);
		
		/** Prints original playlist
		for (Song currentSong : musicLibrary) {
			System.out.println(currentSong);
		}
		System.out.println();
		*/
		
		List<Song> songs = new ArrayList<>(songInventory);
		
		songs.sort(Comparator.comparing(Song::getTitle));
		for (Song currentSong : songs)
		{
			System.out.println(currentSong);
		}

		System.out.println();	
	}
	
	public void displayPlaylistSortedByDuration() {
		LinkedList<Song> durationInventory = new LinkedList<>();
		
		durationInventory.addAll(musicLibrary);
		
		List<Song> songs = new ArrayList<>(durationInventory);
		
		//songs.sort(Comparator.comparingInt(Song::getYear).reversed());
		songs.sort(Comparator.comparingInt(Song::getSongLength).reversed());
		for (Song currentSong : songs)
		{
			System.out.println(currentSong);
		}

		System.out.println();	
	}
}//End Playlist class

//Reads CSV file
class PlaylistLoader {
	
	public static ArrayList<Song> loadSongsFromCsv(String filename) {
	
		ArrayList<Song> songs = new ArrayList<>();
		
		try (Scanner fileScan = new Scanner(new File(filename))){
		int lineNumber = 0;
		int numOfSongsLoaded = 0;
		
		while (fileScan.hasNextLine()){
			String line = fileScan.nextLine();
			lineNumber++;
			
			try {
			String[] parts = line.split(",");
			
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
			
			
			//Unit test to see if songs info loads in console
			//System.out.println(song.toString());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Line " + lineNumber + " skipped: invalid values.");
		}
		}
		
		//Outside of while loop to prevent repetition of this line and only prints once after iteration
		System.out.println("Loaded " + numOfSongsLoaded + " songs");
		
		//User enters wrong file name
		} catch(FileNotFoundException e) {
        System.out.println("Could not open file: " + filename);
        System.out.println("No songs were loaded.");
	}
	return songs;
  }
}//End PlaylistLoader

class SinglyLinkedList<S> {
	
	private Node<S> head;
	private Node<S> tail;
    private int count;
	
    //Construct an empty list 
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
	 * Checks if linkedlist is empty
	 * @returns true if there are no nodes in the list
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	//Adds a value after tail(last node)
	public void addLast(S value) {
		Node<S> newNode = new Node<>(value);
		
		if(isEmpty()) {
			tail = newNode;
			head = newNode;
		} else {
		tail.next = newNode;
		}
		count++;
	}
	
	public S removeFirst() {	
		
		if(isEmpty()) {
			return null;
		}
		
		S value = head.value; // capture the value to return 
		head = head.next; //move head forward one node
		count--;
		
		if(head == null) {
			
			//If last node is removed, both head and tail must be null
			tail = null;
		}
		return value;
	}
	
	public void displayAll() {
		 if (isEmpty()) {
	            System.out.println("Queue is empty.");
	            return;
	        }

	        Node<S> current = head;
	        int index = 0;
	        while (current != null) {
	            System.out.println("[" + index + "] " + current.value);
	            current = current.next; //Move to next node
	            index++;
	        }
	}
	
	private static class Node<S> {
	
        S value;
		Node<S> next;
		Node(S v) {
			value = v;
			next = null;
		}
	}// End Node<S>
}//End LinkedList 