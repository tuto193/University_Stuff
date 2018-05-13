package Aufgabe3;

public class List {
    private ListItem head;
    private ListItem tail;

    public List () {
        this( null );
    }

    public List( ListItem item ) {
        this.head = item;
        this.tail = item;
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
    }

    public void prepend( LibraryItem item ) {
        ListItem toPrepend = new ListItem( item );

        toPrepend.setNext(this.head);
        this.head = toPrepend;

        if( tail == null ) {
            this.tail = toPrepend;
        }
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
}