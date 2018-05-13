package Aufgabe3;

public class List {

    private ListItem head;
    private ListItem tail;
    private int length = 0;

    public List () {
        this( null );
    }

    public List( ListItem item ) {
        this.head = item;
        this.tail = item;
        if( item != null ) {
            length++;
        }
    }

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

    public void prepend( LibraryItem item ) {
        ListItem toPrepend = new ListItem( item );

        toPrepend.setNext(this.head);
        this.head = toPrepend;

        if( tail == null ) {
            this.tail = toPrepend;
        }
        length++;
    }

    public LibraryItem getHead() {
        if( head == null ) {
            return null;
        }
        return head.getValue();
    }

    public LibraryItem getTail() {
        if( tail == null ) {
            return null;
        }
        return tail.getValue();
    }

    public boolean isEmpty() {
        return (head == null);
    }

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

    public int getLength() {
        return this.length;
    }
}