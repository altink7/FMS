package FMS.provided;

/**
 * An aircraft in the flight management system (FMS).
 * 
 * Skeleton implementation, no argument checking whatsoever.
 * 
 * @author TeM
 * @ProgrammingProblem.Hint provided
 */
public class Aircraft {
	private String type;
	private int capacity;

	/**
	 * Creates an aircraft of a specified type and capacity.
	 * 
	 * @param type
	 *            the type to set
	 * @param capacity
	 *            the capacity to set
	 */
	public Aircraft(String type, int capacity) {
		this.type = new String(type);
		this.capacity = capacity;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param a
	 *            the aircraft to copy.
	 */
	public Aircraft(Aircraft a) {
		type = new String(a.type);
		capacity = a.capacity;
	}

	/**
	 * Gets the capacity.
	 * 
	 * @return the capacity of this aircraft
	 */

	public int getCapactiy() {
		return capacity;
	}

	public String toString() {
		return String.format("%s %d", type, capacity);
	}
}
