/**
 * Class outputs a list of numbers from the Fibonacci sequence in order
 * from the first one (0) until the input value.
 */
public class FibonacciPrint {
    /**
     * Constants that define some REGular EXperssions
     */
    public static final String regexINT = "-?\\d+";
    public static final String regexNUMBER = "-?[0-9]+\\.?\\d*";

    /**
     * Prints out the Fibonacci sequence from 0 until input. Only ints bigger or
     * equal to 0 are allowed as input.
     * 
     * @param input a number bigger or equal to 0
     * @return nothing. It just prints out a list of numbers from the Fibonacci Sequence
     * @throws RuntimeException if input is not a natural number.
     */
    public static void print( String input ) {
        if( !input.matches("\\d+") ){
            if( !input.matches(regexINT) ) {
                throw new RuntimeException("Not an integer. Only integers are allowed as input" );
            } else if( !input.matches(regexNUMBER) ) {
                throw new RuntimeException( "Not a Number. Only numbers are allowed as input" );
            }
        }
        int n = Integer.parseInt(input);
        if( n < 0 ){
            throw new RuntimeException( "Not a natural number. Only positive numbers (or 0) are allowed!" );
        }
        int a = 0;
        int b = 1;
        int c;
        System.out.println( "|  n |  f(n)   |" );
        System.out.println( "+---+--------+" );
        System.out.printf( "|   0|        %d|\n", a);
        if( n > 0 ) {
            System.out.printf( "|   1|        %d|\n", b);
        }
        int nacci = 2;
        while( nacci <= n ) {
            c = a + b;
            a = b;
            b = c;
            String iteration = ""+ nacci;
            String fiboNumber = "" + b;
            int whitespace1 = iteration.length();
            int whitespace2 = fiboNumber.length();
            iteration = "";
            fiboNumber = "";
            for( int i = 0; i < 4 - whitespace1; i++ ) {
                iteration += " ";
            }
            for( int j = 0; j < 9 - whitespace2; j++ ) {
                fiboNumber += " ";
            }
            iteration += nacci;
            fiboNumber += b;
            System.out.printf( "|%s|%s|\n", iteration, fiboNumber);
            nacci++; 
        }
    }

    /**
     * Expects a positive whole numbers and gives a list of numbers of
     * the Fibonacci Sequence until the input value (the Nth Fibonacci number)
     * 
     * @param args at position 0: the Natural Number.
     */
    public static void main( String[] args ) {
        if( !args[0].matches("\\d+") ) {
            System.err.println( "Not a natural number. Only positive numbers (or 0) are allowed!" );
        } else if( !args[0].matches(regexINT) ) {
            System.err.println("Not an integer. Only integers are allowed as input" );
        } else if (!args[0].matches(regexNUMBER) ) {
            System.err.println( "Not a number. You are only allowed to input integers" );
        } else {
            print(args[0]);
        }
    }
}