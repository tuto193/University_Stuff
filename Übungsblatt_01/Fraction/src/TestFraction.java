public class TestFraction {

    // Diese Methode zeigt einfach, dass es einen Fehler gab.
    public static void blackHole() {
        System.out.println( "OMG, es gab einen FEHLER HIER! \n|\nv" );
    }
    public static void main( String[] args ) {
        Fraction myNumber1 = new Fraction( 9 );
        Fraction myNumber2 = new Fraction( 39, 7 );
        Fraction multiplied = myNumber1.multiply( myNumber2 );
        Fraction timesInt = myNumber2.multiply( 40 );
        Fraction divided = myNumber1.divide( myNumber2 );
        System.out.println(divided.toString() );
        Fraction holyMoly = timesInt.multiply( myNumber1, myNumber2, multiplied,
                                        divided );


        blackHole();
    }
}
