package FMS.util;

import FMS.entities.Flight;
import FMS.provided.Matcher;

public class OriginMatcher implements Matcher<Flight> {
        private String origin;

    public OriginMatcher(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean match(Flight flight) {
        return origin.matches(flight.getOrigin());
    }
}
