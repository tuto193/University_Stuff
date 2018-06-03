package util;

import test.Assert;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListTest {

    public static void test( int num ) {
        System.out.println("Test " + num );
    }

   public static void main(String[] args) {
        MyList<String> mine = new MyList<String>();
        // Check that hasNext works on an empty collection
        test(1);
        Assert.assertFalse( mine.iterator().hasNext() );
        // Check that the right exception is thrown
        test(2);
        try{
            mine.iterator().next();
        } catch( NoSuchElementException e ) {
            Assert.assertTrue(true);
        }

        test(3);
        mine.add( "a" );
        // Check that we have our one item
        Assert.assertTrue(mine.iterator().hasNext());

        // Then DELETE the item and check that it is empty afterwards
        test(4);
        mine.iterator().remove();

        Assert.assertFalse(mine.iterator().hasNext());

        // Try deleting from the now empty list
        test(5);
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
        test(6);
        Assert.assertFalse(mine.iterator().hasNext());
   }
}
