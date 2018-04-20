public class ArenaTest {
    public static void main( String[] args ) {
        Arena myArena = new Arena();
        System.out.println( "The results of 0,1 is: " + myArena.getArea(0,1) );
        System.out.println( "The results of 1,1 is: " + myArena.getArea(1,1) );
        System.out.println( "The results of 1,0 is: " + myArena.getArea(1,0) );
        System.out.println( "The results of 0,0 is: " + myArena.getArea(0,0) );
        System.out.println( "The results of -1,1 is: " + myArena.getArea(-1,1) );
        System.out.println( "The results of 0.5,1 is: " + myArena.getArea(0.5,1) );
        System.out.println( "The results of -1,0.5 is: " + myArena.getArea(-1,0.5) );
    }
}
