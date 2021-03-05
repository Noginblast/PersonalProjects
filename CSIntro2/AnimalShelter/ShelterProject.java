//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


import java.io.FileNotFoundException;

public class ShelterProject {

	public static void main(String[] args) throws FileNotFoundException{
		Shelter BRShelter = new Shelter("Baton Rouge General");
		BRShelter.loadAnimals();
		BRShelter.listAnimals();

	}

}
