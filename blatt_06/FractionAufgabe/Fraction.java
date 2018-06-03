package FractionAufgabe;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Every instance of Fraction represents a fraction with numerator and
 * decorator.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fraction extends Number {

   /**
    * The regular expression that defines the String representation of a
    * Fraction.
    */
   public static final String REGEX = "-?\\d+/[1-9]\\d*";

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
    * Parses a Fraction from a String by using REGEX. Throws RuntimeException if
    * String s does not contain valid Fraction.
    * 
    * @param s
    *           String to be parsed
    * @return parsed String as Fraction
    * @throws RuntimeException
    *            if String s is not a valid Fraction
    */
   public static Fraction parseFraction(String s) {
      if (!s.matches(REGEX)) {
         throw new RuntimeException("Parsing error");
      }
      String[] splitted = s.split("/");
      return check(new Fraction(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));
   }

   private int numerator;

   private int denominator;

   
   private static HashSet<Fraction> set;
   
   /*
    * Klasse die überprüft, ob der Bruch schon in der Hashset ist
    * Ist der Bruch schon in der Liste, gibt er die alte Referenz zurück
    * sonst fügt er diese zur Liste hinzu und gibt die neue Referenz zurück
    */
   
   public static Fraction check(Fraction frac) {

	   Fraction tmp = null;

	   for (Iterator<Fraction> it = set.iterator(); 
			   it.hasNext(); ) {
		   tmp = it.next();
		   if (frac.doubleValue() == tmp.doubleValue()) {
			   return tmp; 
		   }
	   } 
	   set.add(frac);
	   return frac;
   }

   /**
    * Creates a Fraction object with numerator and denominator 1, cancels the
    * fraction with creation.
    * 
    * @param numerator
    */
   private Fraction(int numerator) {
      this(numerator, 1);
   }

   /**
    * Creates a Fraction object with numerator and denominator, cancels the
    * fraction by creation. Denominator == 0 is not allowed.
    * 
    * @param numerator
    * @param denominator
    */
   private Fraction(int numerator, int denominator) {
      if (denominator == 0) {
         throw new RuntimeException("denominator == 0 is not possible");
      }
      /*
       * Alle Fractions werden im selben HashSet abgelegt.
       */
      if (set == null) set = new HashSet();
      
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
   
   public static Fraction newFraction(int numerator) {
	   return newFraction(numerator, 1);
   }

   /*
    * haben check hinzugefügt, um die Referenz nicht neu zu erstellen bei new Fraction
    */
   
   public static Fraction newFraction(int numerator, int denominator) {
	   return check(new Fraction(numerator, denominator));
   }
   
   /**
    * Adds addend to this Fraction and return the result as a new Fraction.
    * 
    * @param addend
    *           Fraction to be added
    * @return the sum as a new Fraction
    */
   public Fraction add(Fraction addend) {
      return new Fraction(this.numerator * addend.denominator + this.denominator * addend.numerator, this.denominator * addend.denominator);
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
      return new Fraction(this.numerator * another.numerator, this.denominator * another.denominator);
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
    *           to be substracted Fraction
    * @return the difference as a new Fraction
    */
   public Fraction substract(Fraction subtrahend) {
      return new Fraction(this.numerator * subtrahend.denominator - this.denominator * subtrahend.numerator, this.denominator * subtrahend.denominator);
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

   @Override
   public int intValue() {
      return (int) (doubleValue() + 0.5);
   }

   @Override
   public long longValue() {
      return (long) (doubleValue() + 0.5);
   }

   @Override
   public float floatValue() {
      return (float) doubleValue();
   }

   @Override
   public double doubleValue() {
      return (double) this.getNumerator() / (double) this.getDenominator();
   }
}
