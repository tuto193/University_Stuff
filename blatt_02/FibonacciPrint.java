public class FibonacciPrint {

    public static void FibonacciPrint( String input ) {
        int n = Integer.parseInt(input);
        if( n < 0 ){
            System.err.println( "Only positive numbers (or 0) are allowed!" );
        }
        int a = 0;
        int b = 1;
        int c;
        System.out.println( "| n |  f(n)  |" );
        System.out.println( "+---+--------+" );
        System.out.printf( "|  0|       %d|", a);
        if( n > 0 ) {
            System.out.printf( "|  1|       %d|", b);
        }
        int nacci = 1;
        while( nacci <= n ) {
            c = a + b;
            a = b;
            b = c;
            System.out.printf( "|  %d|       %d|", nacci, b);
            nacci++; 
        }
    }


    public static void main( String[] args ) {
        if( !args[0].matches("\\d") ) {
            System.err.println( "Not a number. You are only allowed to input integers" );
        }
        FibonacciPrint(args[0]);
    }
}