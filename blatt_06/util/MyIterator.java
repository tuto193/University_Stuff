package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Just a simple ListIterator with the added
 * capability of deleting entries of said list
 * 
 * @author Carlos A. Parra F.
 */
public class MyIterator<E> implements Iterator {
    private MyEntry<E> prev;
    private MyEntry<E> curr;
    private MyList<E> list;

    public MyIterator( MyEntry<E> first, MyList<E> list ) {
        this.list = list;
        this.prev = null;
        this.curr = first;
    }

    @Override
    public boolean hasNext() {
        return this.curr != null;
    }

    @Override
    public E next() {
        // Show error if the List had changed
        // And another error if there is no such next element
        if( !hasNext() ) {
            throw new NoSuchElementException();
        }
        E o = this.curr.o; // the next element
        // Move our triad further
        this.prev = this.curr;
        this.curr = this.curr.next;

        return o;
    }

    /**
     * Returns the element that is deleted from the list
     * (if any)
     * 
     * @return o Object pointed at by the Entry withing the list
     * @throws NoSuchElementException if there is no element to be deleted
     */
    @Override
    public void remove() {
        if( !hasNext() ) {
            throw new NoSuchElementException();
        }
        // the object to the taken out
        E o = this.curr.o;
        this.prev.next = this.curr.next;
        this.curr = this.curr.next;
    }
}