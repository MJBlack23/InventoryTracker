package main;

public class InventoryTrackerInterface {
    public static void main(String[] args) {
        // test to create a new item
        Item mango = new Item("mango", 1, 3.78, "0987654321");

        System.out.println("Name: " + mango.getName());
        System.out.println("Price: " + mango.getPrice());
        System.out.println("Quantity: " + mango.getQuantity());
        System.out.println("UPC: " + mango.getUPC());

        // Make some assertions
        assert mango.getName().equals("mango");
        assert mango.getQuantity() == 1;
        assert mango.getPrice() == 3.78;
        assert mango.getUPC().equals("0987654321");

        // Testing the Inventory class
        Inventory catalogue = new Inventory();

        System.out.printf("Number of Items: %d\n", catalogue.getTotalNumberOfItems());

        // Make assertions on Inventory
        assert catalogue.getTotalNumberOfItems() == 0;

        catalogue.addItem(mango);

        System.out.printf("Number of Items: %d\n", catalogue.getTotalNumberOfItems());

        assert catalogue.getTotalNumberOfItems() == 1;

        Item theMango = catalogue.getItem(0);

        // Make some assertions
        assert theMango.getName().equals("mango");
        assert theMango.getQuantity() == 1;
        assert theMango.getPrice() == 3.78;
        assert theMango.getUPC().equals("0987654321");

    }
}
