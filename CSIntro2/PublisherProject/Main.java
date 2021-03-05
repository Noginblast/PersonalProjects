//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah

import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) {
		
		//Given code for Main method
		ArrayList<Publication> pubs = new ArrayList<Publication>();
		pubs.add(new Book("John Carreyrou", "Bad Blood: Secrets and Lies in a Silicon Valley Startup", "True crime", 1, 2018));
		pubs.add(new Book("Andriy Burkov", "The Hundred-Page Machine Learning Book",
		"Science", 1, 2019));

		pubs.add(new Magazine("Meredith Corporation", "Sports Illustrated", "Sports",
		633, 2020));
		pubs.add(new Magazine("Meredith Corporation", "People", "Entertainment", 466,
		2020));


		Collections.sort(pubs);

		for(Publication p : pubs)
		 p.printInfo();


	}

}
