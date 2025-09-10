public class LibraryAppTest {

	public static void main(String[] args) {

		// --- unit test checks for Book ---
		System.out.println("Unit Test Book Class");
		Book unitTestBook = new Book("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getTitle());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.stringOfBookDetails());
		System.out.println();
		System.out.println("Setting up Test Library");
		int numberOfShelves = 3;
		int shelfCapacity = 4;
		System.out.println("Shelves (rows): " + numberOfShelves);
		System.out.println("Slots per shelf (columns): " + shelfCapacity);
		System.out.println("Total capacity: " + (numberOfShelves * shelfCapacity));
		System.out.println();
		Library library = new Library("Test Library", numberOfShelves, shelfCapacity);
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 0
		library.addBook(null);
		library.addBook(new Book("Unmasking AI", "Joy Buolamwini", 2023));
		library.addBook(new Book("Hello World", "Hannah Fry", 2018));
		library.addBook(new Book("Race After Technology", "Ruha Benjamin", 2019));
		library.addBook(new Book("Deep Learning", "Ian Goodfellow", 2016));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 1
		library.addBook(new Book("Algorithms to Live By", "Brian Christian", 2016));
		library.addBook(new Book("Weapons of Math Destruction", "Cathy O'Neil", 2016));
		library.addBook(new Book("The Mythical Man-Month", "Fred Brooks", 1975));
		library.addBook(new Book("Refactoring", "Martin Fowler", 1999));
		// Row 2
		library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999));
		library.addBook(new Book("Peopleware", "Tom DeMarco & Tim Lister", 1987));
		library.addBook(new Book("Computer Lib / Dream Machines", "Ted Nelson", 1975));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		System.out.println("Test add more books than capacity...");
		library.addBook(new Book("Extra Title", "Extra Author", 2024)); // should trigger "full" message
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		
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
		
		//Return false if book is null
		if (book == null) {
			System.out.println("No Book");
			return false;
		}
		
		//Can't add certain book if library is full
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
		
		//For each slot it would display book details
		for (int slot = 0; slot < bookShelf; slot++) {
			
				Book bookShelf = shelfCapacity[slot];
				
				System.out.println(bookShelf.getAuthor());
				System.out.println(bookShelf.getTitle());
				System.out.println(bookShelf.getYear());
			}
		}
	
	public void oldestBook() {
		
		//get details of book and lowest year will be declared
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
