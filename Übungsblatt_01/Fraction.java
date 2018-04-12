public class Fraction {
    private int numerator;
    private int denominator;
    private double value;

    // Erster Teil der Aufgabe
    public Fraction( int num, int den ) {
        this.denominator = den;
        Fraction( num );
    }
    public Fraction( int num ) {
        if( this.denominator == NULL ) {
            this.denomitanor = 1;
        }
        this.numerator = num;
        this.value = this.numerator / this.denominator;
    }
    ////////////////////////////////////////////////

    // Zweiter Teil der Aufgabe
    // Wir erzeugen eine neue Fraction mit denselben Werten zur Ausrechnung
    public Fraction multiply( int factor ) {
        Fraction result = new Fraction( this.numerator * factor, this.denominator );
        return result;
    }

    // dasselbe wie oben, aber mit einer Fraction
    public Fraction multiply( Fraction factor ) {
        Fraction result = new Fraction( this.numerator * factor.numerator,
                                      this.denominator * factor.denominator );
        return result;
    }

    // Wir teilen unsere Fraction durch eine Andere, und erzeugen eine neue Fraction
    public Fraction divide( Fraction divisor ) {
        // Division ist genau wie multiplication aber in Kreuz
        // also, wir tauschen den numerator und den denomitanor aus, und
        // multiplizieren wie üblich
        Fraction upsideDown = new Fraction( divisor.denominator, divisor.numerator );
        Fraction result = new Fraction( this.multiply( upsideDown ) );

        return result;
    }

    // hier brauchen wir eine Schleife, um alle "factors" mit der Fraction
    // zu miltiplizieren und am Ende wird das Ergebnis "result" zurückgegeben.
    public Fraction multiply( Fraction... factors ) {
        Fraction result = new Fraction( this.numerator, this.denominator );

        for( int i = 0; i < factors.length; i++ ) {
            result = result.multiply( factors[ i ] );
        }

        return result;
    }

    // Diese Methode gibt diese Fraction als STRING aus (a / b)
    public String toString() {
        String myFraction = "" + this.numerator + "/" + this.denominator;
        return myFraction;
    }

    // Jetzt muss man das alles nur testen!
}
