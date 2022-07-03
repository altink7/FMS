package FMS.provided;

/**
 * A UTC point in time. Skeleton implementation, no argument checking
 * whatsoever.
 * 
 * @ProgrammingProblem.Hint provided
 * 
 * @author TeM
 *
 */
public class DateTime implements Comparable<DateTime> {

	private int year, month, day, hour, min;

	/**
	 * copy constructor
	 * 
	 * @param o
	 *            the date and time to copy.
	 */
	public DateTime(DateTime o) {
		this.year = o.year;
		this.month = o.month;
		this.day = o.day;
		this.hour = o.hour;
		this.min = o.min;
	}

	/**
	 * Creates a UTC point in time (PIT).
	 * 
	 * @param year
	 *            the year of the PIT
	 * @param month
	 *            the month of the PIT.
	 * @param day
	 *            the day of the PIT.
	 * @param hour
	 *            the hour of the PIT
	 * @param min
	 *            the minute of the PIT.
	 */
	public DateTime(int year, int month, int day, int hour, int min) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}

	/**
	 * creates a string representation of this date and time.<br>
	 * formatting example: 2018-06-25 06:30 (UTC)
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d %02d:%02d (UTC)", year, month, day, hour, min);
	}

	/**
	 * compares this date and time to some other, implementing natural ordering.
	 * 
	 * @see Comparable
	 */
	@Override
	public int compareTo(DateTime o) {
		return Long.compare(timestamp(), o.timestamp());
	}

	/**
	 * creates a time stamp for this date and time.<br>
	 * example: the time stamp for 2018-06-25 06:30 (UTC) is 201806250630
	 * 
	 * @return the time stamp
	 */
	public long timestamp() {
		return ((((year * 100 + month) * 100 + day) * 100 + hour) * 100 + min);
	}

}
