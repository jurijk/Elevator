import java.util.Comparator;

public class PassengerComparatorRising implements Comparator<Passenger> {
    @Override
    public int compare(Passenger passenger1, Passenger passenger2) {
        if (passenger1.getNextFloor() == passenger2.getNextFloor()) {
            return 0;
        }
        if (passenger1.getNextFloor() > passenger2.getNextFloor()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
