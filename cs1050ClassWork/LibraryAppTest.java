import java.util.Scanner;

public class LibraryAppTest {

	public static void main(String[] args) {

		//Create s Scanner object for scanning input from keyboard
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year");
		//read integer from keyboard for year
		int year = input.nextInt();
		
		Book nullBook = null;
		System.out.println(nullBook.getTitle());
		
		// --- unit test checks for Book ---
		System.out.println("Unit Test Book Class");
		Book unitTestBook = new Book("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getTitle());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.toString());
		System.out.println();
		System.out.println("Setting up Test Library");
		int numberOfShelves = 3;
		int shelfCapacity = 4;
		
		
	}//End main
	
abstract class Book {
	
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
	
	@Override
	public String toString() {
		return author + title + year;
	}
	
	//Shared behavior using polymorphism
	/** Calculates the late fee based on subclass policy */
	public final double calculateLateFee(int daysLate) {
		double lateFee = 0;
		
		if (lateFee > 0) {
			lateFee = daysLate * getDailyLateFee();
		}
		return lateFee;	
	}
	
	public abstract int getLoanDays() {
		
	}
	
	public abstract double getDailyLateFee() {
		
	}
	
	
}//End Book class

class PrintBook extends Book {
	
	public Book(String title, String author, int year) {
		
	}
	
class EBook extends Book{
	
}
	
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
			System.out.println("Invalid Book");
			return false;
		}
		
		//Can't add certain book if library is full
		if (isFull) {
			System.out.println("Library is full, can't add " + book.stringOfBookDetails());
			return false;
		}
		
		bookShelf[currentShelf][currentSlot] = book;
		System.out.println("Added" + book.stringOfBookDetails() + "at shelf" + (currentShelf + 1) + "slot" + (currentSlot + 1));
		currentTotalBooks = currentTotalbooks + 1;
		
		if (currentTotalBooks >= totalBookCapacity) {
			isFull = true;
		} else {
			int nextIndex = currentTotalBooks;
			currentShelf = nextIndex / shelfCapacity;
			currentSlot = nextIndex % shelfCapacity;
		}
		return true;
		
		for (int i = 0; i < shelfCapacity; i++) {
			if (shelfCapacity > shelfCapacity) {
				System.out.println(isFull);
			}		
		}
	}
	
	public void printAllBooks() {
		
		System.out.println("All books in " + getName() + "\n");
		System.out.println("Shelf   Slot   Book Details");
		
		//For each slot it would display book details
		for (int shelfIndex = 0; shelfIndex < numberOfShelves; shelfIndex++) {
			
			//
			printListBooks(bookShelf[shelfIndex], shelfIndex + 1);
			
		}
		System.out.println("(" + currentTotalBooks + " of " + (numberOfShelves * shelfCapacity) + "slots filled)\n");

		}
	
	private void printListBooks(Book[]shelf, int shelfIndex) {
		
		for (int columnIndex = 0; columnIndex < shelf.length; columnIndex++) {
			Book currentBook = shelf[columnIndex];
			if (currentBook != null) {
				System.out.println(shelfIndex, columnIndex + 1, currentBook.stringOfBookDetails());
			}
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
	
	private Book[] convertOneDimension() {
		Book[] oneDimension = new Book[currentTotalBooks];
		int index = 0;
		
		for (int shelfIndex = 0; shelfIndex < numberOfShelves; shelfIndex++) {
			for (int slotIndex = 0; slotIndex < shelfCapacity; slotIndex++) {
				if ( bookShelf[shelfIndex][slotIndex] != null) {
					oneDimension[index] = bookShelf[shelfIndex][slotIndex];
					index = index + 1;
					if (index >= currentTotalBooks) {
						return oneDimension; //Once all books are copied, exit early
					}
				}
			}
		}
		return oneDimension;
	}
	
	public int countPerShelf() {
		int rows = currentTotalBooks / shelfCapacity;
		int remainder = currentTotalBooks % shelfCapacity;
		
		for(int rowIndex = 0; rowIndex < numberOfShelves; rowIndex++) {
			int thisShelf;
			
			if (rowIndex < rows) 
			{
				thisShelf = shelfCapacity;
			} else if (rowIndex == rows) 
			{
				thisShelf = remainder;
			} else
			{
				thisShelf = 0;
			}
			System.out.println("Shelf " + (rowIndex + 1) + " has " + booksOnThisShelf + " books");
		}
	}
	
}//End Library class
	
//Class Library Loader HERE
	
}

}//End Class
