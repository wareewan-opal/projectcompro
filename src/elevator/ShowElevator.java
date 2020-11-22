package elevator;

import java.util.Scanner;

public class ShowElevator {

    private Elevator elevator;
    private int selectFloor = 0;
    private String firstName = "";
    private String lastName = "";

    public void ElevatorMenu() {
        if (elevator == null) {
            elevator = new Elevator(1500.0, 13, 4, 1);
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("========== [ Elevator ] ==========\n");
            System.out.println("1. Increase people to elevator");
            System.out.println("2. Choose floor");
            System.out.println("3. Status Elevator");
            System.out.println("4. Decrease people from elevator");
            System.out.print("\nEnter menu => ");
            int menu = scanner.nextInt();
            System.out.println("");
            String firstName = "";
            String lastName = "";
            switch (menu) {
                case 1:
                    IncreaseElevator();
                    break;
                case 2:
                    FloorElevator();
                    break;
                case 3:
                    StatusElevator();
                    break;
                case 4:
                    DecreaseElevator();
                    break;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("-- Input menu invalid, only 1 - 4 is accepted --");
                    System.out.println("------------------------------------------------");
                    break;
            }
        }
    }

    public void IncreaseElevator() {
        Scanner scanner = new Scanner(System.in);
        //Elevator elevator = new Elevator(); 
        System.out.print("Enter First name => ");
        firstName = scanner.next();
        System.out.print("\nEnter Last name => ");
        lastName = scanner.next();
        System.out.print("\nEnter weight => ");
        scanner.nextLine();
        int weight = scanner.nextInt();
        boolean addSuccess = elevator.increasePeople(firstName + " " + lastName, weight);
        if (!addSuccess) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!! Over people or Over weight !!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public void FloorElevator() {
        Scanner scanner = new Scanner(System.in);
        //Elevator elevator = new Elevator();
        System.out.print("\nEnter floor => ");
        selectFloor = scanner.nextInt();
        boolean setFloorSuccess = elevator.setFloor(selectFloor);
        if (!setFloorSuccess) {
            System.out.println("****************************");
            System.out.println("*** Input floor invalid ***");
            System.out.println("****************************");
        }
    }

    public void StatusElevator() {
        //Elevator elevator = new Elevator();
        System.out.println(elevator.toString());
    }

    public void DecreaseElevator() {
        Scanner scanner = new Scanner(System.in);
        //Elevator elevator = new Elevator();
        System.out.print("Enter First name => ");
        firstName = scanner.next();
        System.out.print("\nEnter Last name => ");
        lastName = scanner.next();
        scanner.nextLine();
        boolean removeSuccess = elevator.decreasePeople(firstName + " " + lastName);
        if (!removeSuccess) {
            System.out.println("-------------------------------------------");
            System.out.println("--- Elevator is empty or Name for found ---");
            System.out.println("-------------------------------------------");
        }
    }
}
