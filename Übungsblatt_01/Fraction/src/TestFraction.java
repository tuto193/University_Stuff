public class TestFraction {

    // Diese Methode zeigt einfach, dass es einen Fehler gab.
    public static void blackHole() {
        throw new RuntimeException(" Es gab einen Fehler hier \n | \n V")
    }

    // Ich habe keine Lust mehr, SYSTEM.OUT.PRINTLN einzutippen....
    public static void println( String toPrint ) {
        System.out.println( toPrint );
    }

    public static void testFraction( Fraction toTest, String methodName ) {
        if( toTest != null ) {
            println( toTest.toString() );
        } else{
            blackHole();
            println(methodName);
        }
    }
    public static void main( String[] args ) {

        Fraction myNumber1 = new Fraction( 1 );
        testFraction( myNumber1, "First Constructor" );

        Fraction myNumber2 = new Fraction( 1, 4 );
        testFraction( myNumber2, "Second Constructor" );

        Fraction multiplied = myNumber1.multiply( myNumber2 );
        testFraction( multiplied, "Result from Multiplication with Fraction par " );

        Fraction timesInt = myNumber2.multiply( 40 );
        testFraction( timesInt, "Multiplication with int parameter " );

        Fraction divided = myNumber1.divide( myNumber2 );
        testFraction( divided, "Division" );

        System.out.println(divided.toString() );
        println( "We are just testing the toString methode here");

        Fraction holyMoly = timesInt.multiply( myNumber1, myNumber2, multiplied,
                                        divided );
        testFraction( holyMoly, "Multiplication with an array of fractions " );

    }
}
