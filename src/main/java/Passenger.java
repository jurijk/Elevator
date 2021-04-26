public class Passenger {
    private int currentFloor = 0;
    private int nextFloor = 0;

    public Passenger(int currentFloor, int nextFloor) {
        this.currentFloor = currentFloor;
        this.nextFloor = nextFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "currentFloor=" + currentFloor +
                ", nextFloor=" + nextFloor +
                '}';
    }
}
