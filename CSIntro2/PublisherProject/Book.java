//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


public class Book extends Publication{
	protected String author;
	
	public Book(String author, String title, String genre, int edition, int year) {
		super(title, genre, edition, year);
		this.author = author;
	}
	
	@Override
	public void printInfo() {
		System.out.println(title + ". Edition (" + edition + ") published in " + year);
		System.out.println(genre + " book by " + author + ".");
		printFooter();
	}
	
	
}
