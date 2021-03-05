import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Route {

	public static void main(String[] args) throws FileNotFoundException{
		File flights = new File("flights.txt");
		Scanner flight = new Scanner(flights);
		int flightAmnt = Integer.parseInt(flight.nextLine());
		flight.nextLine();
		
		File airps = new File("airports.txt");
		Scanner airpt = new Scanner(airps);
		int airptAmnt = Integer.parseInt(airpt.nextLine());
		
		HashTable ht = new HashTable();
		HashTable htHeapInd = new HashTable(); 
		
		
		for (int i = 0; i < flightAmnt; i++) {
			String[] srcDstDepArr = flight.nextLine().split("\\t");
			ht.put(srcDstDepArr[2], srcDstDepArr[3], Integer.parseInt(srcDstDepArr[4]), Integer.parseInt(srcDstDepArr[5]));
		}
		
		System.out.println(ht.getArr("MCI", "BNA", 1425));
		//System.out.println(srcDstDepArr[2]);

	}

}
