/**
 * 
 */

/**
 * 
 */
public class LibraryAppTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}//End main
	
class Book{
	
	//Instance variables
	private String author;
	private String title;
	private int year;
	
	//Constructor
	public Book (String auhtor, String title, int year) {
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
	
	

}//End Book class

}
