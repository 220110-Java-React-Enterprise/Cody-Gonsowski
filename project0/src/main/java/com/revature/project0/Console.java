package com.revature.project0;

import java.util.Scanner;

/**
 * Driving class of the console bank program.
 */
public class Console {
    public static void main(String[] args) {
        boolean hasQuit = false;
        char choice;
        Scanner scanner = new Scanner(System.in);

        do {
            // print menu
            Console.printMenu();

            // get first character of next user input cluster
            System.out.print("Please input your selection and press Enter: ");
            choice = scanner.next().toCharArray()[0];

            // perform action based on
            switch(choice) {
                //TODO login to existing account
                case 'l':
                    break;

                //TODO deposit
                case 'd':
                    break;

                //TODO withdrawal
                case 'w':
                    break;
                
                //TODO list all associated bank accounts with balances
                case 'b':
                    break;
                
                //TODO adds a new bank account
                case 'a':
                    break;
                
                //TODO registers a new user account
                case 'r':
                    break;
                
                // exits menu loop
                case 'q':
                    System.out.println("Thank you for using the bank console program!");
                    hasQuit = true;
                    break;
            }

        } while (!hasQuit); // loop while the user has not quit

        // close scanner used for user input
        scanner.close();
    }


    public static void printMenu() {
        // one long string ensures menu will be printed together
        String menu = "\n----------------MENU----------------"
                    + "\nl - Login to a user account"
                    + "\nd - Deposit to a bank account"
                    + "\nw - Withdraw from a bank account"
                    + "\nb - Bank account list with balances"
                    + "\na - Add a new bank account"
                    + "\nr - Register for a new user account"
                    + "\nq - Quit"
                    + "\n------------------------------------";
        
        // print the menu
        System.out.println(menu);
    }
}
