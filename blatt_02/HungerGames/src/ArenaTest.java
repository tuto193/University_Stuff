public class ArenaTest {
    /**
     * The method takes an x and y coordinate, an expected value and a result
     * It will test the expected against the result and give errors accordingly
     * Otherwise, it will just print result with its given coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @param expected the expected result from the operation
     * @param result the actual resulting value of the operation
     * @throws RuntimeException if the expected and result are not equal
     */
    public static void autoTest( double x, double y, int expected, int result ) {
        if( expected != result ) {
            throw new RuntimeException("At ("+x+","+y +") expected to be at "+expected+
                    ", but is at "+result );
        }
        if( result > 0 ){
            System.out.printf( "Tribute in (%f,%f) is in Area %d\n", x, y, result );
        } else if( result < 0 ) {
            System.out.printf( "Tribute died in (%f,%f) :( \n", x, y );
        } else {
            System.out.println( "Tribute is RIGHT in the centre of the arena" );
        }
    }

    public static void main( String[] args ) {
        Arena myArena = new Arena();

        int test1 = myArena.getArea( 0, 1 ); // up
        int test2 = myArena.getArea( 0, 0 ); // centre
        int test3 = myArena.getArea( 1.5, 1.5 ); // top right corner            
        int test4 = myArena.getArea( 1, 1 ); // 2?
        
        autoTest(0, 1, 12, test1);
        autoTest(0, 0, 0, test2);
        autoTest(1.5, 1.5, -1, test3);
        autoTest(1, 1, 2, test4);
        
        int width = 32;
        int height = 32;
        int[][] myArea = new int[width][height];

        // Here we put all values in the array to draw the circle later
        for( int i = 0; i < width; i++ ) {
            for( int j = 0; j < height; j++ ) {
                double coorX = ((double) i - 15)/ 10;
                double coorY = ((double) 15 - j)/ 10;
                int sector = myArena.getArea( coorX, coorY );
                myArea[i][j] = sector;
                System.out.printf("At [%f,%f] is the tribute in area: %d\n", coorX, coorY, sector );
            }
        }


        // Here is where we draw the circle
        for( int i = 0; i < height; i++ ) {
            for( int j = 0; j < width; j++ ) {
                String check = "" + myArea[j][i];
                String secondCheck = "";
                if( check.length() == 1 ) {
                    secondCheck += "  " + check;
                } else if( check.length() == 2 ) {
                    secondCheck += " " + check;
                }
                System.out.print(secondCheck );
                if( j == width - 1 ) {
                    System.out.println();
                }
            }
        }
    }
}
