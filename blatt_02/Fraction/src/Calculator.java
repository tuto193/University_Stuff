import java.util.regex.Pattern;

public class Calculator {
    public static final String MYREGEX = "-?\\d*/\\d*\\s+[\\+\\-\\*/]\\s+-?\\d*/\\d*\\s?"; 

    public static void calculate( String input ) {
        if( !input.matches(MYREGEX) ) {
            throw new RuntimeException( "No fractions and operator. Two" 
            +"fractions separated by an operator and a space in"
            + " between then is needed" );
        }
        String[] myOperation = input.split("\\s");
        String operator = myOperation[1];

        Fraction first = Fraction.parseFraction( myOperation[0] );
        Fraction second = Fraction.parseFraction( myOperation[2] );

        switch(operator) {
            case "+": {
                System.out.print(first.add(second) + "\n");
                break;
            }
            case "-": {
                System.out.print(first.substract(second) + "\n");
                break;
            }
            case "*": {
                System.out.print(first.multiply(second) + "\n");
                break;
            }
            case "/": {
                System.out.print(first.divide(second) + "\n");
                break;
            }
            default: {
                System.err.print( "Didn't use a valid operation. Ony '+', '-'. '/', '*' allowed" + "\n");
                break;
            }
        }
    }

    public static void main( String[] args ) {
        String input = new String();
        for( int i = 0; i < args.length; i++ ) {
            input += args[i] + " ";
        }

        if( !input.matches(MYREGEX) ) {
            System.err.print( "No fractions and operators.The input arguments are not allowed.\n");
        } else {
            calculate( input );
        }
    }
}