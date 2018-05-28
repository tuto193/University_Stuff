package OpenHashing;

import OpenHashing.OpenHasher;
/**
 * A simple set of tests for the OpenHasher class.
 * 
 * @author Carlos A. Parra F.
 */
public class HashingTest {

    /**
     * Checks a test's results against its expected outcome., and provides an output
     * accordingly. Throws a RuntimeException should the tests fail.
     * 
     * @param testName a String describing the name of the test, for easy tracking
     * @param expectedOutcome the expected outcome of the test
     * @param actualOutcome the actual outcome of the test.
     * @throws RuntimeException if the outcomes don't match
     */
    public static void testMethod( String testName, boolean expectedOutcome, boolean actualOutcome ) {
        if( expectedOutcome != actualOutcome ) {
            throw new RuntimeException("The test " +
            testName + " failed.");
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
        boolean TEST3 = testSubject.insert(test2);          // false
        boolean TEST5 = testSubject.insert(test4);          // false
        boolean TEST6 = testSubject.insert(test5);          // true

        // Based on the results of the first tests, then all following tests should have the exact same results (same boolean values)
        boolean containTest1 = testSubject.contains(testObjects);
        boolean containTest2 = testSubject.contains(test1);
        boolean containTest3 = testSubject.contains(test2);
        boolean containTest4 = testSubject.contains(test3);
        boolean containTest5 = testSubject.contains(test4);
        boolean containTest6 = testSubject.contains(test5);

        boolean deleteTest1 = testSubject.delete(testObjects);
        boolean deleteTest2 = testSubject.delete(test1);
        boolean deleteTest3 = testSubject.delete(test2);
        boolean deleteTest4 = testSubject.delete(test3);
        boolean deleteTest5 = testSubject.delete(test4);
        boolean deleteTest6 = testSubject.delete(test5);

        testMethod("TEST1", true, TEST1);
        testMethod("TEST2", true, TEST2);
        testMethod("TEST3", false, TEST3);
        testMethod("TEST4", false, TEST4);
        testMethod("TEST5", true, TEST5);
        testMethod("TEST6", true, TEST6);

        testMethod("containTest1", TEST1, containTest1);
        testMethod("containTest2", TEST2, containTest2);
        testMethod("containTest3", TEST3, containTest3);
        testMethod("containTest4", TEST4, containTest4);
        testMethod("containTest5", TEST5, containTest5);
        testMethod("containTest6", TEST6, containTest6);

        testMethod("deleteTest1", TEST1, deleteTest1);
        testMethod("deleteTest2", TEST2, deleteTest2);
        testMethod("deleteTest3", TEST3, deleteTest3);
        testMethod("deleteTest4", TEST4, deleteTest4);
        testMethod("deleteTest5", TEST5, deleteTest5);
        testMethod("deleteTest6", TEST6, deleteTest6);
    }
}