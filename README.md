# InventoryTracker
# CIS-183: Object-Oriented Programming in Java

## Milestone 1
* Create the InventoryTrackerInterface class (5pts)
Create the shell of the InventoryTrackerInterface class and add the main method, but don't fill anything in yet.
[Git Branch: Milestone 1](https://github.com/MJBlack23/InventoryTracker/tree/Milestone-1)

## Milestone 2
* Create the Item class and fill in the code (10pts)
    * Private name, qty, price, upc
    * Default private constructor
    * Public constructor with params:
        * name: String
        * qty: int
        * price: double
        * upc: String
    * getName(): String
    * getQuantity(): int
    * getPrice(): double
    * getUPC(): String

 ## Milestone 3
 * Create the Inventory class, its attributes, and the getTotalNumberOfItems() method (5pts)
 Create inventory class and attributes(properties), create the getTotalNumberOfItems() method
 
 ## Milestone 4
 * Create methods getItem() and addItem (20pts)
 Make sure to add error handling to getItem to account for index requests out of bounds. Additem should take an instance 
 of an Item called newItem, should also update totalItems.
 
 ## Milestone 5
 * Create saveInventoryToFile and loadInventoryFromFile (20pts)
 Use PrintWriter class to write inventory file
 
 ## Milestone 6
 * Create loop interface with user (10 pts)
 Display a menu to the user, allow them to enter choice, use switch statement to handle the input.