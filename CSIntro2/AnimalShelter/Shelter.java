//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;



public class Shelter {
	private String shelterName;
	private ArrayList<Animal> animal;
	
	//Constructor
	public Shelter(String shelterNameIn) {
		shelterName = shelterNameIn;
		animal = new ArrayList<>();
	}
	
	//Method to load animal info from text file into objects
	public void loadAnimals() throws FileNotFoundException{
		File input = new File("animals.txt");
		Scanner in = new Scanner(input);
		
		while(in.hasNextLine()) {
			String[] fields = in.nextLine().split(";");
			animal.add(new Animal(fields[0].trim(),fields[1].trim(), Integer.parseInt(fields[2].trim())));
		}
	}
	
	//Method to list all animals loaded
	public void listAnimals() {
		Collections.sort(animal);
		
		System.out.println("Welcome to " + shelterName + "Shelter");
		System.out.println("==========================================");
		
		for (Animal a: animal) {
			System.out.println(a.getInfo());
		}
	}
}
