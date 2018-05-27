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

        String testObjects = "Test Object number ";

        for( int i = 0; i < 500; i ++ ) {
            String objectSet = testObjects + ( i % 13 );
            testSubject.insert(objectSet);
        }



    }
}