public class AssertingTest {
    
    public static void printErrorCheck( String whatError, boolean passed, int testNumber ) {
        if( passed ) {
            System.out.println( "The check on " + whatError + " at " + testNumber + " was a PASS." );
        } else {
            System.out.println( "The function FAILS at " + whatError + ", here: " + testNumber );
        }
    }

    public static void main( String[] args ) {
        Person firstPerson = new Person("Jesus" );
        Person secondPerson = new Student( "Jesus ", 1);
        Student firstStudent = new Student( "Jesus ", 1);
        // We test first if it's reflexive!
        boolean test1 = firstPerson.equals(firstPerson);
        boolean test2 = secondPerson.equals(secondPerson);
        boolean test3 = firstStudent.equals(firstStudent);
        //
    }
}