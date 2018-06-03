package util;

import java.util.Iterator;

public class MyIterator implements Iterator {
    private MyEntry<E> prev;
    private MyEntry<E> curr;
    private MyEntry<E> next;
    private MyList<E> list;

    public MyIterator( MyEntry<E> first, MyList<E> list ) {
        this.prev = null;
        this.curr = first;
        this.next = 
    }
}