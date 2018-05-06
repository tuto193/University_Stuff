/**
 * Just a test class
 */
public class AssertingTest {
    /**
     * Prints out whether the test of whatError passed, with the corresponding testNumber
     * 
     * @param whatError String of the type of error check
     * @param passed boolean of the result a previously made test
     * @param testNumber String of the number that identifies the test of its type
     */
    public static void printErrorCheck( String whatError, boolean passed, String testNumber ) {
        if( passed ) {
            System.out.println( "The check on " + whatError + " at " + testNumber + " was a PASS." );
        } else {
            System.out.println( "The function FAILS at " + whatError + ", here: " + testNumber );
        }
    }

    /**
     * Prints the corresponding sentence, for the type of test being made. (With a max of 3 people)
     * 
     * @param persons an array of Person Ojbects
     * @throws RuntimeException if called with 4 or more Person Obcejts
     */
    public static void printTest( Person... persons ) {
        System.out.print("Test " + persons[0] );
        if( persons.length == 2 ) {
            System.out.println( " against " + persons[1] );
        } else if( persons.length == 3 ) {
            System.out.println( " through " + persons[1] + " up to " + persons[2] );
        } else if( persons.length > 3 ) {
            throw new RuntimeException("We can only test a maxmimum of 3 persons at a time! " );
        }
    }

    /**
     * Returns true if a is equals to itself
     * 
     * @param a a Person Object
     * @return true if a is equals to itself
     */
    public static boolean checkReflex( Person a ) {
        return a.equals(a);
    }

    /**
     * Returns true, if a and b are equal and viceversa
     * 
     * @param a a Person Object
     * @param b another Person Object
     * @return true if a, b are equal and viceversa
     */
    public static boolean checkSymm( Person a, Person b ) {
        return a.equals(b) == b.equals(a);
    }

    /**
     * Returns true if a to c through b are transitive when compared
     * 
     * @param a a Person Object
     * @param b second Person Object
     * @param c the last Person Object
     * @return true if a to c through b is transitive when compared
     */
    public static boolean checkTrans( Person a, Person b, Person c ) {
        return a.equals(b) == b.equals(c) && b.equals(c) == a.equals(c);
    }

    /**
     * Prints whether or not two tests have equal results (their consistency)
     * 
     * @param test1 boolean of the first test made
     * @param test2 boolean of the second test made 
     */
    public static void checkCons( boolean test1, boolean test2 ) {
        if( test1 == test2 ) {
            System.out.println( "The function is consistent! " );
        } else {
            System.out.println( "The function is NOT consisten!" );
        }
    }

    public static void main( String[] args ) {
        Person firstPerson = new Person("Jesus" );
        Person secondPerson = new Student( "Jesus ", 1);
        Student firstStudent = new Student( "Jesus ", 1);
        Person thirdPerson = firstStudent;
        
        // We test first if it's reflexive!
        boolean Reflextest2 = checkReflex(firstPerson);
        boolean Reflextest1 = checkReflex(secondPerson);
        boolean Reflextest3 = checkReflex(firstStudent);
        boolean Reflextest4 = checkReflex(thirdPerson);

        printTest( firstPerson );
        printErrorCheck("Reflexion", Reflextest2, "2");
        printTest( secondPerson );
        printErrorCheck("Reflexion", Reflextest1, "1");
        printTest( firstStudent );
        printErrorCheck("Reflexion", Reflextest3, "3");
        printTest( thirdPerson );
        printErrorCheck("Reflexion", Reflextest4, "4");
        
        // We then test whether they are actually symmetric!
        boolean symmTest1 = checkSymm(firstPerson, secondPerson);
        boolean symmTest2 = checkSymm(firstPerson, firstStudent);
        boolean symmTest3 = checkSymm(secondPerson, firstStudent);
        boolean symmTest4 = checkSymm(firstPerson, thirdPerson);
        boolean symmTest5 = checkSymm(secondPerson, thirdPerson);
        boolean symmTest6 = checkSymm(firstStudent, thirdPerson);

        printTest( firstPerson, secondPerson );
        printErrorCheck("Symmetry", symmTest1, "1");
        printTest( firstPerson, firstStudent );
        printErrorCheck("Symmetry", symmTest2, "2");
        printTest( secondPerson, firstStudent );
        printErrorCheck("Symmetry", symmTest3, "3");
        printTest( firstPerson, thirdPerson );
        printErrorCheck("Symmetry", symmTest4, "4");
        printTest( secondPerson, thirdPerson );
        printErrorCheck("Symmetry", symmTest5, "5");
        printTest( firstStudent, thirdPerson );
        printErrorCheck("Symmetry", symmTest6, "6");

        // Then we also Test whether the comparison is also transitive
        boolean transTest1 = checkTrans(firstPerson, secondPerson, thirdPerson);
        boolean transTest2 = checkTrans(firstPerson, thirdPerson, firstStudent);
        boolean transTest3 = checkTrans(secondPerson, firstStudent, firstPerson);
        boolean transTest4 = checkTrans(firstPerson, firstStudent, secondPerson);
        boolean transTest5 = checkTrans(secondPerson, firstStudent, thirdPerson);
        boolean transTest6 = checkTrans(thirdPerson, firstPerson, secondPerson);

        printTest(firstPerson, secondPerson, thirdPerson);
        printErrorCheck("Transition", transTest1, "1");
        printTest(firstPerson, thirdPerson, firstStudent);
        printErrorCheck("Transition", transTest2, "2");
        printTest(secondPerson, firstStudent, firstPerson);
        printErrorCheck("Transition", transTest3, "3");
        printTest(firstPerson, firstStudent, secondPerson);
        printErrorCheck("Transition", transTest4, "4");
        printTest(secondPerson, firstStudent, thirdPerson);
        printErrorCheck("Transition", transTest5, "5");
        printTest(thirdPerson, firstPerson, secondPerson);
        printErrorCheck("Transition", transTest6, "6");
        
        // We also need to check halfway through for consistency
        boolean symmTest12 = checkSymm(firstPerson, secondPerson);
        boolean symmTest22 = checkSymm(firstPerson, firstStudent);
        boolean symmTest32 = checkSymm(secondPerson, firstStudent);
        boolean symmTest42 = checkSymm(firstPerson, thirdPerson);
        boolean symmTest52 = checkSymm(secondPerson, thirdPerson);
        boolean symmTest62 = checkSymm(firstStudent, thirdPerson);

        printTest( firstPerson, secondPerson );
        checkCons( symmTest1, symmTest12 );
        printTest( firstPerson, firstStudent );
        checkCons( symmTest2, symmTest22 );
        printTest( secondPerson, firstStudent );
        checkCons( symmTest3, symmTest32 );
        printTest( firstPerson, thirdPerson );
        checkCons( symmTest4, symmTest42 );
        printTest( secondPerson, thirdPerson );
        checkCons( symmTest5, symmTest52 );
        printTest( firstStudent, thirdPerson );
        checkCons( symmTest6, symmTest62 );
    }
}