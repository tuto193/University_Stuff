package Aufgabe3;
/**
 * A simple LinkedList, which delete functionalities of a Stack (Pop)
 * 
 * @author Carlos A. Parra F.
 */
public class List {
    /**
     * The List's head, tail and it's current length
     */
    private ListItem head;
    private ListItem tail;
    private int length = 0;

    /**
     * A simple constructor
     */
    public List () {
        this( null );
    }

    /**
     * A more verbose constructor
     */
    public List( LibraryItem item ) {
        if( item != null ) {
            append(item);
            length++;
        }
    }
    
    /**
     * Append the item to the list
     * 
     * @param item a LibraryItem to be appended
     */
    public void append( LibraryItem item ) {
        ListItem toAppend = new ListItem( item );

        if( tail != null ) {
            this.tail.setNext(toAppend);
        }
        this.tail = toAppend;

        if( head == null ) {
            this.head = toAppend;
        }
        length++;
    }

    /**
     * Preprend the item to the List
     * 
     * @param item a LibraryItem to be prepended to the list
     */
    public void prepend( LibraryItem item ) {
        ListItem toPrepend = new ListItem( item );

        toPrepend.setNext(this.head);
        this.head = toPrepend;

        if( tail == null ) {
            this.tail = toPrepend;
        }
        length++;
    }

    /**
     * Peek the top-most item on this stack... eh... List
     * 
     * @return the top-most LibraryItem of the List
     */
    public LibraryItem getHead() {
        if( head == null ) {
            return null;
        }
        return head.getValue();
    }

    /**
     * Peek the lowest item on the List
     * 
     * @return the lowest LibraryItem on this list
     */
    public LibraryItem getTail() {
        if( this.tail == null ) {
            return null;
        }
        return this.tail.getValue();
    }

    /**
     * Check whether the list is empty
     */
    public boolean isEmpty() {
        return (this.head.getValue() == null);
    }

    /**
     * Returns the top-most item of this List and also removing it from the list
     * 
     * @return top-most LibraryItem
     */
    public LibraryItem pop() {
        ListItem toPoop = this.head;// lol
        if( toPoop == null ) {
            return null;
        }

        this.head = toPoop.getNext();
        toPoop.setNext( null );

        if( this.tail == toPoop ) {
            this.tail = null;
        }

        return toPoop.getValue();
    }

    /**
     * Returns the current length of the list
     */
    public int getLength() {
        return this.length;
    }
}