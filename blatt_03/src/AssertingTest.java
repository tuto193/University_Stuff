public class AssertingTest {
    
    public static void printErrorCheck( String whatError, boolean passed, String testNumber ) {
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
        boolean Reflextest2 = secondPerson.equals(secondPerson);
        boolean Reflextest1 = firstPerson.equals(firstPerson);
        boolean Reflextest3 = firstStudent.equals(firstStudent);
        // We then test whether they are actually symmetric!
        boolean symmTest1 = firstPerson.equals(secondPerson) && secondPerson.equals(firstPerson);
        boolean symmTest2 = firstPerson.equals(firstStudent) && firstStudent.equals(firstPerson);
        boolean symmTest3 = secondPerson.equals(firstStudent) && firstStudent.equals(secondPerson);
        // Then we also Test whether the comparisson is also transtitive
        //  from firstPerson to first Student
        boolean transTest1 = firstPerson.equals(secondPerson) && secondPerson.equals(firstStudent) && firstPerson.equals(firstStudent);
        boolean transTest2 = secondPerson.equals(firstStudent) && firstStudent.equals(firstPerson) && secondPerson.equals(firstPerson);


    }
}