package src;
/**
 * Every instance of Fraction represents a fraction with numerator and
 * denominator.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fraction extends Number {

   /**
	 * Auto-generated serialVersionUID by Eclipse. 
	 */
	private static final long serialVersionUID = 9130319389134688989L;

/**
    * The regular expression that defines the String representation of a
    * Fraction, a Decimal or a Natural number.
    */
   public static final String REGEX_FRACTION = "-?\\d+/\\d*[1-9]\\d*";

   /**
    * Creates greatest common divisor for a and b.
    * 
    * @param a
    * @param b
    * @return the greatest common divisor for a and b.
    */
   public static int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);

   }

   /**
    * Parses a Fraction from a String by using REGEX. Throws RuntimeException if String s does
    * not contain valid Fraction.
    * 
    * @param s
    *           String to be parsed
    * @return parsed String as Fraction
    * @throws RuntimeException
    *            if String s is not a valid Fraction
    */
   public static Fraction parseFraction(String s) {
      if (!s.matches(REGEX_FRACTION) && !s.matches(Calculator.REGEX_DECIMAL) && !s.matches(Calculator.REGEX_NATURAL) ) {
         throw new RuntimeException("Parsing error");
      }
      if( s.matches(REGEX_FRACTION) ) {
            String[] splitted = s.split("/");
            return new Fraction(Integer.parseInt(splitted[0]),
                  Integer.parseInt(splitted[1]));
      } else if( s.matches( Calculator.REGEX_DECIMAL ) ) {
            String[] splitted = s.split( "." );
            int newDenominator = 1;
            for( int i = 0; i < splitted[2].length(); i++ ) {
                  newDenominator *= 10;
            }
            return new Fraction( Integer.parseInt( splitted[0] + splitted[2] ), newDenominator );
      }
      return new Fraction( Integer.parseInt(s), 1 );
   }

   private int numerator;

   private int denominator;

   /**
    * Creates a Fraction object with numerator and denominator 1, cancels the
    * fraction with creation.
    * 
    * @param numerator
    */
   public Fraction(int numerator) {
      this(numerator, 1);
   }

   /**
    * Creates a Fraction object with numerator and denominator, cancels the
    * fraction by creation. Denominator == 0 is not allowed.
    * 
    * @param numerator
    * @param denominator
    */
   public Fraction(int numerator, int denominator) {
      if (denominator == 0) {
         throw new RuntimeException("denominator == 0 is not possible");
      }

      /*
       * creates greatest common divisior.
       */
      int gcd = Fraction.gcd(numerator, denominator);
      /*
       * check sign, make denominator positive
       */
      if (denominator / gcd < 0) {
         gcd *= -1;
      }

      this.numerator = numerator / gcd;

      this.denominator = denominator / gcd;
   }

   /**
    * Adds addend to this Fraction and return the result as a new Fraction.
    * 
    * @param addend
    *           Fraction to be added
    * @return the sum as a new Fraction
    */
   public Fraction add(Fraction addend) {
      return new Fraction(this.numerator * addend.denominator
            + this.denominator * addend.numerator, this.denominator
            * addend.denominator);
   }

   /**
    * Divides this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to divide this Fraction by
    * @return quotient as a new Fraction
    */
   public Fraction divide(Fraction another) {
      return new Fraction(this.numerator * another.denominator,
            this.denominator * another.numerator);
   }

   /**
    * 
    * @return denominator of this Fraction
    */
   public int getDenominator() {
      return this.denominator;
   }

   /**
    * 
    * @return numerator of this Fraction
    */
   public int getNumerator() {
      return this.numerator;
   }

   /**
    * Multiplies this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction another) {
      return new Fraction(this.numerator * another.numerator, this.denominator
            * another.denominator);
   }

   /**
    * Multiplies this Fraction with n.
    * 
    * @param n
    *           factor to multiply with
    * @return product as a new Fraction
    */
   public Fraction multiply(int n) {
      return new Fraction(this.numerator * n, this.denominator);
   }

   /**
    * Multiplies this Fraction with all other Fraction instances given by
    * factors
    * 
    * @param factors
    *           Fraction instances to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction... factors) {
      Fraction result = this;
      for (int i = 0; i < factors.length; i++) {
         result = result.multiply(factors[i]);
      }
      return result;
   }
   
   /**
    * Subtracts subtrahend from this Fraction an returns the result as a new
    * Fraction.
    * 
    * @param subtrahend
    *           to be subtracted Fraction
    * @return the difference as a new Fraction
    */
   public Fraction subtract(Fraction subtrahend) {
      return new Fraction(this.numerator * subtrahend.denominator
            - this.denominator * subtrahend.numerator, this.denominator
            * subtrahend.denominator);
   }


   /**
    * Returns a string representation of this Fraction such as
    * numerator/denominator.
    * 
    * @return This Fraction as a String
    */
   public String toString() {
      return numerator + "/" + denominator;
   }

   ///////////////////////////////////////////////////////////////////////////
   ////////////////                   ////////////////////////////////////////
   //////////////// BEGIN AUFGABE 4.1 ////////////////////////////////////////
   ////////////////                   ////////////////////////////////////////
   ///////////////////////////////////////////////////////////////////////////
   /**
    * Returns the int value of this Fraction Object
    * 
    * @return the int value of this Fraction
    */
   public int intValue() {
         return (int) (this.numerator / this.denominator);
   }

   /**
    * Returns the double value of this Fraction Object
    * 
    * @return the double value of this Fraction.
    */
   public double doubleValue() {
         return (double) (this.numerator / this.denominator);
   }

   /**
    * Returns the float value of this Fraction Object.
    * 
    * @return the float value of this Fraction
    */
   public float floatValue() {
         return (float) (this.numerator / this.denominator);
   }

   /**
    * Returns the long value of this Fraction Object.
    *
    * @return the long value of this Fraction
    */
   public long longValue() {
         return (long) (this.numerator / this.denominator);
   }

}
