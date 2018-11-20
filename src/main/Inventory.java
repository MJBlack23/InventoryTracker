package main;

/**
 * Inventory service as the repository for managing the items in the
 * Inventory Tracker application
 */
public class Inventory {
    private Item[] itemArray = new Item [100];
    private int totalItems = 0;

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
}
