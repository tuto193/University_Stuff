public class Fibonacci {
    /**
     * This class holds/is the Fibonacci sequence and will keep track of the last
     * number in the sequence generated.
     * <p>
     * The sequence is made by adding fiboA and b, fiboA then becomes fiboB
     *  and fiboB becomes their sum.
     */
    private int fiboA = 0;
    private int fiboB = 1;

    /**
     * Class constructor
     */
    public Fibonacci() {}

    /**Returns the next int value in the Fibonacci sequence (one number
     * higher, every time it's called).
     * <p>
     * This method will add fiboA and fiboB together. While fiboA then is assigned the
     * starting value of fiboB, fiboB is assigned the result of the sum.
     * 
     * @return value of the next number in the sequence.
     */
    public int next() {
        int c = this.fiboA + this.fiboB;
        this.fiboA = this.fiboB;
        this.fiboB = c;
        return this.fiboB;

    }
}