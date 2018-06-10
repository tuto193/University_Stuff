package Aufgabe2;

import util.Visitor;

public class MyVisitor<E> {

    /* public final static int SKIP = 1;
    public final static int ONWARD = 0;
    public final static int STOP = -1; */

    public enum Step {
        ONWARD, SKIP, STOP
    }


    public Step visit( E o ) {
        System.out.println( "Visited " + o.toString() );
        return Step.ONWARD;
    }
}