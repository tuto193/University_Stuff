package util;

import test.Assert;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListTest {

   public static void main(String[] args) {
        MyList<String> mine = new MyList<String>();
        // Check that hasNext works on an empty collection
        Assert.assertFalse( mine.iterator().hasNext() );
        // Check that the right exception is thrown
        try{
            mine.iterator().next();
        } catch( NoSuchElementException e ) {
            Assert.assertTrue(true);
        }

        mine.add( "a" );
        // Check that we have our one item
        Assert.assertTrue(mine.iterator().hasNext());

        // Check the item, and that it IS the item we know is there
        Assert.assertTrue(mine.iterator().next().equals("a"));

        // Then DELETE the item and check that it is empty afterwards
        mine.iterator().remove();

        Assert.assertFalse(mine.iterator().hasNext());

        // Try deleting from the now empty list
        try{
            mine.iterator().remove();
        } catch( NoSuchElementException e ) {
            Assert.assertTrue(true);
        }

        // Now a test with the removal of maaany items
        String longOne = "It's 30 to midnight and I'm writting tests ";
        for( int i = 0; i < longOne.length(); i++ ) {
            String toAdd = "" + longOne.charAt(i);
            if( i%5 == 0 ){
                mine.add( "Waldo" );
            }
            mine.add(toAdd);
        }

        // After hiding some extra ones

        for( Iterator<String> it = mine.iterator(); it.hasNext(); ) {
            it.remove();
        }
        
        // This should now be an empty list
        Assert.assertFalse(mine.iterator().hasNext());
   }
}
