package Aufgabe3;
/**
 * A class representing a simple library
 * @author Carlos A. Parra F.
 */
public class Library {

    private List myItems;
    /**
     * The Constructor, doesn't requiere much
     */
    public Library () {}

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
     * Returns a List of items, whose titles, authors, 
     * directors or descriptions match the given text.
     * 
     * @param text a String against which the List of items
     *             of this library will be searched.
     * @return matchingItems a List of items, that match
     *          the description given on text.
     */
    public List search( String text ) {
        return matchingItems;
    }
}