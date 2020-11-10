/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class Elevator {

    private boolean doorOpen;
    private final double maxWeight = 1500;
    private ArrayList<People> currentPeople = new ArrayList<People>();
    private final int maxPeople = 13;
    private final int maxFloor = 4;
    private final int minFloor = 1;
    private int currentFloor;

    public Elevator() {

        this.currentFloor = 1;
        this.doorOpen = false;
    }

    public double getWeight() {
        if (currentPeople.isEmpty()) {
            return 0;
        }
        double weight = 0;
        for (int i = 0; i < currentPeople.size(); i++) {
            weight += currentPeople.get(i).getWeight();
        }
        return weight;
    }

    public String getPeopleInfo() {
        return currentPeople.toString();
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
        if (getWeight() > maxWeight || weight > maxWeight) {
            return false;
        }
        if (currentPeople.size() >= maxPeople) {
            return false;
        }
        currentPeople.add(new People(name, weight));
        return true;
    }

    public boolean decreasePeople(String name) {
        if (currentPeople.isEmpty()) {
            return false;
        }

        for (int i = 0; i < currentPeople.size(); i++) {
            People p = currentPeople.get(i);
            if (p.getName().equals(name)) {
                currentPeople.remove(i);
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
