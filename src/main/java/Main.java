import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int numberOfFloor = 12;
    public static final int maxPassengerPerFloor = 5;

    public static void main(String[] args){

        Floor[] house = new Floor[numberOfFloor];
        Elevator elevator = new Elevator();

        for (int i = 0; i < numberOfFloor; i++) {
            int numberOfPassengersOnFloor = (int) (Math.random() * (maxPassengerPerFloor + 1));
            List<Passenger> floorList = new ArrayList<>();
            System.out.println("количество пассажиров на этаже " + (i+1) + " равно " + numberOfPassengersOnFloor);
            for (int j=0; j < numberOfPassengersOnFloor; j++)
            {
                int nextFloor = (int) (Math.random() * numberOfFloor);
                if(nextFloor == i) j--;
                else floorList.add(new Passenger(i, nextFloor));
            }
            Floor floor = new Floor(i, floorList);
            house[i] = floor;
        }

        for (int i=0; i < numberOfFloor; i++){
            System.out.println("Текущий этаж  " + (house[i].getNumOfFloor()/*+1*/));
            for (Passenger pl : house[i].getPassengersOnFloor()){
                System.out.println(pl.toString());
            }
        }
        int mover = 0;
        int counter = 0;
        Scanner myScanner = new Scanner(System.in);

        while (true){
            elevator.stop(house[mover].getPassengersOnFloor());
            elevator.route(house);
            System.out.println(elevator.toString());
            mover = elevator.move();
            String tempp = myScanner.next();
            if (tempp.equals("0")) break;
            System.out.println();
            counter++;
        }
        myScanner.close();
    }
}
