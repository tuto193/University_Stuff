package Aufgabe3;

import javax.management.RuntimeErrorException;

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

    /**
     * The library can also be instantiated with an item already
     */
    public Library( LibraryItem item ) {
        this.inventory.append(item); 
    }

    /**
     * Adds item to the myItems List of this Library
     * 
     * @param item a LibraryItem Object
     */
    public void addItem( LibraryItem item ) {
        this.inventory.append(item);
    }

    /**
     * Deletes the given item from the Library's inventory
     */
    public void deleteItem( LibraryItem item ) {
        // if the Library's inventory is empty, you might as well not check it
        if( !inventory.isEmpty() ){
            // a temporary list and a list of items that match the description given
            List tmpList = new List(null);

            // We want our loop limit to be a static number that won't be accidentally changed in the loop
            int loopLimit = inventory.getLength();

            // Check all the items inside the inventory, matching items will be terminated
            // matchingItems
            for( int i = 0; i < loopLimit; i++ ) {
                if( inventory.getHead().equals(item) ) {
                    inventory.pop();
                } else {
                    // We need to empty our inventory into the temporaryList in order to advance
                    tmpList.prepend( inventory.pop() );
                }
            }        
            // Make sure that our inventory is just as it was before
            this.inventory = tmpList;
        }
    }

    /**
     * Returns a List of items, whose description
     * matches the given text. (IT DOES NOT CHECK WHETHER THE ITEM IS AVAILABLE)
     * 
     * @param text a String against which the List of items
     *             of this library will be searched.
     * @return matchingItems a List of items, that match
     *          the description given on text.
     */
    public List search( String text ) {
        // if the Library's inventory is empty, you might as well not check it
        if( inventory.isEmpty() ) {
            return null;
        }
        // a temporary list and a list of items that match the description given
        List tmpList = new List(null);
        List matchingItems = new List( null);

        // We want our loop limit to be a static number that won't be accidentally changed in the loop
        int loopLimit = inventory.getLength();

        // Check all the items inside the inventory, matching items will be copied over to the
        // matchingItems
        for( int i = 0; i < loopLimit; i++ ) {
            // I could change it to look better directly from the abstract
            // class itself, and check for directors and all that...
            // but I won't, in order to not risk my points ='(
            if( ( (Book) inventory.getHead() ).getDescription().toLowerCase().contains( text.toLowerCase() ) ) {
                matchingItems.prepend( inventory.getHead() );
            } else if( ( (BluRay) inventory.getHead() ).getDescription().toLowerCase().equals( text.toLowerCase() ) ) {
                matchingItems.prepend( inventory.getHead() );
            }
            // We need to empty our inventory into the temporaryList in order to advance
            tmpList.prepend( inventory.pop() );
        }        
        // Make sure that our inventory is just as it was before
        this.inventory = tmpList;

        return matchingItems;
    }
}