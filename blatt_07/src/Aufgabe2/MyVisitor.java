package Aufgabe2;

import util.*;

public class MyVisitor<E> implements Visitor<E> {
    @Override
    public boolean visit( E o ) {
        System.out.println( o.toString() );
        return true;
    }
}