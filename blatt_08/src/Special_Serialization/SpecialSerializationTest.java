package Special_Serialization;

public class SpecialSerializationTest {
    public static void main( String[] args ) {
        OpenHashSet<String> test = new OpenHashSet<String>();

        String o0 = "0";
        String o1 = "1";
        String o2 = "2";
        String o3 = "3";
        String o4 = "4";
        String o5 = "5";
        System.out.println( "Haven't added anything" );
        System.out.println( test.testEmpty() );
        test.insert( null );
        System.out.println( "Added Null object" );
        System.out.println( test.testEmpty() );
        System.out.println();



    }
}
