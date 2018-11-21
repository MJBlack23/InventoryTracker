package main;

/**
 * Inventory Tracker is an application that allows the user to
 *  1. add items to their inventory
 *  2. view items in their inventory
 *  3. save inventory to a file
 *  4. load inventory to a file
 */

import java.util.Scanner;

public class InventoryTrackerInterface {
    private Inventory catalogue;
    private Scanner scnr;

    /**
     * Private constructor to create the object
     */
    private InventoryTrackerInterface() {
        this.catalogue = new Inventory();
        this.scnr = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Create the inventory Tracker object
        InventoryTrackerInterface inventory = new InventoryTrackerInterface();

        while (true) {
            // Print the user prompt
            inventory.printPrompt();

            // Wait for user input
            inventory.handleUserSelection();
        }
    }

    private void handleUserSelection() {
        // Print a caret to simulate a command prompt
        System.out.print(" > ");

        // Return the next int if pressed otherwise default to something
        // Outside the range of the switch statement
        int response = scnr.hasNext() ? this.scnr.nextInt() : 0;

        // Create switch handler to handle the response
        switch (response) {
            case 1:
                this.handleAddItem();
                break;
            case 2:
                this.handleGetItem();
                break;
            case 3:
                this.catalogue.saveInventoryToFile();
                System.out.println("Inventory saved to inventoryOutFile.csv");
                this.promptToContinue();
                break;
            case 4:
                this.catalogue.loadInventoryFromFile();
                System.out.println("Inventory loaded from inventoryInFile.csv");
                this.promptToContinue();
                break;
            case 5:
                this.handleExit();
                break;
            default:
                System.out.printf(" %d Not a valid option, Select 1 - 5.\n", response);
                this.handleUserSelection();
                return;
        }
    }

    /**
     * handleExit prints a friendly exit message before exiting the application
     */
    private void handleExit() {
        System.out.println(" Thank you for using the Inventory Tracker! ");
        System.out.println(" Exiting now!");
        System.exit(0);
    }

    /**
     * handleAddItem prompts the user for the data needed to create an item
     * It waits for user input for each field and then calls addItemToCatalogue
     */
    private void handleAddItem() {
        // Prompt the user for the information
        System.out.print(" Enter item name: ");
        String name = this.scnr.hasNext() ? this.scnr.next() : null;

        System.out.print(" Enter item quantity: ");
        int quantity = this.scnr.hasNextInt() ? this.scnr.nextInt() : -1;

        System.out.print(" Enter item price: ");
        double price = this.scnr.hasNextDouble() ? this.scnr.nextDouble() : -99.99;

        System.out.print(" Enter item UPC: ");
        String upc = this.scnr.hasNext() ? this.scnr.next() : null;

        this.addItemToCatalogue(name, quantity, price, upc);
    }

    /**
     * addItemToCatalogue creates an item from the user input and adds it to the collection
     * @param name - the name of the item
     * @param quantity - the quantity of the item
     * @param price - the price of the item
     * @param upc - the upc for the item
     */
    private void addItemToCatalogue(String name, int quantity, double price, String upc) {
        Item item = new Item(name, quantity, price, upc);

        this.catalogue.addItem(item);
    }

    /**
     * handleGetItems lets the user know how many items are in their inventory
     * and then prompts them for the index of the item they would like to see
     * then attempts to print that item
     */
    private void handleGetItem() {
        if (this.catalogue.getTotalNumberOfItems() == 0) {
            System.out.println("You have no items in your inventory, add some manually with option 1 or load some from an inventory file.");
            return;
        }
        System.out.printf(" Which item would you like to look for? [0 - %d]: ", this.catalogue.getTotalNumberOfItems() - 1);
        int index = this.scnr.hasNextInt() ? this.scnr.nextInt() : -1;

        Item item = this.catalogue.getItem(index);

        if (item != null) {
            this.printItem(item);
        } else {
            System.out.println("No item with that index exists.");

            this.promptToContinue();
        }
    }

    /**
     * Helper function to print an item
     * @param item
     */
    private void printItem(Item item) {
        System.out.println("  Name: " + item.getName());
        System.out.println("  Price: " + item.getPrice());
        System.out.println("  Quantity: " + item.getQuantity());
        System.out.println("  UPC: " + item.getUPC());

        this.promptToContinue();
    }

    private void promptToContinue() {
        System.out.print(" Press 1 to continue... ");
        int x = this.scnr.hasNext() ? this.scnr.nextInt() : -1;
    }

    /**
     * printPrompt() prints the prompt the user will use to interact with the application
     */
    private void printPrompt() {
        InventoryTrackerInterface.clearScreen();
        System.out.println(" =============================================== ");
        System.out.println(" Welcome to the Inventory Tracker!");
        System.out.printf(" You currently have %d items in your inventory.\n", this.catalogue.getTotalNumberOfItems());
        System.out.println(" ");
        System.out.println(" Select an action below by entering 1 - 5.");
        System.out.println(" 1. Add an item to inventory");
        System.out.println(" 2. Get an item by it's index in inventory");
        System.out.println(" 3. Save Inventory to file");
        System.out.println(" 4. Load Inventory from file");
        System.out.println(" 5. Exit");
    }

    /**
     * Clear the screen on each loop
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}