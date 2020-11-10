
package elevator;


import java.util.Scanner;

public class TestElevator {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        int selectFloor = 0;
        while(true) {
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
            switch(menu) {
                case 1:
                    System.out.print("Enter First name => ");      
                    firstName = scanner.next();
                    System.out.print("\nEnter Last name => ");      
                    lastName = scanner.next();
                    System.out.print("\nEnter weight => ");
                    scanner.nextLine();
                    int weight = scanner.nextInt();
                    boolean addSuccess = elevator.increasePeople(firstName + " " + lastName, weight);
                    if(!addSuccess) System.out.println("Over people or Over weight"); 
                    break;
                case 2:
                    System.out.print("\nEnter floor => ");
                    selectFloor = scanner.nextInt();
                    boolean setFloorSuccess = elevator.setFloor(selectFloor);
                    if (!setFloorSuccess) System.out.println("Input floor invalid");
                    break;
                case 3:
                    System.out.println(elevator.toString());
                    break;
                case 4:
                    System.out.print("Enter First name => ");      
                    firstName = scanner.next();
                    System.out.print("\nEnter Last name => ");      
                    lastName = scanner.next();
                    scanner.nextLine();
                    boolean removeSuccess = elevator.decreasePeople(firstName + " " + lastName);
                    if(!removeSuccess) System.out.println("Elevator is empty or Name for found"); 
                    break;
                default:
                    System.out.println("Input menu invalid, only 1 - 4 is accepted");
                    break;
            }
            System.out.println("");
            if(selectFloor == 4) {
                System.out.println("Elevator now on 4th floor.");
                break;
            }
        }
    }
    
}
