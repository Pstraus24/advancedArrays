// Copy the previous program under a new name.
// You are going to build on the program by converting the array to a two-dimensional array.
// The array should hold inventory items and count of items in inventory.
// The user should be able to search for any item and have the item name and amount on hand appear
// on screen (format them nicely).
// The user should be able to add or subtract from any of the inventory.
// Have an error message if the count would become less than 0, and set the count to 0.
// Display the name of the item, the original amount, the amount added or taken away, and the new total.

package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int user_input;// ---  declare variable for user prompts
        String new_amount; // ------ inventory count returned from method processHere ------
        String supplyArray[][] = {{"Rods", "Reels", "Lures", "Hooks", "Sinkers"}, {"100", "90", "80", "70", "60"}}; //------------- Initialize and define two-dimensional array -------------
        Scanner input = new Scanner(System.in);// -------------Initialize variable input for user prompts ----
        do{
            System.out.println("1. " + supplyArray[0][0]);
            System.out.println("2. " + supplyArray[0][1]);
            System.out.println("3. " + supplyArray[0][2]);
            System.out.println("4. " + supplyArray[0][3]);
            System.out.println("5. " + supplyArray[0][4]);
            System.out.println("Enter the item number to view amount on hand: ");
            user_input = input.nextInt();
        }while(user_input !=1 && user_input != 2 && user_input != 3 && user_input != 4 && user_input != 5);

//---------------- switch case for user reply --------------------
        switch (user_input) {
            // -------- call selected method  -----
            case 1:
                // ************** following comments apply to all switch cases *****************
                // --- pass value at array address to method and return new_amount  --------
                new_amount = processHere(supplyArray[0][0], supplyArray[1][0]);
                // --- update value at array address to returned value from method processHere() -----
                supplyArray[1][0] = new_amount;
                break;
            case 2:
                new_amount = processHere(supplyArray[0][1], supplyArray[1][1]);
                supplyArray[1][1] = new_amount;
                break;
            case 3:
                new_amount = processHere(supplyArray[0][2], supplyArray[1][2]);
                supplyArray[1][2] = new_amount;
                break;
            case 4:
                new_amount = processHere(supplyArray[0][3], supplyArray[1][3]);
                supplyArray[1][3] = new_amount;
                break;
            case 5:
                new_amount = processHere(supplyArray[0][4], supplyArray[1][4]);
                supplyArray[1][4] = new_amount;
                break;
        }
        // ************ display updated array *****************
        System.out.println("\nUPDATED INVENTORY");
        System.out.println(" ITEM\t    TOTAL");
        System.out.println("------------------");
        System.out.println(supplyArray[0][0] + "\t     " + supplyArray[1][0]);
        System.out.println(supplyArray[0][1] + "\t     " + supplyArray[1][1]);
        System.out.println(supplyArray[0][2] + "\t     " + supplyArray[1][2]);
        System.out.println(supplyArray[0][3] + "\t     " + supplyArray[1][3]);
        System.out.println(supplyArray[0][4] + "\t     " + supplyArray[1][4]);
    }
    private static String processHere(String item, String amount){// ----- method to add/subtract to array item--
        int intAmount =Integer.parseInt(amount);// -- convert string to integer for math--
        int user_input;// ---  declare variable for user prompts
        int factor;// ----- user input value to add/subtract from array item --------------
        int result;// ------- result of factor action on array item ---------------
        Scanner input = new Scanner(System.in);// ----------  Initialize variable input for user prompts ----
        System.out.println("Item: " + item);
        System.out.println("Qty: " + amount);
        do{
            System.out.println("\n1. To REMOVE items from inventory");
            System.out.println("2. To ADD items from inventory");
            System.out.println("3. To EXIT program");
            System.out.println("Enter 1-3: ");
            user_input = input.nextInt();
        }while(user_input != 1 && user_input != 2 && user_input != 3);
        switch (user_input){
            case 1: // *************** Remove item from inventory ************
                System.out.println("Enter the amount to REMOVE from inventory; ");
                factor = input.nextInt();
                result = intAmount - factor;
                // --- check for result less than zero ------------
                if(result < 0){
                    System.out.println("\nERROR: There are only " + amount + " " + item + " on hand");
                    System.out.println("We will send you " + amount + " " + item + " instead of " + factor);
                    System.out.println("Inventory will be adjusted = 0");
                    result = 0;
                }
                System.out.println(item + " " + amount + " - " + factor + " = " + result);
                amount = String.valueOf(result);// ---------- convert integer to string -----------
                break;
            case 2:// *************** Add item to inventory ************
                System.out.println("Enter the amount to ADD to inventory: ");
                factor = input.nextInt();
                result = intAmount + factor;
                System.out.println(item + " " + amount + " + " + factor + " = " + result);
                amount = String.valueOf(result);
                break;
            case 3:
                System.out.println("'Thanks'");
                break;
        }
        // ******** basically put this here to slow down the output display **********
        System.out.println("<1> to continue and view updated inventory");
        user_input = input.nextInt();
        // System.out.println(user_input);
        return amount;
    }


}
