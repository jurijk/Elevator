import java.util.ArrayList;
import java.util.List;

public class Floor {
    public static final int capFloor = 10;

    public Floor(int numOfFloor, List<Passenger> passengersOnFloor) {
        this.numOfFloor = numOfFloor;
        this.passengersOnFloor = passengersOnFloor;
    }

    int numOfFloor;//номер этажа
    List<Passenger> passengersOnFloor = new ArrayList<>(capFloor);
    boolean up = false;
    boolean down = false;



    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public List<Passenger> getPassengersOnFloor() {
        return passengersOnFloor;
    }

    public void setPassengersOnFloor(List<Passenger> passengersOnFloor) {
        this.passengersOnFloor = passengersOnFloor;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    void button (){
        for (Passenger pl : passengersOnFloor){
            int nextFloor = pl.getNextFloor();
            if (nextFloor > numOfFloor) up = true;
            else if (nextFloor < numOfFloor) down = true;
            else {
                up = false;
                down = false;
            }
        }
    }
}
