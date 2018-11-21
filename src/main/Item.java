package main;

/** Item represents an individual item within the inventory tracker
 * User can create, and get thee item as well as each of the item's attributes
 */
public class Item {
    private String name;
    private int quantity;
    private double price;
    private String upc;

    /**
     * Blank private constructor to prevent creation without params
     */
    private Item() {}

    /**
     * The actual constructor
     * @param name
     * @param quantity
     * @param price
     * @param upc
     */
    public Item(String name, int quantity, double price, String upc) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.upc = upc;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public String getUPC() {
        return this.upc;
    }

}
