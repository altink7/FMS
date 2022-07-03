package FMS.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import FMS.provided.Aircraft;
import FMS.provided.DateTime;
import FMS.provided.Passenger;
import FMS.provided.Staff;

/**
 * A flight in the flight management system (FMS).<br>
 * 
 * A flight stores information about place and time of departure and arrival as
 * well as the aircraft and personnel involved. Both crew and passengers can be
 * added to a flight. A flight is ready for boarding as soon as one crew member
 * is assigned (added to the flight). Passengers can be listed (added) and only
 * listed passengers can board the flight. Passengers can only board one flight
 * at a time.
 * 
 * 
 * Flights are naturally ordered by ID.
 * 
 *
 */
public abstract class Flight implements Comparable<Flight> {
	String flightID;
	String destination;
	String origin;
	DateTime departure;
	DateTime arrival;
	Aircraft vessel;
	Set<Staff> crew =new HashSet<>();
	Set<Passenger> passengers = new HashSet<>();

	public Flight(String flightID, String destination, String origin, DateTime departure, DateTime arrival) {
		this.flightID = flightID;
		this.destination = destination;
		this.origin = origin;
		this.departure = departure;
		this.arrival = arrival;
	}

	public Flight (Flight other){
		this.flightID = other.flightID;
		this.destination = other.destination;
		this.origin = other.origin;
		this.departure = new DateTime(other.departure);
		this.arrival = new DateTime(other.arrival);
		this.vessel = new Aircraft(other.vessel);
		this.crew = other.crew;
		this.passengers = other.passengers;
		}

	private final String ensureNonNullNonEmpty(String str) throws IllegalArgumentException{
		if(str != null &&! str.isEmpty()){
			return str;
		}
		throw new IllegalArgumentException();
	}


	public String getFlightId() {
		return flightID;
	}

	public void setFlightID(String flightID) throws IllegalArgumentException {
		this.flightID = ensureNonNullNonEmpty(flightID);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) throws IllegalArgumentException {
		this.destination = ensureNonNullNonEmpty(destination);
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) throws IllegalArgumentException {
		this.origin = ensureNonNullNonEmpty(origin);
	}

	public DateTime getDeparture() {
		return new DateTime(departure);
	}

	public void setDeparture(DateTime departure) {
		this.departure = new DateTime(departure);
	}

	public DateTime getArrival() {
		return arrival;
	}

	public void setArrival(DateTime arrival) {
		this.arrival = new DateTime(arrival);
	}

	public Aircraft getVessel() {
		return vessel;
	}

	public Flight setVessel(Aircraft vessel) {
		this.vessel = vessel;
		return this;
	}

	public abstract int getBonusMiles();

	public int CompareTo(Flight o){
		return this.flightID.compareTo(o.flightID);
	}

	public boolean add(Staff staff){
		if(crew.contains(staff)){
			return false;
		}else{
			crew.add(staff);
			return true;
		}
	}

	public boolean add(Passenger passenger){
		if(passengers.contains(passenger)){
			return false;
		}else{
			passengers.add(passenger);
			return true;
		}
	}

	public boolean readyToBoard(){
		return crew.size() > 0;
	}
	public boolean board(Passenger p){
		add(p);
		return true;
	}

	public boolean boardingCompleted(){
		return passengers.size() > 0;
	}

	@Override
	public String toString() {
		return String.format(
				"%5s from %3.3S (%s) to %3.3S (%s)" + " with a crew of %d and %d passengers "
						+ "<%s> boarding%scompleted \n%s\n%s",
				flightID, origin, departure, destination, arrival, 
				crew == null ? 0 : crew.size(),
				passengers == null ? 0 : passengers.size(),
				vessel == null ? "no vessel" : vessel.toString(),
				boardingCompleted() ? " " : " not ",
				crew,
				passengers);
	}

}
