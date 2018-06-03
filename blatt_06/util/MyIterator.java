package util;

import java.util.Iterator;

public class MyIterator implements Iterator {
    private MyEntry<E> prev;
    private MyEntry<E> curr;
    private MyEntry<E> next;
    private MyList<E> list;

    public MyIterator( MyEntry<E> first, MyEntry<E> second, MyList<E> list ) {
        this.list = list;
        this.prev = null;
        this.curr = first;
        this.next = second;
    }
}