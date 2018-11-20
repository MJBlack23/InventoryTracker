package main;

public class Inventory {
    private Item[] items = new Item [100];
    private int totalItems = 0;

    public int getTotalNumberOfItems() {
        return totalItems;
    }
}
