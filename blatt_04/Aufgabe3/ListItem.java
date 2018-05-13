package Aufgabe3;

public class ListItem {
    private LibraryItem value;
    private ListItem next;

    public ListItem( LibraryItem value ) {
        this( value, null );
    }

    public ListItem( LibraryItem value, ListItem next ) {
        this.value = value;
        this.next = next;
    }

    public LibraryItem getValue() {
        if( value == null ) {
            return null;
        }
        return this.value;
    }

    public void setValue( LibraryItem value ) {
        this.value = value;
    }

    public void setNext( ListItem newItem ) {
        this.next = newItem;
    }

    public ListItem getNext() {
        if( this.next == null ) {
            return null;
        }
        return this.next;
    }
}