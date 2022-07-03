package FMS.provided;

/**
 * An airline staff member in the flight management system (FMS).<br>
 * 
 * In addition to person details, each airline staff member has a specific role,
 * including, but not limited to, pilot, stewardess, chef de cabin.<br>
 * 
 * @author TeM
 * @ProgrammingProblem.Hint provided
 * 
 */
public class Staff extends Person {

	private String role;

	/**
	 * Constructs a member of airline staff as a (deep) copy of an existing original
	 * airline staff member.<br>
	 * 
	 * @param staff
	 *            the original staff member to be copied
	 * @see Person#Person(Person)
	 */
	public Staff(Staff staff) {
		super(staff);
		this.role = staff.role;
	}

	/**
	 * Constructs an airline staff member with first and a last name and a passport
	 * ID.<br>
	 * 
	 * @param firstname
	 *            the first name of this staff member
	 * @param lastname
	 *            the last name of this staff member
	 * @param passportID
	 *            the passport number
	 * @param role
	 *            the role of this staff member
	 * @see Person#Person(String, String, String)
	 */
	public Staff(String firstname, String lastname, String passportID, String role) {
		super(firstname, lastname, passportID);
		this.role = new String(role);
	}

	/**
	 * Constructs an airline staff member with person data and a role. The person
	 * details are deep copied.<br>
	 * 
	 * @param p
	 *            the person object containing the personal data for this staff
	 *            member
	 * @param role
	 *            the role of this staff member
	 */
	public Staff(Person p, String role) {
		super(p);
		this.role = new String(role);
	}

	/**
	 * creates a string representation of this staff member.<br>
	 * 
	 * Adds the role to the personal data.<br>
	 * 
	 * Example:<br>
	 * 
	 * Pilot DOE John (AT00004711)<br>
	 * 
	 * @see Person#toString()
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s %s", role, super.toString());
	}

}
