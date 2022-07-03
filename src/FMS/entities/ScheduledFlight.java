package FMS.entities;

import FMS.provided.DateTime;

public class ScheduledFlight extends Flight{
    int distance;

    public ScheduledFlight(String flightID, String destination, String origin, DateTime departure, DateTime arrival, int distance) {
        super(flightID, destination, origin, departure, arrival);
        this.distance = distance;
    }

    public ScheduledFlight(ScheduledFlight other){
        super(other);
        this.distance = other.distance;
    }

    @Override
    public int getBonusMiles() {
        return distance%1000;
    }

    @Override
    public int compareTo(Flight o) {
        return this.flightID.compareTo(o.flightID);
    }
}
