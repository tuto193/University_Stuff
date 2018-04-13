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
        StringStack referenceList = referenceCopy( namesList );

        // Shallow copy
        StringStack shallowList = shallowCopy( namesList );

        // Deep copy
        StringStack deepList = deepCopy( namesList );
    }
}
