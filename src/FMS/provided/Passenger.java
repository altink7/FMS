package FMS.provided;

import FMS.entities.Flight;

/**
 * A passenger in the flight management system (FMS).<br>
 * 
 * In addition to personal details a passenger stores information which flight
 * he or she boarded, if any.
 * 
 * 
 * @author TeM
 * @ProgrammingProblem.Hint provided
 * 
 */
public class Passenger extends Person {

	/**
	 * the flight this passenger boarded. null if no flight is currently boarded.
	 */
	private Flight boarded;

	/**
	 * Constructs a passenger with first and a last name and a passport ID.<br>
	 * 
	 * @see Person#Person(String, String, String)
	 * @param firstname
	 *            the first name of this person
	 * @param lastname
	 *            the last name of this person
	 * @param passportID
	 *            the passport number
	 */
	public Passenger(String firstname, String lastname, String passportID) {
		super(firstname, lastname, passportID);

	}

	/**
	 * Copies a passenger.<br>
	 * 
	 * @see Person#Person(Person)
	 * @param p
	 *            the passenger to copy.
	 */
	public Passenger(Passenger p) {
		super(p);
		boarded = p.boarded;
	}

	/**
	 * Converts any person to a passenger.
	 * 
	 * @param p
	 *            the person to become a passenger.
	 */
	public Passenger(Person p) {
		super(p);
	}

	/**
	 * creates a string representation of this passenger.<br>
	 * 
	 * Adds the boarding information to the personal data.<br>
	 * <br>
	 * 
	 * Example boarded:<br>
	 * DOE John (AT00004711) [OS006]<br>
	 * <br>
	 * 
	 * Example not boarded:<br>
	 * DOE John (AT00004711) [ ]<br>
	 * <br>
	 * 
	 * @see Person#toString()
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s [%s]", super.toString(), boarded == null ? " " : boarded.getFlightId());
	}

	/**
	 * sets the boarded flight of this passenger.<br>
	 * 
	 * Does NOT create an internal copy.
	 * 
	 * @param flight
	 *            the flight to board
	 */
	public void setBoarded(Flight flight) {
		boarded = flight;

	}

	/**
	 * gets the flight this passenger boarded.
	 * 
	 * @return the flight
	 */
	public Flight getBoarded() {
		return boarded;
	}

}
