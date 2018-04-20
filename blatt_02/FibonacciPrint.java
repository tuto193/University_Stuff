public class FibonacciPrint {
    public static final String regexINT = "-?\\d+";
    public static final String regexNUMBER = "-?[0-9]+\\.?\\d*";

    /**
     * Prints out the Fibonacci sequence from 0 until input. Only ints bigger or
     * equal to 0 are allowed as input.
     */
    public static void print( String input ) {
        if( !input.matches(regexNUMBER) ) {
            throw new RuntimeException( "Not a Number. Only numbers are allowed as input" );
        } else if( !input.matches(regexINT) ) {
            throw new RuntimeException("Not an integer. Only integers are allowed as input" );
        }
        int n = Integer.parseInt(input);
        if( n < 0 ){
            throw new RuntimeException( "Not a natural number. Only positive numbers (or 0) are allowed!" );
        }
        int a = 0;
        int b = 1;
        int c;
        System.out.println( "| n |  f(n)  |" );
        System.out.println( "+---+--------+" );
        System.out.printf( "|  0|       %d|\n", a);
        if( n > 0 ) {
            System.out.printf( "|  1|       %d|\n", b);
        }
        int nacci = 2;
        while( nacci <= n ) {
            c = a + b;
            a = b;
            b = c;
            System.out.printf( "|  %d|       %d|\n", nacci, b);
            nacci++; 
        }
    }


    public static void main( String[] args ) {
        if( !args[0].matches(regexNUMBER) ) {
            System.err.println( "Not a number. You are only allowed to input integers" );
        } else if( !args[0].matches(regexINT) ) {
            System.err.println("Not an integer. Only integers are allowed as input" );
        } else if (!args[0].matches("\\d") ) {
            System.err.println( "Not a natural number. Only positive numbers (or 0) are allowed!" );
        } else {
            print(args[0]);
        }
    }
}