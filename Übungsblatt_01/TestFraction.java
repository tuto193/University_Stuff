public class TestFraction {

    // Diese Methode zeigt einfach, dass es einen Fehler gab.
    public static void blackHole() {
        System.out.println( "OMG, es gab einen FEHLER HIER! \n|\nv" );
    }
    public static void main( String[] args ) {
        Fraction myNumber1 = new Fraction( 9 );
        Fraction myNumber2 = new Fraction( myNumber1 );
        blackHole();
    }
}
