// M9_FunctionComposition.java  rev. 3/3/2020: corrected all expected values in method test_formulaOne()
// rev 3/3/2020 B: changed erroneous comment references from "multiply()" to "mult()". Renamed test_multiply() to test_mult().
import java.util.Arrays;

public class M9_FunctionComposition {
    public static void main(String[] args) {
        test_Compositions();
    }

    private static void test_Compositions() {
        test_multAdd();
        test_mult();
        test_sqare();
        test_add3();
        test_formulaOne();
        test_formulaTwo();
        test_formulaTwoPrime();
        test_polynomial();
    }


    // ==================================================================================
    // Function Composition is important in Computer Science and software development
    // In this assignment we will practice
    //   1) working with the specific functionality that is available
    //   2) using function composition
    // ==================================================================================

    // 1) multAdd(x,b,c): write this method that returns x * y + z
    // This could, for instance, simulate a fast linear arithmetic operation in a CPU or GPU
    public static double multAdd(double x, double y, double z) {
        return -9999;
    }

    public static void test_multAdd() {
        printCompare(multAdd(3, 5, 13), 28, "multAdd(3, 5, 13)");
        printCompare(multAdd(0.71313, -101.331, 4.11137), -68.150806, "multAdd(0.71313, -101.331, 4.11137)");
    }


    // 2)  NOTE - EXAMPLE
    // Note that we can use multAdd() for just adding and multiplying,
    // so if our computer or low-level programming language did not have "*" or "+" operators
    //    or if our target hardware had a very fast multiply and add operation
    // we could use multAdd() to achieve just adding or multiplying, too.
    // For example, to simply add, we can use multAdd() in this way:
    //      x + y  =  1*x + y  =  multAdd(1, x, y)  = x + y
    public static double add(double x, double y) {
        return multAdd(1, x, y);
    }

    // 3) mult(x,y): write this method that returns x * y
    // Use multAdd() only.  Do not use the operators "*", "+", "-", "/", "%"
    public static double mult(double x, double y) {
        return -9999;
    }

    public static void test_mult() {
        printCompare(mult(2, 3), 6, "mult(2, 3)");
        printCompare(mult(0, 3), 0, "mult(0, 3)");
        printCompare(mult(7, 0), 0, "mult(7, 0)");
        printCompare(mult(2.14159, -17.95543), -38.453169, "mult(2.14159, -17.95543)");
        printCompare(mult(0.141593, 1.8413), 0.2607152, "mult(0.141593, 1.8413)");
    }

    // 4) square(x): write this method that returns the square of x
    // Use multAdd() only.  Do not use the operators "*", "+", "-", "/", "%" or mult() or add()
    public static double square(double x) {
        return -9999;
    }

    public static void test_sqare() {
        printCompare(square(0), 0, "square(2)");
        printCompare(square(2), 4, "square(2)");
        printCompare(square(3), 9, "square(2)");
        printCompare(square(-17.95543), 322.3975, "square(-17.95543)");
        printCompare(square(-777.15543), 603970.5624, "square(-777.15543)");
    }

    // 5) add3(x,y,z): write this method that returns x + y + z
    // Use multAdd() only.  Do not use the operators "*", "+", "-", "/", "%" or any other methods
    // Build this from "the inside out": make one addition and then add the other.
    // Try to maintain the order of evaluation
    public static double add3(double x, double y, double z) {
        return -9999;
    }

    public static void test_add3() {
        printCompare(add3(3, 0, 0), 3, "add3(3, 0, 0)");
        printCompare(add3(0, 5, 0), 5, "add3(0, 5, 0)");
        printCompare(add3(0, 0, 11), 11, "add3(0, 0, 11)");
        printCompare(add3(2, 3, 4), 9, "add3(2, 3, 4)");
        printCompare(add3(1.1, -3.41, 4), 1.69, "add3(1.1, -3.41, 4)");
        printCompare(add3(0.002142159, -17.955143, 7715.8811), 7697.92809916, "add3(0.002142159, -17.955143, 7715.8811)");
    }


    // 6) formulaOne(x): write this method that returns x * exp(x) + 5 * PI
    // For exp(x) and PI, use Math.exp() and Math.PI
    // Use only two calls to multAdd().  Do not use the operators "*", "+", "-", "/", "%" or other methods
    public static double formulaOne(double x) {
        return -9999;
    }

    public static void test_formulaOne() {
        printCompare(formulaOne(1), 18.42624509640801, "formulaOne(1)");
        printCompare(formulaOne(-1), 15.340083826777523, "formulaOne(-1)");
        printCompare(formulaOne(2), 30.486075465810266, "formulaOne(2)");
        printCompare(formulaOne(3), 75.96457403751197, "formulaOne(3)");
        printCompare(formulaOne(-1.95543), 15.431262850051272, "formulaOne(-1.95543)");
    }

    // 7) formulaTwo(x,y): write this method that returns x^2 + 3*x*y + y^2
    // Use only multAdd() only.  Do not use the operators "*", "+", "-", "/", "%" or any other methods
    public static double formulaTwo(double x, double y) {
        return -9999;
    }

    public static void test_formulaTwo() {
        printCompare(formulaTwo(0, 0), 0, "formulaTwo(0, 0)");
        printCompare(formulaTwo(2, 0), 4, "formulaTwo(2, 0)");
        printCompare(formulaTwo(0, 3), 9, "formulaTwo(0, 3)");
        printCompare(formulaTwo(2, 3), 31, "formulaTwo(2, 3)");
        printCompare(formulaTwo(7, 10), 359, "formulaTwo(7, 10)");
        printCompare(formulaTwo(2.14159, -17.95543), 211.6243662119, "formulaTwo(2.14159, -17.95543)");
        printCompare(formulaTwo(0.141593, 1.8413), 4.192579840349, "formulaTwo(0.141593, 1.8413)");
    }

    // 8 & 9) formulaTwoPrime(x,y):
    // 8) write this method that returns x^2 + 3* x*y + y^2
    // Use mult() and add().  Do not use the operators "*", "+", "-", "/", "%" or any other methods
    // 9) ==>> After finishing this method, formulaTwoPrime(),
    //  ==>>   add a comment with your thoughts comparing implementing formulaTwo and formulaTwoPrime
    //  ==>>   Address which is easier? Shorter? Which seems more natural?  Which you prefer?
    public static double formulaTwoPrime(double x, double y) {
        return -9999;
    }


    public static void test_formulaTwoPrime() {
        printCompare(formulaTwoPrime(0, 0), 0, "formulaTwoPrime(0, 0)");
        printCompare(formulaTwoPrime(2, 0), 4, "formulaTwoPrime(2, 0)");
        printCompare(formulaTwoPrime(0, 3), 9, "formulaTwoPrime(0, 3)");
        printCompare(formulaTwoPrime(2, 3), 31, "formulaTwoPrime(2, 3)");
        printCompare(formulaTwoPrime(7, 10), 359, "formulaTwoPrime(7, 10)");
        printCompare(formulaTwoPrime(2.14159, -17.95543), 211.6243662119, "formulaTwoPrime(2.14159, -17.95543)");
        printCompare(formulaTwoPrime(0.141593, 1.8413), 4.192579840349, "formulaTwoPrime(0.141593, 1.8413)");
    }


    // 10 & 11) polynomial(double x, double a, double b, double c, double d):
    //  10)   write this method that returns the polynomial a*x^3 + b*x^2 + c*x + d
    // Use only mult() and add().  Do not use the operators "*", "+", "-", "/", "%" or any other methods
    // 11) ==>> After finishing this method, polynomial(),
    // ==>>  add a comment here with YOUR thoughts comparing your implementation with the
    // ==>>        method in fastPolynomial() below
    // ==>>  Which might be preferred? In which circumstances might each be preferred?
    public static double polynomial(double x, double a, double b, double c, double d) {
        return -9999;
    }

    // Fast factorization and implementation of the evaluation of a polynomial
    //  This is a very fast way to calculate a polynomial in one variable: ((a*x + b) * x + c) * x + d
    public static double fastPolynomial(double x, double a, double b, double c, double d) {
        return multAdd(x, multAdd(x, multAdd(a, x, b), c), d);
    }

    public static void test_polynomial() {
        printCompare(polynomial(0, 2, 3, 7, 11), 11, "polynomial(0, 2,3,7,11)");
        printCompare(polynomial(1, 0, 0, 7, 0), 7, "polynomial(1, 0,0,7,0)");
        printCompare(polynomial(1, 0, 3, 0, 0), 3, "polynomial(1, 0,3,0,0)");
        printCompare(polynomial(1, 2, 0, 0, 0), 2, "polynomial(1, 2,0,0,0)");
        printCompare(polynomial(1, 17, 0, 0, 0), 17, "polynomial(1, 17,0,0,0)");
        printCompare(polynomial(3, 2, 3, 7, 11), 113, "polynomial(3, 2,3,7,11)");
        printCompare(polynomial(-3, 5, 11, 17, 23), -64, "polynomial(-3, 5,11,17,23)");
        printCompare(polynomial(3.13, 2.31, -3.3, 7.1, 11.57), 72.297756, "polynomial(3.13, 2.31,-3.3,7.1,11.57)");
        // fastPolynomial
        printCompare(fastPolynomial(0, 2, 3, 7, 11), 11, "fastPolynomial(0, 2,3,7,11)");
        printCompare(fastPolynomial(1, 0, 0, 7, 0), 7, "fastPolynomial(1, 0,0,7,0)");
        printCompare(fastPolynomial(1, 0, 3, 0, 0), 3, "fastPolynomial(1, 0,3,0,0)");
        printCompare(fastPolynomial(1, 2, 0, 0, 0), 2, "fastPolynomial(1, 2,0,0,0)");
        printCompare(fastPolynomial(1, 17, 0, 0, 0), 17, "fastPolynomial(1, 17,0,0,0)");
        printCompare(fastPolynomial(3, 2, 3, 7, 11), 113, "fastPolynomial(3, 2,3,7,11)");
        printCompare(fastPolynomial(-3, 5, 11, 17, 23), -64, "fastPolynomial(-3, 5,11,17,23)");
        printCompare(fastPolynomial(3.13, 2.31, -3.3, 7.1, 11.57), 72.297756, "fastPolynomial(3.13, 2.31,-3.3,7.1,11.57)");
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