public class Fibonacci {
    /**
     * This class holds/is the Fibonacci sequence and will keep track of the last
     * number in the sequence generated.
     * <p>
     * The sequence is made by adding a and b, a then becomes b
     *  and b becomes their sum.
     */
    private int a = 0;
    private int b = 1;

    /**
     * Class constructor
     */
    public Fibonacci() {}

    /**Returns the next int value in the Fibonacci sequence (one number
     * higher, every time it's called).
     * <p>
     * This method will add a and b together. While a then is assigned the
     * starting value of b, b is assigned the result of the sum.
     * 
     * @param a the first of the numbers on the actual sequence
     * @param b the second of the numbers in the actual sequence
     * @return value of the next number in the sequence.
     */
    public int next() {
        int c = this.a + this.b;
        this.a = this.b;
        this.b = c;
        return this.b;
    }
}