import java.util.Scanner;
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
		PlaylistLoader.loadSongsFromCsv(fileName);
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
	private Song[] musicLibrary;
	private int playlistCapacity;
	private int currentSongsInPlaylist;
	private int currentTotalSongs;
	private boolean isFull;
	
	public Playlist(String name, int playlistCapacity) {
		this.name = name;
		this.playlistCapacity = playlistCapacity;
		this.currentTotalSongs = 0;
		
		//Initialize Array
		musicLibrary = new Song [playlistCapacity];
		
		for(int col = 0; col < playlistCapacity; col++) {
			musicLibrary[col] = null;
		}
	}
	
	
	
}//End Playlist class

class PlaylistLoader {
	
	public static void loadSongsFromCsv(String filename) {
	try (Scanner fileScan = new Scanner(new File(filename))){
		int lineNumber = 0;
		while (fileScan.hasNextLine()){
			String line = fileScan.nextLine();
			lineNumber++;
			
			String[] parts = line.split(",");
			if(parts.length != 3) {
				System.out.println("Line " + lineNumber + "skipped: " + "invalid values");
			}
			
			String title = parts[0].trim();
			String artist = parts[1].trim();
			String durationText = parts[2].trim();
			
			int durationSeconds;
			try {
				durationSeconds = Integer.parseInt(durationText);
			} catch (NumberFormatException ex) {
			     System.out.println("Line " + lineNumber + ": invalid year \"" + durationText + "\" → skipping line.");
			     
		}

		}
			
		} catch(FileNotFoundException e) {
        System.out.println("Could not open file: " + filename);
        System.out.println("No songs were loaded.");
	}
  }
}//End PlaylistLoader