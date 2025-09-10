public class LibraryAppTest {

	public static void main(String[] args) {

	
		
	}//End main
	
class Book {
	
	//Instance variables
	private String author;
	private String title;
	private int year;
	
	//Constructor
	public Book (String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}
	
	//Methods
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String stringOfBookDetails() {
		return author + title + year;
	}
}//End Book class
	
class Library {
	
	private String name;
	private Book[][] bookShelf;
	private int numberOfShelves;
	private int shelfCapacity;
	private int currentShelf;
	private int currentSlot;
	private boolean isFull;
	
	public Library(String name, int numberOfShelves, int shelfCapacity) {
		this.name = name;
		this.numberOfShelves = numberOfShelves;
		this.shelfCapacity = shelfCapacity;
		
		//Initializing 2D Array 
		bookShelf = new Book [shelfCapacity][numberOfShelves];
		
		//Fills bookShelf's rows and columns
		for(int row = 0; row < shelfCapacity; row++) {
			for(int col = 0; col < numberOfShelves; col++) {			
				bookShelf[row][col] = (row + 1) * (col + 1);
			}
		}
			
	}//End Library
	
	public String getName() {
		return name;
	}
	
	public boolean addBook(Book book) {
		if (book == null) {
			System.out.println("No Book");
			return false;
		}
		
		if (isFull) {
			System.out.println("Library is full, can't add " + book.stringOfBookDetails());
			return false;
		}
		
		for (int i = 0; i < shelfCapacity; i++) {
			if (shelfCapacity > shelfCapacity) {
				System.out.println(isFull);
			}
					
		}
	}
	
	public void printALlBooks() {
		for (int slot = 0; slot < bookShelf; slot++) {
			
				Book bookShelf = shelfCapacity[slot];
				
				System.out.println(bookShelf.getAuthor());
				System.out.println(bookShelf.getTitle());
				System.out.println(bookShelf.getYear());
			}
		}
	
	public void oldestBook() {
		int oldestYear = bookShelf[0].getYear();
		int oldestBook = 0;
		
		for (int i = 1; i < shelfCapacity; i++) {
			if (bookShelf.getYear() > oldestYear) {
				oldestYear = bookShelf[i].getYear();
				oldestBook = i;
			}
		}
	}
	
	public int countPerShelf() {
		for(int row = 0; row < shelf.length; row++) {
			int sum = 0;
		}
		
		for (int col 0; col < shelfCapacity[row].length; col++) {
			sum += shelfCapacity[row][col];
		}
	}
	
	
	
}//End Library class



}//End Class
