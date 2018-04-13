public class TestingMethodes{

    public static void main( String[] args ) {
        // These are our originals
        String myName = "Carlos";
        String hisName = "Fabian";
        String anotherName = "Gong";
        StringStack namesList = new StringStack( myName );
        namesList.push( hisName );
        namesList.push( anotherName );

        // Reference copy
        //StringStack referenceList = new StringStack( namesList );

        // Shallow copy
        //StringStack shallowList = new StringStack( namesList );

        // Deep copy
        StringStack deepList = new StringStack( namesList );

        /*
            Hier wollen wir Testen, ob es eingentlich um eine Deep-Copy handelt!
        */
        if( deepList == namesList ) {
            throw new RuntimeException( "Es ist eine Reference Copy!" );
        } else if( deepList.first == namesList.first ) {
            throw new RuntimeException( "Es ist eine Shallow Copy " );
        } else if( deepList.first.equals( namesList.first ) ) {
            throw new RuntimeException( "Es ist eine DEEP COPY! " );
        }
    }
}
