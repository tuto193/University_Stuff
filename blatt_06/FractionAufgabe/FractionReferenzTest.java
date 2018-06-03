package FractionAufgabe;


public class FractionReferenzTest {
	
	public static void main(String[] args) {
		
		
		System.out.println("Testing the class Fraction");
		Fraction f7 = Fraction.newFraction(1, 3);
		Fraction f1 = Fraction.parseFraction("1/3");
		Fraction f3 = Fraction.parseFraction("2/6");

		System.out.println("Testing parseFraction:");
		if(f7 != f1 ) {
			System.out.println("Fail");}
			else {
				System.out.println("True");
			}
		System.out.println("Testing if the Reference is the same of two different numbers:");
		if(f7 != f3 ) {
			System.out.println("Fail, different reference");}
			else {
				System.out.println("True, 1/3 have the same reference like 2/6");
		}
	}
}
	

