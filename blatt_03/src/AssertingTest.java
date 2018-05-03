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

        printErrorCheck("Reflexion", Reflextest2, "2");
        printErrorCheck("Reflexion", Reflextest1, "1");
        printErrorCheck("Reflexion", Reflextest3, "3");
        printErrorCheck("Reflexion", Reflextest4, "4");
        
        // We then test whether they are actually symmetric!
        boolean symmTest1 = checkSymm(firstPerson, secondPerson);
        boolean symmTest2 = checkSymm(firstPerson, firstStudent);
        boolean symmTest3 = checkSymm(secondPerson, firstStudent);
        boolean symmTest4 = checkSymm(firstPerson, thirdPerson);
        boolean symmTest5 = checkSymm(secondPerson, thirdPerson);
        boolean symmTest6 = checkSymm(firstStudent, thirdPerson);

        printErrorCheck("Symmetry", symmTest1, "1");
        printErrorCheck("Symmetry", symmTest2, "2");
        printErrorCheck("Symmetry", symmTest3, "3");
        printErrorCheck("Symmetry", symmTest4, "4");
        printErrorCheck("Symmetry", symmTest5, "5");
        printErrorCheck("Symmetry", symmTest6, "6");

        // Then we also Test whether the comparison is also transitive
        boolean transTest1 = checkTrans(firstPerson, secondPerson, thirdPerson);
        boolean transTest2 = checkTrans(firstPerson, thirdPerson, firstStudent);
        boolean transTest3 = checkTrans(secondPerson, firstStudent, firstPerson);
        boolean transTest4 = checkTrans(firstPerson, firstStudent, secondPerson);
        boolean transTest5 = checkTrans(secondPerson, firstStudent, thirdPerson);
        boolean transTest6 = checkTrans(thirdPerson, firstPerson, secondPerson);

        printErrorCheck("Transition", transTest1, "1");
        printErrorCheck("Transition", transTest2, "2");
        printErrorCheck("Transition", transTest3, "3");
        printErrorCheck("Transition", transTest4, "4");
        printErrorCheck("Transition", transTest5, "5");
        printErrorCheck("Transition", transTest6, "6");
    }
}