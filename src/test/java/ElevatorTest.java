import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ElevatorTest {

//    @BeforeAll
//    public void beforeTest(){
//        List<Passenger> cabin = new ArrayList<>();
//        List<Passenger> passOnFloor = new ArrayList<>();
//        Passenger pas1 = new Passenger(1, 3);
//        Passenger pas2 = new Passenger(1, 3);
//        Passenger pas3 = new Passenger(1, 4);
//        Passenger pas4 = new Passenger(1, 4);
//        Passenger pas5 = new Passenger(3, 5);
//        Passenger pas6 = new Passenger(3, 5);
//        Passenger pas7 = new Passenger(3, 5);
//
//        cabin.add(pas1);
//        cabin.add(pas2);
//        cabin.add(pas3);
//        cabin.add(pas4);
//
//        passOnFloor.add(pas5);
//        passOnFloor.add(pas6);
//        passOnFloor.add(pas7);
//
//    }

    @Test
    public void test1(){
        List<Passenger> cabin = new ArrayList<>();
        List<Passenger> passOnFloor = new ArrayList<>();
        Passenger pas1 = new Passenger(1, 3);
        Passenger pas2 = new Passenger(1, 3);
        Passenger pas3 = new Passenger(1, 4);
        Passenger pas4 = new Passenger(1, 4);

        Passenger pas5 = new Passenger(3, 5);
        Passenger pas6 = new Passenger(3, 5);
        Passenger pas7 = new Passenger(3, 5);

        cabin.add(pas1);
        cabin.add(pas2);
        cabin.add(pas3);
        cabin.add(pas4);

        passOnFloor.add(pas5);
        passOnFloor.add(pas6);
        passOnFloor.add(pas7);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 1;
        elevator.finalDestination=4;
        elevator.currentDestination = 3;
        elevator.isRising = true;
        elevator.currentFloor = 3;
        System.out.println(elevator);
        elevator.stop(passOnFloor);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.freeSpace, 0);
    }

    @Test
    public void test2(){
        List<Passenger> cabin = new ArrayList<>();
        List<Passenger> passOnFloor = new ArrayList<>();
        Passenger pas1 = new Passenger(1, 3);
        Passenger pas2 = new Passenger(1, 3);
        Passenger pas3 = new Passenger(1, 4);
        Passenger pas4 = new Passenger(1, 4);

        Passenger pas5 = new Passenger(3, 5);
        Passenger pas6 = new Passenger(3, 5);
        Passenger pas7 = new Passenger(3, 5);
        Passenger pas8 = new Passenger(3, 5);

        cabin.add(pas1);
        cabin.add(pas2);
        cabin.add(pas3);
        cabin.add(pas4);

        passOnFloor.add(pas5);
        passOnFloor.add(pas6);
        passOnFloor.add(pas7);
        passOnFloor.add(pas8);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 1;
        elevator.finalDestination=4;
        elevator.currentDestination = 3;
        elevator.isRising = true;
        elevator.currentFloor = 3;
        System.out.println(elevator);
        elevator.stop(passOnFloor);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.freeSpace, 0);
    }

    @Test
    public void test3() {
        List<Passenger> cabin = new ArrayList<>();
        List<Passenger> passOnFloor = new ArrayList<>();
        Passenger pas1 = new Passenger(1, 11);
        Passenger pas2 = new Passenger(1, 11);
        Passenger pas3 = new Passenger(1, 11);
        Passenger pas4 = new Passenger(1, 11);

        /*Passenger pas5 = new Passenger(4, 5);
        Passenger pas6 = new Passenger(4, 5);
        Passenger pas7 = new Passenger(4, 5);
        Passenger pas8 = new Passenger(4, 5);*/

        cabin.add(pas1);
        cabin.add(pas2);
        cabin.add(pas3);
        cabin.add(pas4);

//        passOnFloor.add(pas5);
//        passOnFloor.add(pas6);
//        passOnFloor.add(pas7);
//        passOnFloor.add(pas8);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 1;
        elevator.finalDestination = 11;
        elevator.currentDestination = 11;
        elevator.isRising = true;
        elevator.currentFloor = 11;
        System.out.println(elevator);
        elevator.stop(passOnFloor);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.freeSpace, 5);
    }

    @Test
    public void test4(){
        List<Passenger> cabin = new ArrayList<>();
        List<Passenger> passOnFloor = new ArrayList<>();
        Passenger pas1 = new Passenger(1, 4);
        Passenger pas2 = new Passenger(1, 4);
        Passenger pas3 = new Passenger(1, 4);
        Passenger pas4 = new Passenger(1, 4);
//        Passenger pas4 = new Passenger(1, 4);

        Passenger pas5 = new Passenger(3, 5);
        Passenger pas6 = new Passenger(3, 5);
        Passenger pas7 = new Passenger(3, 5);
        Passenger pas8 = new Passenger(3, 5);

        cabin.add(pas1);
        cabin.add(pas2);
        cabin.add(pas3);
        cabin.add(pas4);

        passOnFloor.add(pas5);
        passOnFloor.add(pas6);
        passOnFloor.add(pas7);
        passOnFloor.add(pas8);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 1;
        elevator.finalDestination = 4;
        elevator.currentDestination = 3;
        elevator.isRising = true;
        elevator.currentFloor = 3;
        System.out.println(elevator);
        elevator.stop(passOnFloor);
        System.out.println(elevator);
        Assertions.assertEquals(passOnFloor.size(), 3);
    }

    @Test
    public void test5(){
        List<Passenger> passOnFloor = new ArrayList<>();

        Passenger pas5 = new Passenger(3, 5);
        Passenger pas6 = new Passenger(3, 5);
        Passenger pas7 = new Passenger(3, 5);
        Passenger pas8 = new Passenger(3, 5);

        passOnFloor.add(pas5);
        passOnFloor.add(pas6);
        passOnFloor.add(pas7);
        passOnFloor.add(pas8);

        Elevator elevator = new Elevator();
//        elevator.cabin = cabin;
        elevator.freeSpace = 5;
        elevator.finalDestination = 11;
        elevator.currentDestination = 0;
        elevator.isRising = true;
        elevator.currentFloor = 0;
        System.out.println(elevator);
        elevator.stop(passOnFloor);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.freeSpace, 1);
    }

    @Test
    public void test6(){
        List<Passenger> cabin = new ArrayList<>();

        Passenger pas1 = new Passenger(0, 2);
        Passenger pas2 = new Passenger(0, 3);
        Passenger pas3 = new Passenger(0, 4);
        Passenger pas4 = new Passenger(0, 4);

        cabin.add(pas1);
        cabin.add(pas2);
        cabin.add(pas3);
        cabin.add(pas4);

        List<Passenger> floor0 = new ArrayList<>();
        floor0.add(new Passenger(0, 5));
        List<Passenger> floor1 = new ArrayList<>();
        floor1.add(new Passenger(1, 4));
        List<Passenger> floor2 = new ArrayList<>();
        floor2.add(new Passenger(2, 3));
        List<Passenger> floor3 = new ArrayList<>();
        floor3.add(new Passenger(3, 2));
        List<Passenger> floor4 = new ArrayList<>();
        floor4.add(new Passenger(4, 1));
        List<Passenger> floor5 = new ArrayList<>();
        floor5.add(new Passenger(5, 0));

        Floor[] houseTest = new Floor[6];
        houseTest[0] = new Floor(0, floor0);
        houseTest[1] = new Floor(1, floor1);
        houseTest[2] = new Floor(2, floor2);
        houseTest[3] = new Floor(3, floor3);
        houseTest[4] = new Floor(4, floor4);
        houseTest[5] = new Floor(5, floor5);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 1;
        elevator.finalDestination = 11;
        elevator.currentDestination = 0;
        elevator.isRising = true;
        elevator.currentFloor = 0;
        System.out.println(elevator);
        elevator.route(houseTest);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.currentDestination, 1);
    }

    @Test
    public void test7(){
        List<Passenger> cabin = new ArrayList<>();

        List<Passenger> floor0 = new ArrayList<>();
        floor0.add(new Passenger(0, 5));
        List<Passenger> floor1 = new ArrayList<>();
        floor1.add(new Passenger(1, 4));
        List<Passenger> floor2 = new ArrayList<>();
        floor2.add(new Passenger(2, 3));
        List<Passenger> floor3 = new ArrayList<>();
        floor3.add(new Passenger(3, 2));
        List<Passenger> floor4 = new ArrayList<>();
        floor4.add(new Passenger(4, 1));
        List<Passenger> floor5 = new ArrayList<>();
        floor5.add(new Passenger(5, 0));

        Floor[] houseTest = new Floor[6];
        houseTest[0] = new Floor(0, floor0);
        houseTest[1] = new Floor(1, floor1);
        houseTest[2] = new Floor(2, floor2);
        houseTest[3] = new Floor(3, floor3);
        houseTest[4] = new Floor(4, floor4);
        houseTest[5] = new Floor(5, floor5);

        Elevator elevator = new Elevator();
        elevator.cabin = cabin;
        elevator.freeSpace = 5;
        elevator.finalDestination = 11;
        elevator.currentDestination = 0;
        elevator.isRising = true;
        elevator.currentFloor = 0;
        System.out.println(elevator);
        elevator.route(houseTest);
        System.out.println(elevator);
        Assertions.assertEquals(elevator.currentDestination, 1);
    }
}




