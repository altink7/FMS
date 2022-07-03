package FMS.provided;

/**
 * A person in the flight management system (FMS).<br>
 * Skeleton implementation, no argument checking.
 * 
 * @author TeM
 * @ProgrammingProblem.Hint provided
 * 
 */
public class Person implements Comparable<Person> {
	private String passportID;
	private String firstname, lastname;

	/**
	 * Constructs a Person with first and a last name and a passport ID.
	 * 
	 * @param firstname
	 *            the first name of this person
	 * @param lastname
	 *            the last name of this person
	 * @param passportID
	 *            the passport number
	 */
	public Person(String firstname, String lastname, String passportID) {
		super();
		this.passportID = passportID;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * Constructs a person as a deep copy of an existing original person.
	 * 
	 * @param p
	 *            the original person to be copied.
	 */
	public Person(Person p) {
		this.passportID = new String(p.passportID);
		this.firstname = new String(p.firstname);
		this.lastname = new String(p.lastname);
	}

	/**
	 * creates a string representation of this person.<br>
	 * example: DOE John (AT00004711)
	 */
	@Override
	public String toString() {
		return String.format("%S %s (%s)", lastname, firstname, passportID);
	}

	/**
	 * compares this person to some other, implementing natural ordering by passport
	 * id.
	 * 
	 * @see Comparable
	 */
	@Override
	public int compareTo(Person o) {
		return passportID.compareTo(o.passportID);
	}

}
