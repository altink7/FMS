package FMS.util;

import FMS.entities.Flight;
import java.util.Comparator;

public class DepartureComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getDeparture().compareTo(o2.getDeparture());
    }
}
