package Aufgabe1;

import java.util.LinkedList;
import java.util.Random;

public class CollectionTest {
    // With how many objects do we want to test
    static int objectNumber = 1000;
    static int emptyTests = 10;

    public static void printTest( String description ) {
        System.out.println( "We are showing now the " + description );
    }
    
    public static void testAverages( long[] array, int range ) {
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

        printTest("max, min and average times.");
        System.out.println( "Maximum: " + max );
        System.out.println( "Minimum: " + min );
        System.out.println( "Average: " + average );
    }

    public static void nanoTestList( boolean seeValues ) {
        printTest( "List" );
        LinkedList<String> testList = new LinkedList<String>();
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
        System.out.println("These is the add() method"); 
        testAverages( times, times.length );

        if( seeValues ) {
            System.out.println("This are all of the add() Times");
            for( int i = 0; i < times.length; i++ ) {
                System.out.println( times[i] );
            }
        }

        ///// ADD Testing finishes HERE ///////////////

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
        System.out.println("We test now the contains() method ");
        testAverages( containTests, containTests.length - emptyTests );

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

        ///// CONTAINS Testing finishes HERE /////////////////

        ///// REMOVE Testing starts HERE /////////////////////

    }

    public static void main( String[] args ) {

    }
}
