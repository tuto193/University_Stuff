public class TestMethodes{

    public static void main( String[] args ) {
        // These are our originals
        String myName = "Carlos";
        String hisName = "Fabian";
        String anotherName = "Gong";
        StringStack namesList = new StringStack();
        namesList.push( myName );
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
        if( deepList.peek() == namesList.peek() ) {
            throw new RuntimeException( "Es ist eine Shallow Copy " );
        } else if( deepList.peek().equals( namesList.peek() ) ) {
            throw new RuntimeException( "Es ist eine DEEP COPY! " );
        }
    }
}
