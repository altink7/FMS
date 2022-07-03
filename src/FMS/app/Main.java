package FMS.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import FMS.entities.*;
import FMS.provided.*;
import FMS.util.*;


public class Main {

	static List<Flight> flights;

	/**
	 * Demo application.
	 * 
	 * <ul>
	 * <li>creates demo flights using {@link //init}</li>
	 * <li>prints them using {@link //print}</li>
	 * <li>sorts them by flight id</li>
	 * <li>prints them again</li>
	 * <li>filters flights, keeping those originating from Vienna (VIE)</li>
	 * <li>sorts the filtered flights from Vienna by departure date and time</li>
	 * <li>prints them</li>
	 * <li>exports the sorted flights departing from Vienna to file
	 * departures_VIE.txt and displays the number of flights exported
	 * </ul>
	 * 
	 * @param args
	 *            command line arguments (not used)
	 */
	public static void main(String[] args) {
		List<Flight> demo = init();
		print(demo);
		Collections.sort(demo);
		print(demo);
		demo= filter(demo,new OriginMatcher("VIE"));
		print(demo);
		demo.sort(new DepartureComparator());
		print(demo);
		export(demo," departures_VIE.txt");
	}

	/**
	 * Prints all flights.
	 * 
	 * @param flights
	 *            the flights to print
	 * @ProgrammingProblem.Hint provided
	 */
	private static int export(Collection<Flight> flights, String filename){
		int n=0;

		try(BufferedWriter w= new BufferedWriter(new FileWriter(filename))){
			for(Flight f:flights){
				w.write(f.toString());
				w.newLine();
				n++;
			}
		}catch(IOException e1){
			e1.printStackTrace();
		}

		return n;
	}
	private static <T> List<T> filter(Collection<T> list, Matcher<T> match){
		List<T> filtered=new LinkedList<T>();

		for(T t:list){
			if(match.match(t)){
				filtered.add(t);
			}
		}
		return filtered;
	}

	private static void print(List<Flight> flights) {
		System.out.println("--- Listing Flights");
		for (Flight f : flights)
			System.out.println(f + "\n");
		System.out.printf("--- %d flights listed\n\n", flights.size());

	}

	/**
	 * creates some demo data (provided)
	 * 
	 * @return the demo data.
	 */
	private static List<Flight> init() {

		// ---------------- aircrafts
		List<Aircraft> crafts = new LinkedList<>();
		crafts.add(new Aircraft("A3", 3));
		crafts.add(new Aircraft("C4", 4));
		crafts.add(new Aircraft("Boeing 737", 175));

		// ---------------- passengers
		List<Passenger> passengers = new LinkedList<>();
		passengers.add(new Passenger("John", "Doe", "AT00004711"));
		passengers.add(new Passenger("Jane", "Doe", "AT00000815"));
		passengers.add(new Passenger("John", "Jackson", "US00004711"));
		passengers.add(new Passenger("Jack", "Doe", "UK00000007"));
		passengers.add(new Passenger("Jack", "Johnson", "DE00004711"));

		// ---------------- staff
		List<Staff> staff = new LinkedList<>();
		staff.add(new Staff("Rip", "Riley", "ISIS666", "Pilot"));
		staff.add(new Staff("Cheryl", "Tunt", "ISIS456", "Chef de Cabin"));
		staff.add(new Staff("Lana", "Kane", "ISIS001", "Stewardess"));

		// ---------------- flights
		List<Flight> flights = new LinkedList<>();
		flights.add(new ScheduledFlight("OS006", "FRA", "VIE", new DateTime(2018, 06, 25, 6, 30),
				new DateTime(2018, 06, 25, 8, 55), 800));
		flights.add(new Charter("OS001", "VIE", "VIE", new DateTime(2018, 06, 23, 6, 30),
				new DateTime(2018, 06, 23, 8, 55)));
		flights.add(new Charter("OS381", "ARN", "VIE", new DateTime(2018, 05, 25, 6, 30),
				new DateTime(2018, 05, 25, 9, 13)));
		flights.add(new Charter("OS001", "VIE", "JFK", new DateTime(2018, 07, 25, 4, 30),
				new DateTime(2018, 07, 25, 7, 20)));
		flights.add(new Charter("OS502", "JFK", "VIE", new DateTime(2018, 06, 28, 18, 30),
				new DateTime(2018, 06, 28, 19, 55)));
		flights.add(new ScheduledFlight("OS007", "VIE", "CDG", new DateTime(2018, 06, 28, 21, 00),
				new DateTime(2018, 06, 29, 0, 05), 1000));
		flights.add(new ScheduledFlight("OS008", "VIE", "CDG", new DateTime(2018, 06, 1, 6, 30),
				new DateTime(2018, 06, 1, 8, 05), 1000));

		
		Flight f;
		
		// ---------------- set up flight
		f = flights.get(0).setVessel(crafts.get(0));
		f.add(staff.get(0));
		f.add(staff.get(1));
		f.add(staff.get(2));
		// list passengers
		f.add(passengers.get(0));
		f.add(passengers.get(1));
		f.add(passengers.get(2));
		f.add(passengers.get(3)); //exceeds vessel capacity
		// board passengers
		f.board(passengers.get(0)); // board listed passengers
		f.board(passengers.get(1)); 
		f.board(passengers.get(2)); 
		f.board(passengers.get(3)); // board a passenger not listed

		
		// ---------------- set up flight
		f = flights.get(1).setVessel(crafts.get(1));
		f.add(passengers.get(1));
		f.add(passengers.get(2));
		f.add(passengers.get(3));
		f.add(new Staff(passengers.get(0), "Pilot"));  //a passenger becomes a pilot
		f.board(passengers.get(1)); // already on board another flight
		f.board(passengers.get(3)); // board a passenger

		
		
		// ---------------- set up flight
		f = flights.get(2).setVessel(crafts.get(2));
		Passenger p = new Passenger(staff.get(0)); //staff becomes a passenger
		f.add(passengers.get(2));
		f.add(passengers.get(1));
		f.add(passengers.get(3));
		f.add(p);
		f.board(p);	//no boarding without crew

	
		// ---------------- set up flight
		f = flights.get(3);
		f.add(passengers.get(2));
		f.add(passengers.get(1));
		f.add(passengers.get(3));
		
		
		// ---------------- set up flight
		f = flights.get(4);
		f.add(passengers.get(2));
		f.add(passengers.get(1));
		f.add(passengers.get(3));
		
		// ---------------- set up flight
		f = flights.get(5);
		f.add(passengers.get(2));
		f.add(passengers.get(1));
		f.add(passengers.get(3));

		return flights;
	}
	


}
