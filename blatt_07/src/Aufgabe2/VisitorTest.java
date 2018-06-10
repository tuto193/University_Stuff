package Aufgabe2;

import util.*;

public class VisitorTest {

    final static int objects = 100;

    public static void fillList( MyList<String> c ) {
        for( int i = 0; i < objects; i++ ) {
            String toAdd = "" + i;
            c.add(toAdd);
        }
    }

    public static void printList( MyList list ) {
        while( !list.endpos() ) {
            System.out.println( list.elem() );
            list.advance();
        }
        list.reset();
    }

    public static void main( String[] args ) {
        MyList<String> testList = new MyList<String>();
        fillList(testList);

        printList( testList );

        Visitor<String> v = new Visitor<String>(){
            @Override
            public boolean visit( String o ) {
                System.out.println( "Visited " + o );
                return true;
            }
        };

        testList.accept(v);
    }
}