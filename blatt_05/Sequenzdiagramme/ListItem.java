package Aufgabe3;
/**
 * A simple class that represents all the items on our List
 * 
 * @author Carlos A. Parra F.
 */
public class ListItem {
    /**
     * next: the item after this one
     * value: the LibraryItem pointed at by this ListItem
     */
    private ListItem next;
    private LibraryItem value;

    /**
     * A simple Constructor
     */
    public ListItem ( LibraryItem item ) {
        this( item, null );
    }

    /**
     * the more verbose constructor
     */
    public ListItem( LibraryItem item, ListItem next ) {
        this.next = next;
        this.value = item;
    }

    /**
     * Sets the value of this item's next attribute, to next (the parameter)
     * 
     * @param next the ListItem that will become the attribute next of this item
     */
    public void setNext( ListItem next ) {
        this.next = next;
    }

    /**
     * Returns the current next ListItem pointed at by this item
     * 
     * @return this.next ListItem that is pointed at by this one
     */
    public ListItem getNext() {
        return this.next;
    }

    /**
     * Set the value of the LibraryItem value that is being pointed at by this ListItem
     */
    public void setValue( LibraryItem value ) {
        this.value = value;
    }

    /**
     * Returns the value LibraryItem of this ListItem
     * 
     * @return this.value LibraryItem pointed at by this ListItem
     */
    public LibraryItem getValue() {
        return this.value;
    }
}