public class Calculator {
    public static final String MYREGEX = "-?\\d+/\\d*\\s[\\+\\-\\*/]\\s-?\\d+/\\d*";

    public static void calculate( String input ) {
        if( !input.matches(MYREGEX) ) {
            throw new RuntimeException( "No fractions and operator. Two" 
            +"fractions separated by an operator and a space in"
            + " between then is needed" );
        }
        String[] myOperation = input.split("\\s");
        String[] firstFraction = myOperation[0].split("/");
        String[] secondFraction = myOperation[2].split("/");
        String operator = myOperation[1];

        int num1 = Integer.parseInt(firstFraction[0]);
        int den1 = Integer.parseInt(firstFraction[1]);
        int num2 = Integer.parseInt(secondFraction[0]);
        int den2 = Integer.parseInt(secondFraction[1]);

        Fraction first = new Fraction(num1,den1);
        Fraction second = new Fraction(num2,den2);

        switch(operator) {
            case "+": {
                System.out.print(first.add(second));
            }
            case "-": {
                System.out.print(first.substract(second));
            }
            case "*": {
                System.out.print(first.multiply(second));
            }
            case "/": {
                System.out.print(first.divide(second));
            }
            default: {
                System.err.print( "Didn't use a valid operation. Ony '+', '-'. '/', '*' allowed");
            }
        }
    }

    public static void main( String[] args ) {
        if( !args[0].matches(MYREGEX) ) {
            System.err.print( "No fractions and operators.The input arguments are not allowed.\n");
        } else {
            calculate( args[0] );
        }
    }
}