public class FibonacciTest {
    public static void main( String[] args ) {
        Fibonacci number = new Fibonacci();
        System.out.println("The first next " + number.next() );
        System.out.println("The second next " + number.next() );
        System.out.println("The third next " + number.next() );
        System.out.println("The fourth next " + number.next() );
        System.out.println("The fifth next " + number.next() );
        System.out.println("The sixth next " + number.next() );
        System.out.println( "And it does indeed remember... look" );
        System.out.println("The seventh " + number.next() );
    }
}
