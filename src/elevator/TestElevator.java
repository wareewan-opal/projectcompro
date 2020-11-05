/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;


import java.util.Scanner;

/**
 *
 * @author user
 */
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
            System.out.print("\nEnter menu => ");
            int menu = scanner.nextInt();
            System.out.println("");
            switch(menu) {
                case 1:
                    System.out.print("Enter First name => ");      
                    String firstName = scanner.next();
                    System.out.print("\nEnter Last name => ");      
                    String lastName = scanner.next();
                    System.out.print("\nEnter weight => ");
                    scanner.nextLine();
                    int weight = scanner.nextInt();
                    boolean addSuccess = elevator.increasePeople(firstName + " " + lastName, weight);
                    if(!addSuccess) System.out.println("Over people or Over weight"); 
                    break;
                case 2:
                    System.out.print("\nEnter floor => ");
                    selectFloor = scanner.nextInt();
                    elevator.setFloor(selectFloor);
                    break;
                case 3:
                    System.out.println(elevator.toString());
                    break;
                default:
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
