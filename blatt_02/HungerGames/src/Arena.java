/**
 * May the odds be ever in your favour
 * @author Carlos Parra
 */
public class Arena {
    /**
     * The maximum radius of our arena. Anything bigger than that is ourside the
     * boundaries
     */
    private static double arenaR = 1.5;

    /**
     * Returns int Sector of a tribute based on his x and y coordinates
     * in relation to the centre of the arena.
     * 
     * @param x horizontal coordinate of tribute
     * @param y vertical coordinate of tribute
     * @return either the current sector of the tribute (1-12), -1 if out of boundaries
     * or 0 if he/she is in the centre of the arena.
     */
    public int getArea( double x, double y ) {
        double tributeH = Math.sqrt( (x * x) + (y * y) );
        if( tributeH > arenaR ) {
            return -1;
        }
        if( tributeH == 0 ) {
            // The tribute is in the exact centre of the arena
            return 0;
        } 
        /**
         * The angular position to a point is equals to the sum of the resulting
         * angles in the following cases:
         * x >= 0 && y >= 0
         *      alpha = acos + asin - atan
         * x < 0 && y >= 0
         *      alpha = acos - asin - atan
         * x < 0 && y < 0
         *      alpha = acos - asin + atan
         * x >= 0 && y < 0
         *      alpha = acos + asin + atan
         */
        double asin = Math.asin( y / tributeH );
        double acos = Math.acos( x / tributeH );
        double atan;
        double alpha;
        if( x == 0 ) {
            atan = 0;
            acos = 0;
        } else {
            atan = Math.atan( y / x );
        }
        
        if( x >= 0 ) {
            if( y >= 0 ) {
                alpha = acos + asin - atan;
            } else {
                alpha = acos + asin + atan;
            }
        } else {
            if( y >= 0 ) {
                alpha = acos - asin - atan;
            } else {
                alpha = acos - asin + atan;
            }
        }
        // We need not a reference from the normal (1,0), but from ( 0, 1)
        alpha = (180/Math.PI) * alpha;
        alpha = alpha - 90;
        return 12 - (int) ( ( (alpha + 360) % 360) / 30);
    }
}