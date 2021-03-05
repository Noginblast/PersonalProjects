//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


public class Publication implements Comparable<Publication>{
	protected String title;
	protected String genre;
	protected int edition;
	protected int year;
	
	//Constructor
	public Publication(String title, String genre, int edition, int year) {
		this.title = title;
		this.genre = genre;
		this.edition = edition;
		this.year = year;
	}

	//Method to print book info
	public void printInfo() {
		System.out.println(title + ". Edition (" + edition + ") published in " + year);
		printFooter();
	}
	
	//Method to add Footer
	protected void printFooter() {
		System.out.println("All rights reserved!");
		System.out.println("--------------------");
	}
	
	//Method for comparison
	public int compareTo(Publication other) {
		if (genre.compareTo(other.genre) != 0) {
			return genre.compareTo(other.genre);
		}
		else {
			return title.compareTo(other.title);
		}
	}
	
	
	
}
