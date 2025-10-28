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
		System.out.println("Enter CSV filename: ");
		String fileName = input.next();
		
		ArrayList<Song> songs = PlaylistLoader.loadSongsFromCsv(fileName);
		
		Playlist playlist = new Playlist("ow", 5); //Hard code unit test
		for(Song song : songs) {
			playlist.addSongs(song);
		}
		playlist.displayPlaylist();
		
		System.out.println("\nEnter your choice (1–7): ");
		int choice = input.nextInt();
		playlist.playCertainSong();
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
	
	
	//returns a string that describes the Song object
	@Override // Overrides Playlist Class method to it's own version(behavior)
	public String toString() {
		
		//Prints artist, title, songLength together as a string
		return artist + ", "+ title + ", " + songLength + " Seconds";
	}
	
}//End Song class

class Playlist {
	
	private String name;
	private ArrayList<Song> musicLibrary;
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
				System.out.println("[" + i + "] \"" + song.getTitle() + "\" by " + song.getArtist() + " (" + song.getSongLength() + ")");
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
			System.out.println("Invalid index");
			System.out.println("Please enter a number between 0 and 6");
			
		}

		Song song = musicLibrary.get(choice);
		System.out.println("Now playing: " + "\"" + song.getTitle() + "\" by " + song.getArtist() + " (" + song.getSongLength() + ")");
	}
	
	public void addSongToQueue () {
        Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter song number to add to Up-Next List (queue): ");
		int choice = input.nextInt();
		
		
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
			numOfSongsLoaded++;
			
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
			
			System.out.println(song.toString());
		}
		
		//Outside of while loop to prevent repetition of this line and only prints once after iteration
		System.out.println("Loaded " + numOfSongsLoaded + " songs\n");
		
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