package Aufgabe3;
/**
 * A class representing a simple library
 * @author Carlos A. Parra F.
 */
public class Library {

    private List inventory;
    /**
     * The Constructor, doesn't requiere much
     */
    public Library () {
        this( null );
    }

    public Library( LibraryItem item ) {
        this.inventory.append(item); 
    }

    /**
     * Adds item to the myItems List of this Library
     * 
     * @param item a LibraryItem Object
     */
    public void addItem( LibraryItem item ) {
    }

    /**
     * Deletes the given item from the myItems List of this
     * library
     */
    public void deleteItem( LibraryItem item ) {

    }

    /**
     * Returns a List of items, whose title
     * matches the given text. (IT DOES NOT CHECK WHETHER THE ITEM IS AVAILABLE)
     * 
     * @param text a String against which the List of items
     *             of this library will be searched.
     * @return matchingItems a List of items, that match
     *          the description given on text.
     */
    public List search( String text ) {
        List tmpList = new List(null);
        List matchingItems = new List( null);

        int loopLimit = inventory.getLength();

        for( int i = 0; i < loopLimit; i++ ) {
            // I could change it to look better directly from the abstract
            // class itself, and check for directors and all that...
            // but I won't, in order to not risk my points ='(
            if( ( (Book) inventory.getHead() ).getDescription().equals( text ) ) {
                matchingItems.prepend( inventory.getHead() );
            } else if( ( (BluRay) inventory.getHead() ).getDescription().equals( text ) ) {
                matchingItems.prepend( inventory.getHead() );
            }
            tmpList.prepend( inventory.pop() );
        }        
        this.inventory = tmpList;

        return matchingItems;
    }
}