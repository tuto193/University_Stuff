package OpenHashing;

import OpenHashing.OpenHasher;

public class HashingTest {

    public static void testMethod( String methodName, boolean expectedOutcome, boolean actualOutcome ) {
        if( expectedOutcome != actualOutcome ) {
            throw new RuntimeException(" The method " +
            methodName + " failed.")
        }
    }

    public static void main( String[] args ) {
        OpenHasher testSubject = new OpenHasher();

        String testObjects = "test";

        String test1 = testObjects + 1;
        String test2 = "test";
        String test3 = new String("test"); 
        String test4 = test2;
        String test5 = test2 + testObjects;

        // Here we can already asume that test 2 and test4 are equal, and therefore they should share the same
        // HASH CODE... therefore they should be stored in the same index/list inside the array.
        boolean TEST1 = testSubject.insert(testObjects);    // true because first
        boolean TEST2 = testSubject.insert(test1);          // true...
        boolean TEST3 = testSubject.insert(test2);          // I think false
        boolean TEST4 = testSubject.insert(test3);          // true, because new string
        boolean TEST5 = testSubject.insert(test4);          // false
        boolean TEST6 = testSubject.insert(test5);          // true


    }
}