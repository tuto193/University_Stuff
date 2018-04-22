import java.util.regex.Pattern;

/**
 * This is just a test class for our fractions, to make sure that all operations
 * work from the command line and that the user input is well parsed.
 */
public class Calculator {
    /**
     * Just a global regex, for parsing the desired user input
     */
    public static final String MYREGEX = "-?\\d*/\\d*\\s+[\\+\\-\\*/]\\s+-?\\d*/\\d*\\s?"; 

    /**
     * This method will just take an input String, which should contain an
     * operation between two fractions. It will split the input accordingly,
     * do the operation chosen by the user, then output the result.
     * 
     * @param input a String, which should contain two Fractions and an operator
     *              (+, -, /, *)
     * @throws RuntimeException if the input String does not contain exactly two
     *          Fractions, a valid operation in between them,
     *           and a space separating them from each other.
     */
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

    /**
     * There is the user input read from the command line and checked for the
     * first time against the regex. This will warn the user if the input string
     * is valiud or not.
     * 
     * @throws System.err if the user does not input a String in the valid format.
     */
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