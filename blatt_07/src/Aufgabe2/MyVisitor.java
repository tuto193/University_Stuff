package Aufgabe2;

import util.Visitor;

public class MyVisitor<E> implements Visitor<E> {

    /* public final static int SKIP = 1;
    public final static int ONWARD = 0;
    public final static int STOP = -1; */

    public enum Step {
        ONWARD, SKIP, STOP
    }

    Step toTake;

    @Override
    public boolean visit( E o ) {
        System.out.println( "Visited " + o.toString() );
        return true;
    }

    public int visit( E o ) {
        System.out.println( "Visited " + o.toString() );
        return Step;
    }
}