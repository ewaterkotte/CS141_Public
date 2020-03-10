# The Dessert Store Specification
### Overview
This application and its code models the inventory and sales for a Dessert Store chain of several stores, kiosks, or "carts" (small mobile dessert stores).

### Table of Contents
- [How a Dessert Store Works](#howItWorks)
- [Dessert Store Fields](#fields): Names, descriptions and details for all DessertStore fields
   - [.name](#.name): Name of the dessert store instance
   - [.appleIce](#.appleIce): Quantity of apple ice in the inventory
   - [.bananaIce](#.bananaIce): Quantity of banana ice in the inventory
   - [.cones](#.cones): Quantity of cones in the inventory
   - [.appleDessertSales](#.appleDessertSales): Total number of apple dessert sales
   - [.bananaDessertSales](#.bananaDessertSales): Total number of banana dessert sales
- [Dessert Store Methods](#methods): Instance methods for the DessertStore
   - [Constructor](#constructor): Creating DessertStore instances
   - [.addInventory()](#.addInventory): Method to add items to a dessert store's inventory
   - [.sellAppleDessert()](#.sellAppleDesserts): Method used to sell "n" appleDesserts 
   - [.sellBananaDessert()](#.sellBananaDesserts): Method used to sell "n" bananaDesserts
   - [.toString()](#.toString): Override of the default Java toString method for displaying a dessert store
- [Static Methods](#StaticMethods): Static Methods
   - [totalDessertsSold()](#.totalDessertsSold): Total desserts sold for a given dessert store
   - [salesDistributionPercentage()](#.salesDistributionPercentage): Apple/Banana Sales as a percentage of total sales
- [Testing](#Testing): Test code requirements
   - [Testing the constructor](#test_constructor): Test the construction of a dessert store object
   - [Testing the sale of an apple dessert](#test_appleSale): Test the sale of apple desserts
- [Explanatory Client Code](#client): Code that demonstrates the functionality of the DessertStore   

### <a name="howItWorks"></a>How a Dessert Store Works
- A single Dessert Store sells "appleDesserts" and "bananaDesserts"
- In order to sell desserts a dessert store must have sufficient inventory for the supplies necessary to make and sell a singe dessert.
 
### Making and selling a dessert
In order to sell a dessert, the dessert store must make the dessert from one unit of ice that corrosponds to the flavor of dessert and one cone.  For example, to make an apple dessert the dessert store must have one unit of apple ice and one cone. If either the ice or the cone are missing, the dessert store cannot sell the dessert.

In order to make and sell a dessert, the dessert store must have:
- One (1) unit of Ice (either appleIce or bananaIce) depending on apple or banana dessert
- One (1) edible cone

### What makes a DessertStore
The following defines and describes what is required to make a dessert store
- Each DessertStore has its own name (a string) - This is a public field named "name"
- Each DessertStore has its own inventory of cones, apple ice, and banana ice
- Each DessertStore tracks its own sales of apple desserts and banana desserts

## <a name="fields"></a>DessertStore Fields
#### <a name=".name"></a>DessertStore .name
The name of any single dessert store must be specified in order to construct an instance of a DessertStore object.  The name is a single, string public field that can be accessed direclty using aDessertStore.name in the case that our DessertStore object is "aDessertStore".

Field Name | Data Type | Description
-----------|-----------|-------------
***.name***|`String`|The name of the single dessert store instance.  For example: "Port Angeles Downtown"

#### DessertStore inventories
Each dessert store has its own inventory of cones, apple ice and banana ice.  To manage inventory the dessert store maintains a count of units for cones, apple ice and banana ice.  The following flields are public integer fields of the DessertStore and may be implemented with field names defined by the developer.

Inventory Item | Data Type | Description
---------------|-----------|------------
***<a name=".cones"></a>.cones*** | `int` | Number of cones the store currently has on hand
***<a name=".appleIce"></a>.appleIce***| `int`| Number of units of apple ice the store currently has on hand
***<a name=".bananaIce"></a>.bananaIce***| `int`| Number of units of banana ice the store currently has on hand

#### DessertStore sales
Each dessert store keeps track of sales for apple desserts and banana desserts separately using two public integer fields.  The following flields are used to track sales and are public integer fields of the DessertStore and may be implemented with field names defined by the developer.

Sales Item | Data Type | Description
---------------|-----------|------------
***<a name=".appleDessertSales"></a>.appleDessertSales*** | `int` | Quantity of apple desserts sold by the individual dessert store
***<a name=".bananaDessertSales"></a>.bananaDessertSales***| `int`| Quantity of banana desserts sold by the individual dessert store

## <a name="methods"></a>Dessert Store Methods
The following instance methods are available to any instance of a DessertStore object or are used to construct a DessertStore.

### <a name="constructor"></a>Constructor - Constructing DessertStore objects
In order to construct a DessertStore object the constructor will require only the name of the store we are going to construct.  When a new DessertStore is created, its name is set and all inventory and sales amounts are initialized to 0.

Method Name | Arguments | Description
------------|-----------|------------
***DessertStore***|`String`  name|Create an instance of a DessertStore with the supplied name with all fields

### <a name=".addInventory"></a>Adding Items to the Inventory
In order to add items to a DessertStore's inventory, use the following pubic method.  The method addInventory will allow for the addition of apple ice, banana ice, cones or all three and will return nothing.

Method Name | Arguments | Description
------------|-----------|-------------
***addInventory***| `int` appleIce, `int` bananaIce, `int` cones|Adds all three quantities to the inventory 

## Selling Desserts
In order to sell a dessert, the dessert store must make the dessert from one unit of ice that corrosponds to the flavor of dessert and one cone.  For example, to make an apple dessert the dessert store must have one unit of apple ice and one cone. If either the ice or the cone are missing, the dessert store cannot sell the dessert.

### Methods to support selling desserts
The dessert store class has two methods for selling desserts.  Each method accepts an integer value representing the desired quantity to sell.  Each method returns an integer indicating how many of the desired amount were able to be sold. The methods will not make any substitutions and will only sell desserts if the inventory items allow for the dessert type to be sold.
***Method Declarations***
Method Name | Return Value | Arguments
------------|--------------|----------
***<a name=".sellAppleDesserts"></a>sellAppleDesserts***|`int` - the number actually sold| `int` n - desired quantity to sell
***<a name=".sellBananaDesserts"></a>sellBananaDesserts***|`int` - the number actually sold|`int` n - desired quantity to sell

#### Each method must perform the following actions: ####
1. Determine how many of the desired quantity n that can be sold
***e.g., sellAppleDesserts(n):***
-- To sell n the inventory must have appleIce >= n and cones >= n
-- If not, how many apple desserts can be made with appleIce and cones?
2. Remove that number from the inventory and add to sales
***e.g., for appleDessert sales:***
-- Subtract from appleIce 
-- Add to appleDessertsSold (or whatever you named the apple sales field)
3. Return that number of actual sales as an integer.

## <a name=".toString"></a>Displaying a DessertStore's state 
In order to display a DessertStore's state including its name, inventory amounts and sales amounts we must override the `toString()` method in Java.

***Use this format:*** 
[`<name>`: apple/banana/cones inventory: `<appleIce>`/`<bananaIce>`/`<cones>`; sales: `<apple sales>`/`<banana sales>`]

***Examples***
```
[So East Branch: apple/banana/cones inventory: 20/50/370; sales: 100/130]
[Main Branch: apple/banana/cones inventory: 25/23/60; sales: 10/12]
```

## <a name="StaticMethods"></a>Public Static methods that work on DessertStore objects
The following methods will exist within the DessertStore class but are designed to be used when we already have an instance of a DessertStore and want to find out information about an individual DessertStore.  To use these methods, pass in a specific instance of a DessertStore "ds".

### <a name=".totalDessertsSold"></a>Total Desserts Sold
Method to return the total number of desserts sold for the given DessertStore.

Method Name|Return Value|Argument|Description
-----------|------------|--------|---------------------
***totalDessertsSold***|`int` total desserts sold|`DessertStore` ds|Returns the combined sales of apple and banana desserts sold by the DessertStore "ds"

### <a name=".salesDistributionPercentage"></a>Sales Distribution Percentage
Method to compute and return the apple and banana sales as a percent of total sales.

Method Name|Return Value|Argument|Description
-----------|------------|--------|---------------------
***saleDistributionPercentage***|`double[]` returned array `[0]` = apple sales as percent returned array `[1]` = banana sales as percent| `DessertStore` ds|Compute and return apple sales and banana sales as a percentage of total sales.

# <a name="Testing"></a>Necessary Tests
Test methods must be developed to test the code for the DessertStore class before it can be safely used.  Implement the following necessary tests.

## <a name="test_constructor"></a>Test the Constructor
***Name:*** `test_DessertStoreConstructor()`
***Description:*** Tests the construction of a DessertStore and validates that the name of the DessertStore gets set and all inventory and sales fields are set to 0.

## <a name="test_appleSale"></a>Test the selling of Apple Desserts 
***Name:*** `test_sellAppleDesserts()`
***Description:*** Tests the sale of apple desserts by making sure inventory gets added to the store before selling and that after selling, the correct inventories are adjusted by the specified amounts listed in the details for the sellAppleDesserts method.  Make sure the method returns the correct number of items that ***can*** be sold, as limited by inventory.  Make sure that the number of items actually sold is added to sales and subtracted from the correct inventories.
***Test Cases:*** Make sure that the following cases get tested at a minimum:
1. When there is enough inventory to sell the full number requested
2. When there is not enough inventory to sell the full number requested


## <a name="client"></a>Explanatory Client Code ##
The following client code uses the intended DessertStore software.  It shows how the software will be used and explains the model.  This client code and test code can be called from DessertStore main() during development.
```
//  This client code gives an example and explanations of how the DessertStore class will be used
//
//  It should generate the following output
// >>>>>> output >>>>>>>>>>>
//  Dessert Store
//  Initial DessertStore: [Main: apple/banana/cones  inventory: 0/0/0;  sales: 0/0]
//  After adding inventory: [Main: apple/banana/cones  inventory: 2/5/6;  sales: 0/0]
//  Sold apple desserts: 2
//  After selling apple desserts: [Main: apple/banana/cones  inventory: 0/5/4;  sales: 2/0]
//  Sold banana desserts: 4
//  After selling banana desserts: [Main: apple/banana/cones  inventory: 0/1/0;  sales: 2/4]
//  Sales, percent of total apple/banana: 33.33/66.67
//  <<<<<<<<<<<<<<<<<<<<<<<<<
public static void dessertStoreExplanatoryClient() {

    // --------------------------------------
    // Instantiate a store with no inventory
    // --------------------------------------
    DessertStore mainStore = new DessertStore("Main");
    System.out.println("Initial DessertStore: " + mainStore);

    // ------------------------------------------
    // Add inventory: appleIce, bananaIce, cones
    // ------------------------------------------
    mainStore.addInventory(2, 5, 6);
    System.out.println(" After adding inventory: " + mainStore);
    // Main store now has 2 appleIce, 5 bananaIce, and 6 cones

    // -------------------------------
    //  Try to sell 10 Apple Deserts
    // -------------------------------
    int qtySoldA1 = mainStore.sellAppleDesserts(10);
    System.out.println("Sold apple desserts: " + qtySoldA1);
    // qtySoldA1 = 2 because we only have 2 appleIce (but we have at least 2 cones)
    // We should now have 0 appleIce, 5 bananaIce, and 4 cones
    // Sales should now be: we have sold 2 appleDesserts, 0 bananaDesserts
    System.out.println(" After selling apple desserts: " + mainStore);

    // -------------------------------
    //  Try to sell 7 Banana Deserts
    // -------------------------------
    int qtySoldB2 = mainStore.sellBananaDesserts(7);
    System.out.println("Sold banana desserts: " + qtySoldB2);
    // qtySoldB2 = 4 because we have 5 bananaIce, but only 4 cones and we run out of cones first
    // We should now have 0 appleIce, 1 bananaIce, and 0 cones. Sales should show
    // Sales should now be: we have sold 2 appleDesserts, 4 bananaDesserts
    System.out.println(" After selling banana desserts: " + mainStore);

    // -----------------------------------------------------------------------------------------
    // Get and show the sales statistics: 
    // apple desserts and banana desserts sold as percent of total sales qty
    // ----------------------------------------------------------------------------------------
    double[] salesDist = salesDistributionPercentage(mainStore);
    // total sales is now 2 + 4 = 6, so apple pct is 33.33, banana desserts is 66.67
    System.out.println("Sales, percent of total apple/banana: "
            + String.format("%.2f", salesDist[0]) + "/" + String.format("%.2f", salesDist[1]));
    //  Alternate output syntax:
    //    System.out.printf("fmt Sales, percent of total apple/banana: %.2f/%.2f\n", salesDist[0], salesDist[1]);

}
```
