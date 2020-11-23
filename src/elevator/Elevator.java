package elevator;

import java.util.ArrayList;
import java.util.Arrays;

public class Elevator {

    private boolean doorOpen;
    private double maxWeight;
    private People[] currentPeople;
    private int maxPeople;
    private int maxFloor;
    private int minFloor;
    private int currentFloor;
//    public Elevator(){
//        
//    }

    public Elevator(double maxWeight, int maxPeople, int maxFloor, int minFloor) {
        this.maxWeight = maxWeight;
        this.maxPeople = maxPeople;
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
        this.currentFloor = 1;
        this.doorOpen = false;
        this.currentPeople = new People[this.maxPeople];
    }

    public double getWeight() {
//        if (currentPeople.length == 0) {
//            return 0;
//        }
        double weight = 0;
        for (int i = 0; i < currentPeople.length; i++) {
            if (currentPeople[i] != null) {
                weight += currentPeople[i].getWeight();
            }
        }
        return weight;
    }

    public int getPeopleInfo() { //จำนวนคน
        int people = 0;
        for (int i = 0; i < currentPeople.length; i++) {
            if (currentPeople[i] != null) {
                people++;
            }
        }
        return people;
    }

    public boolean setFloor(int floor) {
        if (floor >= 1 && floor <= 4) {
            currentFloor = floor;
            return true;
        } else {
            return false;
        }
    }

    public boolean increasePeople(String name, double weight) {
        if (Double.sum(getWeight(), weight) > maxWeight) { //การบวกค่า double ต้องใช้ คำสั่ง sum เข้ามาช่วย
            return false;
        }
        if (getPeopleInfo() >= maxPeople) {
            return false;
        }
        //add people
        for (int i = 0; i < currentPeople.length; i++) {
            People p = currentPeople[i];
            if (p == null) {
                currentPeople[i] = new People(name, weight);
                break; // ถ้าไม่ break มันจะ *13 ตามจำนวน array ที่เรากำหนดค่าไว้
            }
        }
        return true;
    }

    public boolean decreasePeople(String name) {
        if (getPeopleInfo() <= 0) {
            return false;
        }

        for (int i = 0; i < currentPeople.length; i++) {
            People p = currentPeople[i];
            if (p != null && p.getName().equals(name)) {
                currentPeople[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Elevator{" + "doorOpen=" + doorOpen + ", maxWeight=" + maxWeight + ", currentWeight=" + getWeight() + ", currentPeople=" + getPeopleInfo() + ", maxPeople=" + maxPeople + ", maxFloor=" + maxFloor + ", minFloor=" + minFloor + ", currentFloor=" + currentFloor + '}';
    }

}
