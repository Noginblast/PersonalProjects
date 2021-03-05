//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


public class Magazine extends Publication{
	protected String publisher;
	
	public Magazine(String publisher, String title, String genre, int edition, int year) {
		super(title, genre, edition, year);
		this.publisher = publisher;
	}
	
	@Override
	public void printInfo() {
		System.out.println(title + ". Edition (" + edition + ") published in " + year);
		System.out.println(genre + " magazine by " + publisher + ".");
		printFooter();
	}
}
