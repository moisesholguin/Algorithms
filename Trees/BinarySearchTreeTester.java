
import java.io.*;
import java.util.*;

////////////////////////////////////////////////////////////////
//                                                            //
//             BinarySearchTreeTester class                   //
//                                                            //
////////////////////////////////////////////////////////////////

public class BinarySearchTreeTester {    
    static int FAILED_TESTS = 0;

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Test: Empty Tree Size
        int numTest = 1;
        String testName = "Empty Tree Size";
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(bst.size() == 0);

        // Test: Empty Tree Contains
        numTest++;
        testName = "Empty Tree Contains";
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(!bst.contains(4));

        // Test: Empty Tree Height
        numTest++;
        testName = "Empty Tree Height";
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(bst.height() == -1);

        // Test: Empty Tree Min
        numTest++;
        testName = "Empty Tree Min";
        System.out.println("Test " + numTest + ": " + testName);
        try {
            bst.min();
            showTestResults(false);
        }
        catch(Exception ex) {
            showTestResults(true);
        }

        // Test: Empty Tree Max
        numTest++;
        testName = "Empty Tree Max";
        System.out.println("Test " + numTest + ": " + testName);
        try {
            bst.max();
            showTestResults(false);
        }
        catch(Exception ex) {
            showTestResults(true);
        }

        // Test: Empty Tree HasPathSum
        numTest++;
        testName = "Empty Tree HasPathSum(0)";
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(bst.hasPathSum(0));

        // Test: Empty Tree HasPathSum
        numTest++;
        testName = "Empty Tree HasPathSum(1)";
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(!bst.hasPathSum(1));

        // Test: Insert
        numTest++;
        testName = "Insert 7 nums";
        /* Should be:
         *              5
         *            /   \
         *           3     9
         *          / \   / \
         *         1   4 6   12
         */
        bst.insert(5);
        bst.insert(3);
        bst.insert(9);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(12);
        System.out.println("Test " + numTest + ": " + testName);
        showTestResults(bst.size() == 7);
        
        displaySummary(numTest);
    }

    private static void showTestResults(boolean passed) {
        if(!passed) FAILED_TESTS++;
        String result = passed ? "[PASSED]" : "******** [FAILED]";
        System.out.println(result);
    }

    private static void displaySummary(int n) {
        System.out.println("========== SUMMARY ==========");
        System.out.println("Total Tests: " + n);
        System.out.println("     Passed: " + (n-FAILED_TESTS));
        System.out.println("     Failed: " + FAILED_TESTS);
        System.out.println("=============================");
    }
}
