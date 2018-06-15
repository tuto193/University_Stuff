package Aufgabe1;

import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;

/**
 * A simple Test of some of the JavaCollections
 * 
 * @author Carlos A. Parra F.
 */
public class CollectionTest {
    /**
     * Global variables, to adjust to our testing needs
     */
    static int objectNumber = 10000;
    static int emptyTests = 10;
    static int cellWidth = 14;
    static boolean seeValues = false;

    /**
     * Draws the top row of a simple table
     * 
     * @param rowName the name of the row (or title)
     * @param results a list of Strings, containing all results to be displayed in the cells
     */
    public static void makeTopRow( String rowName, String[] results ) {
        // Draw the top
        for( int i = 0; i < 4; i++ ) {
            System.out.print("+");
            for( int j = 0; j < cellWidth; j++ ) {
                System.out.print("-");
                if( j == cellWidth - 1 && i == 3 ) {
                    System.out.println("+");
                }
            }
        }
        makeRow(rowName, results);
    }

    /**
     * Draws middle and bottom rows of a simple table
     * 
     * @param rowName the name of the row (or title)
     * @param results a list of Strings containing all results to be displayed in the cells
     */
    public static void makeRow( String rowName, String[] results ) {
        
        // Draw the middle part
        for( int i = 0; i < 4; i++ ) {
            System.out.print("|");
            int spacing;
            if( i == 0 ) {
                spacing = cellWidth - rowName.length();
            } else {
                spacing = cellWidth - results[ i - 1 ].length();
            }
            // Throw some space in between
            for( int j = 0; j < spacing; j++ ) {
                System.out.print(" ");
            }
            // Print the cell name accordingly
            if( i == 0 ) {
                System.out.print( rowName );
            } else {
                System.out.print( results[i - 1]);
            }
            if( i == 3 ) {
                System.out.println("|");
            }
        }
        // Draw the bottom
        for( int i = 0; i < 4; i++ ) {
            System.out.print("+");
            for( int j = 0; j < cellWidth; j++ ) {
                System.out.print("-");
                if( j == cellWidth - 1 && i == 3 ) {
                    System.out.println("+");
                }
            }
        }
    }

    /**
     * A Small (basically useless) print Function, that prints a small description of our test
     */
    public static void printTest( String description ) {
        System.out.println( "We are showing now the " + description );
    }
    
    /**
     * Returns a String of values (separated with a comma), with the min, average and max values based on an array of values
     * 
     * @param array an array of longs, containing the elements that will be checked
     * @param range the range we want to check the array within a particular range
     * @return string of values with the resulting velues
     * @throws RunTimeException if range is longer than the array's length
     */
    public static String testAverages( long[] array, int range ) {
        if( range > array.length ) {
            throw new RuntimeException("The range cannot be longer than the array's length" );
        }
        long max = array[0], min = array[0], average = 0;

        for( int i = 0; i < range; i++ ) {
            if( array[i] > max ) {
                max = array[i];
            }
            if( array[i] < min ) {
                min = array[i];
            }
            average += array[i];
        }
        average = average/range;

        return "" + min + "," + average + "," + max;
    }

    /**
     * A Sequence of tests made on the LinkedList collection
     * 
     * @param seeValues if true, it will also show all the individual values from the tests made
     */
    public static void nanoTest( Collection<String> testList ) {
        printTest( "Tests for " + testList.getClass().getSimpleName() );
        long[] times = new long[objectNumber];
        
        //// ADD Testing starts HERE /////////////////////////
        for( int i = 0; i < times.length; i++ ) {
            String pushIn = "" + i;
            long start = System.nanoTime();
            testList.add(pushIn);
            long result = System.nanoTime() - start;
            times[i] = result; 
        }

        // We willl check the input times of the whole
        String[] addResults = testAverages( times, times.length ).split(",");



        ///// CONTAINS Testing starts HERE ///////////
        Random rand = new Random();
        // The last 10 Tests, will check for elements that don't exist
        // within the collection ( can be changed by modifying variable emptyTests)
        long[] containTests = new long[ objectNumber / 20 ];

        for( int i = 0; i < containTests.length; i++ ) {
            int randomCheck;
            if( i < containTests.length - emptyTests ) {
                randomCheck = rand.nextInt(objectNumber);
            } else {
                randomCheck = rand.nextInt(objectNumber) + objectNumber;
            }
            long start = System.nanoTime();
            testList.contains("" + randomCheck );
            long result = System.nanoTime() - start;
            containTests[i] = result;
        }

        // we will print the tests here
        String[] containsResults = testAverages( containTests, containTests.length - emptyTests ).split(",");


        ///// REMOVE Testing starts HERE /////////////////////

        long[] removeTests = new long[objectNumber];

        for( int i = 0; i < removeTests.length; i++ ) {
            long start = System.nanoTime();
            testList.remove("" + i );
            long result = System.nanoTime() - start;
            removeTests[i] = result;
        }

        String[] removeResults = testAverages(removeTests, removeTests.length).split(",");

        String[] firstRow = {"MIN", "AVEAGE", "MAX"};
        makeTopRow( testList.getClass().getSimpleName(), firstRow );
        makeRow("add()", addResults);
        makeRow("contains()", containsResults);
        makeRow("remove()", removeResults);
        if( seeValues ) {
            System.out.println("This are all of the add() Times");
            for( int i = 0; i < times.length; i++ ) {
                System.out.println( times[i] );
            }
        }

        if( seeValues ) {
            System.out.println("These are all the contains() times: ");
            for( int i = 0; i < containTests.length; i++ ) {
                if( i < containTests.length - emptyTests ) {
                    System.out.println("Actual test: " + containTests[i] );
                } else {
                    System.out.println("Empty test: " + containTests[i] );
                }
            }
        }

        if( seeValues ) {
            System.out.println("These are all the remove() times: ");
            for( int i = 0; i < removeTests.length; i++ ) {
                System.out.println( removeTests[i] );
            }
        }
    }

    public static void main( String[] args ) {
        LinkedList<String> myList = new LinkedList<String>();
        ArrayList<String> myArray = new ArrayList<String>();
        HashSet<String> myHashSet = new HashSet<String>();
        nanoTest( myList );
        nanoTest( myArray );
        nanoTest( myHashSet );
    }
}
