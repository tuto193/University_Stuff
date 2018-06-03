package util;

import test.Assert;
import java.util.Iterator;

public class MyListTest {

   public static void main(String[] args) {

      /*
       * not absolute requirements
       */
      MyList<String> mine = new MyList<String>();
      for( Iterator<String> it = mine.iterator(); it.hasNext(); ) {
            it.remove();
      }
      
   }
}
