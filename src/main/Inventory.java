package main;

import java.io.*;
import java.util.Scanner;

/**
 * Inventory service as the repository for managing the items in the
 * Inventory Tracker application
 */
public class Inventory {
    private Item[] itemArray = new Item[100];
    private int totalItems = 0;
    private String headerLine = "Name,Quantity,Price,UPC";

    /**
     * Return the current number of items in the array (not the total capacity)
     * @return int
     */
    public int getTotalNumberOfItems() {
        return totalItems;
    }

    /** getItem takes an index value and attempts to return the item located
     * at that index value in the itemArray
     * If the value is less than 0 or more than the current number of items
     * It is considered out of bounds and we return null
     * @param index
     * @return Item
     */
    public Item getItem(int index) {
        if (index < 0 || index > this.totalItems) {
            return null;
        }

        return itemArray[index];
    }

    /** addItem takes an instance of newItem
     * If it is not null it appends the item to the itemArray
     * @param newItem: Item
     * @return void
     */
    public void addItem(Item newItem) {
        // Check if the newItem is null
        if (newItem == null) {
            System.out.println("Invalid Item, item not added");
            return;
        }

        // Append the item into the array
        itemArray[this.totalItems] = newItem;

        // Increment the item count
        this.totalItems++;
    }

    /** saveInventoryToFile saves the current itemArray to a csv file
     *
     */
    public void saveInventoryToFile() {
        // Wrap the IO in a try/catch to catch FileNotFound Exception
        try {
            // Create the file
            FileWriter file = new FileWriter("./inventoryOutFile.csv");

            // Print header
            file.write(this.headerLine + "\n");

            // Loop through each of the items in the item array
            for (int i = 0; i < this.totalItems; i++) {
                // extract the item from the array
                Item item = this.itemArray[i];
                // Print the formatted line onto the file
                String row = String.format("%s,%d,%f,%s\n", item.getName(), item.getQuantity(), item.getPrice(), item.getUPC());
                file.write(row);
            }

            // Close the link to the file so others can use it
            file.close();
        } catch (IOException e) {
            System.out.println("Unable to locate file: inventoryOutFile.csv");
        } catch (NullPointerException e) {
            System.out.println("Unable to locate file: inventoryOutFile.csv");
            throw e;
        } catch (RuntimeException e) {
            System.out.println("Unexpected Error: " + e.toString());
        }
    }

    /** loadInventory from file reads from a file in the root directory
     * called "inventoryInFile.csv" that has a header that matches this.headerLine
     */
    public void loadInventoryFromFile() {
        // Create a file pointer

        // Wrap this functionality in a try/catch to handle file not found exception
        try {
            // Create the scanner to read from the file
            FileReader reader = new FileReader("./inventoryInFile.csv");
            Scanner sc = new Scanner(reader);

            while (sc.hasNextLine()) {
                // Exact the nextLine
                String rowText = sc.nextLine();

                // Ignore the header line
                if (!rowText.equals(this.headerLine)) {
                    // Split the string on the comma delimiter
                    String[] rowArray = rowText.split(",");
                    // Parse each value into it's proper format to create the item
                    String name = rowArray[0];
                    int quantity = Integer.parseInt(rowArray[1]);
                    double price = Double.parseDouble(rowArray[2]);
                    String upc = rowArray[3];

                    // Create the item
                    Item item = new Item(name, quantity, price, upc);

                    // Append it to the item array
                    this.itemArray[this.totalItems] = item;

                    // increment the totalItems counter
                    this.totalItems++;
                }
            }

            // Close the link to the file so others can use it
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Infile Not Found. Please provide inventoryInfile.csv");
        } catch (RuntimeException e) {
            System.out.println("Error: Unexpected input reading from file. " + e.toString());
        }
    }
}
