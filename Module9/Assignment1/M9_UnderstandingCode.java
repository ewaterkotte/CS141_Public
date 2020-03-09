import java.util.Scanner;

public class M9_UnderstandingCode {

   public static void main(String[] args) {
      System.out.println("Average of 5 and 7 is: " + average(new int[]{5, 7}));
      System.out.println("Average of 5 and 6 is: " + average(new int[]{5, 6}));
      System.out.println("Average of 5, 6, 7 and 8 is: " + average(new int[]{5, 6, 7, 8}));
      System.out.println("Max of 6, 7, 8, 9 is: " + maximum(new int[]{6, 7, 8, 9}));
      System.out.println("Max of -6, -7, -8, -9 is: " + maximum(new int[]{-6, -7, -8, -9}));
      donateWithMultiplication(1000);
      }

//   ========================================================================
//    This method has several issues.
//    It calculates some averages incorrectly: look at the reported outputs
//     1) Find and fix the problems and improve the code to conform to our Conventions
//     2) Add a comments above the method describing the fixes and why.
//   ========================================================================

   // Calculates and returns the average value of the elements in data[]
   // data[] must have at least one element
   public static double average(int[] data) {
      int sum = 0;
      int Count = 0;
      if ( sum >= 0 ){
         for ( int i=0; i < data.length -1; i++) {
            sum = data[i];
            Count++;
            }
         }
      return sum / Count;
      }

//  ========================================================================
//    This method has issues.
//    It miscalculates some maxima: look at the reported outputs.
//    1) Find and fix the problems and improve the code to conform to our Conventions
//    2) Add comments above the method describing the fixes and why.
//  ========================================================================

   // Calculates and returns the maximum value of the elements in data[]
   // data[] must have at least one element
   public static int maximum(int[] data) {
      int min = 0;
      int Count = 0;
      for ( int i=0; i < data.length -1; i++) {
         if (data[i] > min){
            min = data[i];
            Count++;
            }
         }
      return min;
      }

// ===================================================================================================================
//  Purpose of this problem:
//    Use and practice/develop skills in understanding code, stepping through code, being able to understand
//      well enough to express the intent simply.
//  Requirements (the goal):
//    Improve this code without changing how it appears to the user, and add an additional multiplier, 4.
//         Requirements:
//     - Improve the code provided below
//     - Add the additional multiplier 4
//     - Do not change the user interaction or the output to the user-except to add the 4 as a multiplier.
//     - Add comments to the code to show its structure.
//     - Remove unnecessary repeated code, redundancy, logical complexity.
//     - Make it as simple as possible.
//     - Make it conform to our Coding Conventions
//  Evaluation:
//    The code will be evaluated on its correctness, how little redundancy/repetition remains in the code,
//    its simplicity, readability, lack of anything unnecessary, and the clarity of the code and its logic,
//    and conformance with our Coding Conventions.
//  Suggestions:
//     - Above all, keep the purpose of the code in mind (see General purpose of the code section below).
//     - Divide the code into sections, but keep it simple.
//     - Improve variable names if warranted.
//     - Make a copy of this method below (or above) itself with a slightly different name.  
//         Use the original method as a reference.
//         But *be sure that you don't confuse the two.*  Be sure to make the changes where you want them!
//  General purpose of the code:
//     - From a starting balance, add a multiplied-donation and display a new balance.
//     - The user's donation must be multiplied by 1, 2, or 3 (and 4 after the updates) before adding to the balance.
//     - The donation and its multiplier are supplied by the user.
// ===================================================================================================================
   
   // From a starting balance, add a multiplied-donation and display a new balance.
   // The user's donation must be multiplied by 1, 2, or 3 (and 4 after the updates) before adding to the balance.
   // The donation and its multiplier are supplied by the user.
   public static void donateWithMultiplication(int StartAmount) {
      int total = StartAmount;
      Scanner console = new Scanner(System.in);
      System.out.println("Donation.  Starting Balance: " + StartAmount);
      System.out.println("Is your donation multiplied by 1, 2, or 3? ");
      console = new Scanner(System.in);
      int times = console.nextInt();
      boolean inputIsOk = true;
      boolean inputIsBad = false;
      if (times == 0)
         inputIsBad = true;
         else if (times == 1)
            inputIsOk = true;
            else if (times == 2)
              inputIsOk = true;
              else if (times == 3)
                 inputIsOk = true;
         else
            inputIsOk = false;
      if (inputIsBad || !inputIsOk) {
         System.out.println("Exit from donateWithMultiplication(): bad number for times");
         return;
      } else if (times == 1) {
         int count = 0; int sum = 0;
         System.out.println("How much are you donating? ");
         int donation = console.nextInt();
         sum = sum + donation * 1;
         count++;
         total = total + sum;
         System.out.println("The new balance is " + total);
         return;
      } else if (times == 2) {
         int count = 0;
         int sum = 0;
         System.out.println("How much are you donating? ");
         int donation = console.nextInt();
         sum = total;
         int totalDonation = donation * 2;
         count++;
         System.out.println("The new balance is " + (sum + totalDonation));
         return;
      } else if (times == 3) {
         int count = 0;
         int sum = 0;
         System.out.println("How much are you donating? ");
         int donation = console.nextInt();
         sum = sum + donation * 3;
         int totalDonation = donation * 3;
         count++;
         total += sum;
         System.out.println("The new balance is " + total);
         return;
      } else {
         System.out.println("Error from donateWithMultiplication(): bad number for times");
         return;
         }
      }
   }