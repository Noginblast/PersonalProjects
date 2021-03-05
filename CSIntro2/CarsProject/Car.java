//Student Name: Cade M Forbes
//Submission Time: 5:48PM

public class Car {
	//Declaring Instance Variables
	private long vin;
	private String model;
	private int year;
	private double mileage;

	//Setting Constructor
	public Car(long vinIn, int yearIn, String modelIn) {
	vin = vinIn;
	year = yearIn;
	model = modelIn;
	}
	
	//Method for setting mileage
	public void setMileage(double mileageIn) {
		mileage = mileageIn;
	}
	
	//Method for returning car info in String format
	public String getInfo() {
		return String.format("%d %s (VIN: %d, Mileage: %.1f mile)", year, model, vin, mileage);
	}
}
