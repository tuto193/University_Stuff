package Aufgabe3;

public class ListItem {
    private ListItem next;
    private LibraryItem value;

    public ListItem ( LibraryItem item ) {
        this( item, null );
    }

    public ListItem( LibraryItem item, ListItem next ) {
        this.next = next;
        this.value = item;
    }

    public void setNext( ListItem next ) {
        this.next = next;
    }

    public ListItem getNext() {
        return this.next;
    }

    public void setValue( LibraryItem value ) {
        this.value = value;
    }

    public LibraryItem getValue() {
        return this.value;
    }
}