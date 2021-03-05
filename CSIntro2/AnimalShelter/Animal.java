//Student Name: Cade M Forbes
//LSU ID: 898138828
//Lab Teaching Assistant Name: Augustine Orgah


public class Animal implements Comparable<Animal>{
	private String name;
	private String kind;
	private int age;
	
	//Constructor
	public Animal( String nameIn, String kindIn, int ageIn) {
		name = nameIn;
		kind = kindIn;
		age = ageIn;
	}
	
	//Method for comparisons
	public int compareTo(Animal other) {
		if (kind.compareTo(other.kind) != 0) {
			return kind.compareTo(other.kind);
		}
	       
	    else if  (Integer.compare(age,  other.age) != 0) {
	    	return Integer.compare(age, other.age);
	    }
	    else {
	    	return name.compareTo(other.name);
	    }
	}
	
	//Method to print info of animal
	public String getInfo() {
		if (age < 12) {
			return String.format("%s\t\t%s\t\t%d months", name, kind, age);
		}
		else {
			double ageYrs = (double)age/12;
			return String.format("%s\t\t%s\t\t%.1f Years", name, kind, ageYrs);
		}
	}

}
