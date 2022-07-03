package FMS.entities;

import FMS.provided.DateTime;
import FMS.provided.Passenger;

public class Charter extends Flight{

    public Charter(String flightID, String destination, String origin, DateTime departure, DateTime arrival) {
        super(flightID, destination, origin, departure, arrival);
    }

    @Override
    public int getBonusMiles() {
        return passengers.size()*350;
    }

    @Override
    public int compareTo(Flight o) {
        return this.flightID.compareTo(o.flightID);
    }
}
