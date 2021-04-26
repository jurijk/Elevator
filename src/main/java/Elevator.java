import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Elevator {

    public static final int capacity = 5;

    List<Passenger> cabin = new ArrayList<>();
    int finalDestination = Main.numberOfFloor-1;
    int currentDestination = 0;
    boolean isRising = true;
    int currentFloor = 0;
    int freeSpace = 5;
    PassengerComparatorRising pasCompRis = new PassengerComparatorRising();
    PassengerComparatorDescending pasCompDesc = new PassengerComparatorDescending();

    @Override
    public String toString() {
        System.out.println("______________");
        System.out.println("______" + (currentFloor < 10 ? "0" + currentFloor : currentFloor) + "______");
        System.out.print("| ");

        int i = 0;
        for (Passenger pl:cabin) {
            System.out.print(pl.getNextFloor()+",");
            i++;
        }
        if (i<5){
            for (int j = i; i<5; i++){
                System.out.print("  ");
            }
        }
        System.out.println("| ");
        System.out.println("| To" + (isRising ? "   Up  " : "  Down ") + "  |");
        System.out.println("| To F " + (currentDestination < 10 ? "0" + currentDestination : currentDestination) + "    |");
        System.out.println("______________");
        return "\n";
    }

    void stop(List<Passenger> passengerListFromFloor){
        if(cabin!=null) {
            for (ListIterator<Passenger> listIterator = cabin.listIterator(); listIterator.hasNext();){
                Passenger passenger = listIterator.next();
                if (passenger.getNextFloor() == currentFloor) {
                    listIterator.remove();
                    int nextFloorPas = (int) (Math.random() * Main.numberOfFloor);
                    while(nextFloorPas == currentFloor){
                        nextFloorPas = (int) (Math.random() * Main.numberOfFloor);
                    }
                    passengerListFromFloor.add(new Passenger(currentFloor, nextFloorPas));
                }
            }
        }
        freeSpace = 5 - cabin.size();

        if (passengerListFromFloor != null) {
            for (ListIterator<Passenger> listIterator = passengerListFromFloor.listIterator(); listIterator.hasNext();){
                Passenger passenger = listIterator.next();
                if (isRising){//Едем вверх
                    if (passenger.getNextFloor() > currentFloor && cabin.size() < capacity){
                        cabin.add(passenger);//добавили пасажира в кабину
                        listIterator.remove();//удалили пасажира с этажа
                    }
                }
                else {
                    if (passenger.getNextFloor() < currentFloor && cabin.size() < capacity){
                        cabin.add(passenger);//добавили пасажира в кабину
                        listIterator.remove();//удалили пасажира с этажа
                    }
                }
            }
        }
        freeSpace = 5 - cabin.size();

    }

    void route(Floor[] house){
        if (isRising) {
            if (freeSpace == 0) {
                cabin.sort(pasCompRis);
                currentDestination = cabin.get(0).getNextFloor();//ближайший этаж назначения
                finalDestination = cabin.get(cabin.size() - 1).getNextFloor();//последний этаж в маршруте
                if(currentDestination == Main.numberOfFloor - 1){
                    isRising = !isRising;
                }
            } else if (freeSpace < 5){
                boolean flag = false;
                cabin.sort(pasCompRis);
                currentDestination = cabin.get(0).getNextFloor();//ближайший этаж назначения если кабина не пустая
                finalDestination = cabin.get(cabin.size() - 1).getNextFloor();//последний этаж в маршруте если кабина не пустая
                for (int i = currentFloor + 1; i < currentDestination && currentFloor!=Main.numberOfFloor - 1; i++){
                    house[i].button();
                    if(house[i].isUp()) {
                        currentDestination = i; //определили ближайший этаж назначения при
                        flag = false;           // свободном месте в лифте и движении вверх
                        break;
                    } else if(i == Main.numberOfFloor - 1){
                        currentDestination = i;
                        flag = true;
                    }
                }
                if (flag){
                    isRising = !isRising;
                }
            }
            else{
                currentDestination = Main.numberOfFloor-1;
                finalDestination = Main.numberOfFloor-1;
                boolean flag = true;
                for (int i = currentFloor + 1; i < currentDestination && currentFloor!=Main.numberOfFloor - 1; i++){
                    house[i].button();
                    if(house[i].isUp()) {
                        currentDestination = i; //определили ближайший этаж назначения при
                        flag = false;           // свободном месте в лифте и движении вверх
                        break;
                    } else if(house[i].isDown() || i == Main.numberOfFloor - 1){
                        currentDestination = i;
                        flag = true;
                    }
                }
                if (flag){
                    isRising = !isRising;
                }
            }
        }
        else {
            if (freeSpace == 0) {
                cabin.sort(pasCompDesc);
                currentDestination = cabin.get(0).getNextFloor();//ближайший этаж назначения
                finalDestination = cabin.get(cabin.size() - 1).getNextFloor();//последний этаж в маршруте
                if(currentDestination == 0){
                    isRising = !isRising;
                }
            } else if (freeSpace < 5){
                boolean flag = false;
                cabin.sort(pasCompDesc);
                currentDestination = cabin.get(0).getNextFloor();//ближайший этаж назначения если кабина не пустая
                finalDestination = cabin.get(cabin.size() - 1).getNextFloor();//последний этаж в маршруте если кабина не пустая
                for (int i = currentFloor - 1; i > currentDestination && currentFloor!=0; i--){
                    house[i].button();
                    if(house[i].isDown()) {
                        currentDestination = i;//определили ближайший этаж назначения при
                        flag = false;           // свободном месте в лифте и движении вверх
                        break;
                    }
                    else if(i == 0){
                        currentDestination = i;
                        flag = true;
                    }
                }
                if (flag){
                    isRising = !isRising;
                }
            } else{
                currentDestination = 0;
                finalDestination = 0;
                boolean flag = true;
                for (int i = currentFloor - 1; i > currentDestination && currentFloor!=0; i--){
                    house[i].button();
                    if(house[i].isDown()) {
                        currentDestination = i;//определили ближайший этаж назначения при
                        flag = false;          // свободном месте в лифте и движении вверх
                        break;
                    }
                    else if(house[i].isUp() || i == 0){
                        currentDestination = i;
                        flag = true;
                    }
                }
                if (flag){
                    isRising = !isRising;
                }
            }
        }
    }

    int move(){
        currentFloor = currentDestination;
        return currentFloor;
    }

}
