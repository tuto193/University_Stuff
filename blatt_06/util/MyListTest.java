package util;

import test.Assert;
import java.util.Iterator;

public class MyListTest {

   public static void main(String[] args) {

        /*
        * not absolute requirements
        */
        MyList<String> mine = new MyList<String>();
        mine.add( "a" );
        mine.add( "b" );
        mine.add( "c" );
        String brokenUp = "This shit is long enough to make a list I hope...";
        mine.add( "Potatoe" );

        // Just add a bunch more Strings to make sure that our list has a nice ammount of stuff
        for( int i = 0; i < brokenUp.length(); i++ ) {
            String addMe = "" + brokenUp.charAt(i);
            mine.add( addMe );
        }
        for( Iterator<String> it = mine.iterator(); it.hasNext(); ) {
            if( it.next().equals("Potatoe") ) {
                it.remove();
            }
        }
      
   }
}
