
// This is a model of a Dessert Store
// Revised 3/5/2020 PM:  Clarified fields, constructor, sales, inventory
// Purpose:
// - Gain more familiarity with modeling and developing software from more complex specifications
// - Explore some of the concepts involved in modeling state and behavior

// This is about modeling, the process, and developing a quality model--with both state and behavior--in code

// =========================
//  DIRECTIONS   DIRECTIONS
// =========================
//  1) Read through this whole specification and understand it
//  1B) DO NOT IMPLEMENT ANY CODE BEFORE YOU COMPLETE STEP 3)
//  2) Look at the code in dessertStoreExplanatoryClient() to understand how this class is used
//  3) Write the tests specified in section  "3. Necessary Tests". Note: THESE TESTS WILL NOT COMPILE YET.
//       IF YOU CANNOT EASILY WRITE THE TESTS, YOU DO NOT YET UNDERSTAND THE MODEL
//          Look in the specs and dessertStoreExplanatoryClient() for information.
//  4) Write comments and implement empty methods and fields to make the tests COMPILE, BUT THE TESTS WILL FAIL
//  5) Implement the methods in the class so that the tests all pass
//      and  dessertStoreExplanatoryClient() runs correctly
//  6) There is nothing tricky here.  If you follow the specs and the steps this will not take much time.

/*

There are three sections in the specifications:
   1. THE MODEL
   2. Structure and Notes
   3. Necessary Tests

===============
1. THE MODEL
===============
This models inventory and sales for a Dessert Store chain of several stores, kiosks, or carts

It sells "appleDesserts" and "bananaDesserts"
Each dessert sold has
  - one unit of Ice (either appleIce or bananaIce) and
  - one edible cone

Read the Explanation of the model in dessertStoreExplanatoryClient()

A) Each DessertStore has its own name (a string) (make this a public Field, named "name")

B) Each DessertStore has its own Inventory and Sales

We need to keep track of the Inventory
---------------------------------------
1) The inventory is the quantity (integer) of each of these: appleIce, bananaIce, and cones that are available to sell.
2) The three inventory quantities can be represented as public integer fields.
   for instance "appleIce", etc.  (since this class does not model anything but inventory and sales)
3) One dessert uses a) one cone and b) one of either appleIce or bananaIce.
4) These should be public int fields (for simplicity. In another assignment they can be made private with getters)

We need to keep track of Sales
--------------------------------
1) quantity sold (integer) of each: apple desserts and banana desserts
2) These should be public int fields (for simplicity).
NOTE:  this means Sales will be represented by two public integer fields
3) In another assignment they can be made private with getters

In order to sell a dessert, we must compose the dessert from
1.	its Ice (apple or banana)  from the inventory and
2.	a cone from the inventory

If either is missing, we cannot make that specific dessert and sell it.

Sell desserts with these two methods
--------------------------------------
int sellAppleDesserts( int n )
int sellBananaDesserts( int n )
n is the desired quantity.
These methods will "compose" and sell as many of the n desired desserts as possible.
They will NOT make substitutions; they will only sell desserts of the desired type.
The methods return the quantity of desserts actually sold

 These methods must
     1) Determine how many of the n that can be sold
         e.g., sellAppleDesserts(n):  to sell n the inventory must have appleIce >= n and cones >= n
               if not, how many apple desserts can be made with appleIce and cones?
     2) Remove that number from the inventory and add to sales
        e.g., for appleDessert sales, a) subtract from appleIce and b) add to appleDessertsSold
     3) Return that number of actual sales.

C) Further Details

Constructor
------------------------------
Use one constructor that takes the name of the dessert store.
It should set the name of the store.  It should set the quantities in the inventory and sales to zero.

Add to the inventory with this method
---------------------------------------
public void addInventory(int appleIce, int bananaIce, int cones)
1) adds these three quantities to the inventory

Display the store and its state (name, inventory, and sales) by overriding  toString()
------------------------------------------------------------------------------------------
Use this format:
[<name>: apple/banana/cones  inventory: <appleIce>/<bananaIce>/cones;  sales: <apple sales>/<banana sales>]
[So East Branch: apple/banana/cones  inventory: 20/50/370;  sales: 100/130]
[Main Branch: apple/banana/cones  inventory: 25/23/60;  sales: 10/12]


Public Static methods that work on DessertStore objects
Put these within the DessertStore class
--------------------------------------------------------------

// Returns the total desserts (combined sales of apple and banana desserts) that ds has sold
public static int totalDessertsSold(DessertStore ds)

// Returns double[2] showing apple and banana sales as percent of total number of sales
//       returned array [0] = apple sales as percent of total sales
//       returned array [1] = banana sales as percent of total sales
public static double[] salesDistributionPercentage(DessertStore ds)


=========================
2. Structure and Notes
=========================
1) The application and client code will all go into the class DessertStore
2) ** during development, have main() call
      a) dessertStoreExplanatoryClient()
      b) other test code for development

3) Because you have not implemented the class, dessertStoreExplanatoryClient() and test code won't compile.

4) The class only handles three specific items for sale (Apple Desserts and Banana Desserts)
and only three specific inventory items (appleIce, bananaIce, and cones)


=====================
3. Necessary Tests
=====================

Write test methods (and name them appropriately) for
1) The constructor (name it test_DessertStoreConstructor())
    a) Insure that all the items in the objects inventory and sales are correct, they all must == 0

2)sellAppleDesserts()
  a) Make sure that for a request to sell some number of items,
      1) the method returns the correct number of items that *can* be sold, as limited by inventory
      2) that number of items is added to sales
      3) that number of items is subtracted from the inventory
  b) Do this for at least these cases
      1) When there is enough inventory to sell the full number requested
      2) When there is not enough inventory to sell the full number requested

*/

import java.util.Arrays;

public class DessertStore {

   public static void main(String[] args) {
      System.out.println("Dessert Store");
      dessertStoreExplanatoryClient();
      }


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
   
      // ---------------------------------------------------------------------------------------------------------
      // Get and show the sales statistics: apple desserts and banana desserts sold as percent of total sales qty
      // ---------------------------------------------------------------------------------------------------------
      double[] salesDist = salesDistributionPercentage(mainStore);
      // total sales is now 2 + 4 = 6, so apple pct is 33.33, banana desserts is 66.67
      System.out.println("Sales, percent of total apple/banana: "
             + String.format("%.2f", salesDist[0]) + "/" + String.format("%.2f", salesDist[1]));
      //  Alternate output syntax:
      //    System.out.printf("fmt Sales, percent of total apple/banana: %.2f/%.2f\n", salesDist[0], salesDist[1]);
   
      }


// ====================================================================
//     T E S T I N G  C O D E  H E R E
//
//      Use this Tester Code.  Do Not Modify it.
//
//      This has additional test code below for arrays
// ====================================================================

   // -----------------------------------------------------------------
   // printCompare() is a Test Method to compare an actual value with an expected value.
   // It prints a result message.
   // It is used as a test method as shown below
   // The result message:
   // - if the actual == expected, prints
   //      [testName]: actual [expected] checked
   //   otherwise prints
   //      *[testName]: Error actual [actual value] != [expected value] (expected)
   // - Examples:
   //     -- Results Match the Expected Value:
   //     int actual = 5 and int expected = 5;
   //     printCompare( actual, expected, "myMethod") prints
   //         myMethod: actual 8 checked
   //
   //     -- Results Do Not Match the Expected Value:
   //     int result = 6 and int expected = 5;
   //     printCompare( result, expected, "myMethod") prints
   //         * myMethod: Error result 6 != 5 (expected)
   // -----------------------------------------------------------------
   public static void printCompare(int actual, int expected, String testName) {
      boolean theyMatch = expected == actual;
      System.out.println(matchMsg(theyMatch, String.valueOf(actual), String.valueOf(expected), testName));
      }

   // printCompare() overload for Strings
   // Adds quotation marks to messages
   // Does not recognize null equality
   public static void printCompare(String actual, String expected, String testName) {
      String comparisonMsg =
             actual == null
                     ? nullComparisonMsg("\"" + expected + "\"", testName)
                     : matchMsg(expected.equals(actual), "\"" + actual + "\"", "\"" + expected + "\"", testName);
      System.out.println(comparisonMsg);
      }

   // Tests one given boolean argument to be true
   public static void printCompare(boolean actual, String testName) {
      printCompare(actual, true, testName);
      }

   // Compares an actual against an expected value
   public static void printCompare(boolean actual, boolean expected, String testName) {
      System.out.println(matchMsg(actual == expected, String.valueOf(actual), String.valueOf(expected), testName));
      }

   // Tests given doubles to be equal or have their relative difference small
   // Compares an actual against an expected value
   public static void printCompare(double actual, double expected, String testName) {
      boolean theyMatch = areClose(actual, expected);
      System.out.println(matchMsg(theyMatch, String.valueOf(actual), String.valueOf(expected), testName));
      }

   // Compares an actual against an expected array
   public static void printCompare(int[] actual, int[] expected, String note) {
      String comprisonMsg =
             actual == null
                     ? nullComparisonMsg(Arrays.toString(expected), note)
                     : arrayComparisonMsg(Arrays.equals(actual, expected), Arrays.toString(actual), Arrays.toString(expected),
                     actual.length, expected.length, note);
      System.out.println(comprisonMsg);
      }

   // Compares an actual against an expected array
   public static void printCompare(boolean[] actual, boolean[] expected, String note) {
      String comparisonMsg = actual == null
             ? nullComparisonMsg(Arrays.toString(expected), note)
             : arrayComparisonMsg(Arrays.equals(actual, expected), Arrays.toString(actual), Arrays.toString(expected),
             actual.length, expected.length, note);
      System.out.println(comparisonMsg);
      }

   // Compares an actual against an expected array
   public static void printCompare(String[] actual, String[] expected, String note) {
      String comparisonMsg = actual == null
             ? nullComparisonMsg(Arrays.toString(expected), note)
             : arrayComparisonMsg(Arrays.equals(actual, expected), Arrays.toString(actual), Arrays.toString(expected),
             actual.length, expected.length, note);
      System.out.println(comparisonMsg);
      }

   // Compares an actual against an expected array
   public static void printCompare(double[] actual, double[] expected, String note) {
      if (actual == null) {
         System.out.println(nullComparisonMsg(Arrays.toString(expected), note));
         return;
         }
   
      boolean areClose = actual.length == expected.length;
      // Check the arrays element by element
      // exit the loop with areClose valid for the whole array
      int iLastChecked = -1;     // last checked index
      while (areClose && iLastChecked < actual.length - 1) {
         iLastChecked++;
         areClose &= areClose(actual[iLastChecked], expected[iLastChecked]);
         }
   
      System.out.println(arrayComparisonMsg(areClose, Arrays.toString(actual), Arrays.toString(expected),
             actual.length, expected.length, note));
      }

   // Returns true if the two given values are equal or are very close
   // To be close, if not equal, either their difference or their "relative difference" must be
   //    less than "RELATIVE_FUZZ".
   // Here, "relative difference" is the absolute value of their difference, divided by the average of
   //    their two absolute values.   This emphasizes relative difference, *except very near zero.*
   private static boolean areClose(double result, double expected) {
      final double RELATIVE_FUZZ = 1e-6;
      final double absDifference = Math.abs(result - expected);
      return result == expected
             || absDifference <= RELATIVE_FUZZ
             || absDifference / ((Math.abs(result) + Math.abs(expected)) / 2) <= RELATIVE_FUZZ;
      }

   // --------
   // Messages
   // --------

   // Returns a message for a null string.  Shows the expected string.
   public static String nullComparisonMsg(String expectedString, String note) {
      return "* " + note + ": Error actual = null != " + expectedString + " expected";
      }

   // Returns a message showing that the actual and expected values match or do not match
   // isMatch determines whether there is a match.
   //     If true then return the match string.
   //     If false then return the no match string.
   public static String matchMsg(boolean isMatch, String actual, String expected, String message) {
      if (isMatch)
         return message + ": actual " + actual + " checked";
      else
         return "* " + message + ": Error actual=" + actual + " != " + expected + " expected";
      }

   // Shows the comparison of two arrays
   // Assumes that neither is null
   public static String arrayComparisonMsg(boolean equals, String actualAsString, String expectedAsString,
                                           int actualLength, int expectedLength, String note) {
      if (equals)
         return note + ": actual " + actualAsString + " checked";
   
      String rslt = "* " + note + ": Error (lengths rslt/exp = " + actualLength + "/" + expectedLength + ")";
      rslt += "\n" + "     actual = \t" + actualAsString;
      rslt += "\n" + "     expected =\t" + expectedAsString;
      return rslt;
      }

   }
