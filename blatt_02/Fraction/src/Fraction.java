/**
 * This object represents a fraction ( a number with a numerator and a denominator)
 */
public class Fraction {
    /**
     * Object's attributes. A Numerator (top), a denominator (bottom) and a value
     * (the absolut value of the number as decimal)
     */
    private int numerator;
    private int denominator;
    private double value;

    // Erster Teil der Aufgabe

    /**
     * First constructor, assings values to all attributes of the object.
     * 
     * @param num the numerator
     * @param den the denominator
     * @throws RuntimeException if the denominator is 0
     */
    public Fraction( int num, int den ) {
        if( den == 0 ) {
            throw new RuntimeException( "0 is not a valid denominator!");
        } else {
            this.value = num/den;
            this.numerator = num;
            this.denominator = den;
            // Mit der unteren Schleife kürzen wir.
            if( this.denominator > 1 ){
                for( int i = this.denominator; i >= 2; i-- ) {
                    if( this.numerator % i == 0 && this.denominator % i == 0 ) {
                        this.numerator /= i;
                        this.denominator /= i;
                    }
                }
            }
        }

    }

    /**
     * Second constructor, takes just a num numerator and assigns 1 as denominator. It 
     * is linked to the first constructor.
     * 
     * @param num the numerator
     */
    public Fraction( int num ) {
        this( num, 1 );
    }


    /**
     * Returns a Fraction. Adds this Fraction to an addend, by using the rule
     * of the cross.
     * 
     * @param addend the Fraction Object that is being added
     * @return  a Fraction, result of the addition of the original one and addend.
     */
    public Fraction add( Fraction addend ) {
        int a = this.numerator * addend.denominator;
        int b = this.denominator * addend.numerator;
        int c = this.denominator * addend.denominator;
        Fraction result = new Fraction( a + b, c);
        return result;
    }


    /**
     * Returns Fraction result. Substracst a subtrahend from the Fraction Object
     * using the same process like the addition.
     * 
     * @param subtrahen a Fraction to substract with
     * @return  a Fraction, result of substracting subtrahend from the original
     *          Fraction Object
     */
    public Fraction substract( Fraction subtrahend ) {
        int a = this.numerator * addend.denominator;
        int b = this.denominator * addend.numerator;
        int c = this.denominator * addend.denominator;
        Fraction result = new Fraction( a - b, c);
        return result;
    }
    ////////////////////////////////////////////////

    // Zweiter Teil der Aufgabe
    /**
     * Returns a Fraction, result of multiplying this Object with an int factor
     * 
     * @param factor an int that multiplies the fraction
     * @return the result of multiplying the Fractions times the factor
     */
    public Fraction multiply( int factor ) {
        Fraction result = new Fraction( this.numerator * factor, this.denominator );
        return result;
    }

    /**
     * Returns a Fraction that results  after multiplying the original one
     * times another factor Fraction
     * 
     * @param factor a Fraction object
     * @return  another Fraction. The result of multiplying the original times facor. 
     */
    public Fraction multiply( Fraction factor ) {
        Fraction result = new Fraction( this.numerator * factor.numerator,
                                      this.denominator * factor.denominator );
        return result;
    }

    /**
     * Returns a Fraction, result of dividing the original Fraction object by a divisor
     * 
     * @param divisor a Fraction, that will divide our original Fraction object.
     * @return  a Fraction, that is result of the division.
     */
    public Fraction divide( Fraction divisor ) {
        // Division ist genau wie multiplication aber in Kreuz
        // also, wir tauschen den numerator und den denomitanor aus, und
        // multiplizieren wie üblich
        Fraction upsideDown = new Fraction( divisor.denominator, divisor.numerator );
        Fraction result = this.multiply( upsideDown );

        return result;
    }

    /**
     * Returns a Fraction. Does the same like multiply, but just uses an array
     * of Fractions factors, that will multiply our original Fraction Object.
     * 
     * @param factors an array of Fraction Objects.
     * @return      the resulting multiplication of all Fractions times the original.
     */
    public Fraction multiply( Fraction... factors ) {
        Fraction result = new Fraction( this.numerator, this.denominator );

        for( int i = 0; i < factors.length; i++ ) {
            result = result.multiply( factors[ i ] );
        }

        return result;
    }

    /**
     * Returns the Fraction Object as String.
     * 
     * @return  a String that represents the Fraction Object as a/b
     */
    public String toString() {
        String myFraction = "" + this.numerator + "/" + this.denominator;
        return myFraction;
    }

    public Fraction parseFraction( String toParse ) {
        if( !toParse.matches( "-?\\d+/\\d*" ) ) {
            throw new RuntimeException( "Not a fraction!. The input String was" +
             " not a fraction!" );
        }
        String[] myFraction = toParse.split( "/" );
        int numerator = Integer.parseInt( myFraction[0] );
        int denominator = Integer.parseInt( myFraction[1] );
        Fraction result = new Fraction( numerator, denominator );
        return result;
    }
}
