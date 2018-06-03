package util;

import test.Assert;

public class OpenHashSetTest {

   public static void main(String[] args) {

      System.out.println("Test OpenHashSet...");

      HashFunction function = new DefaultHashFunction();

      OpenHashSet hashSet = new OpenHashSet(10,function);
      for (int i = 0; i < 11; i++) {
         hashSet.insert(new Object());
      }

      System.out.println("...insert...");
      Object o1 = new Object();
      Assert.assertTrue(hashSet.insert(o1));

      System.out.println("...insert existing...");
      Assert.assertFalse(hashSet.insert(o1));

      System.out.println("...contains existing...");
      Assert.assertTrue(hashSet.contains(o1));

      Object o2 = new Object();
      System.out.println("...contains non existing...");
      Assert.assertFalse(hashSet.contains(o2));

      System.out.println("...delete non existing...");
      Assert.assertFalse(hashSet.delete(o2));

      System.out.println("...delete existing...");
      Assert.assertTrue(hashSet.delete(o1));

      System.out.println("...prove deletion...");
      Assert.assertFalse(hashSet.contains(o1));

      System.out.println("...contains later...");
      ObjectHashMockup mockup = new ObjectHashMockup(1);
      hashSet.insert(mockup);
      for (int i = 0; i < 3; i++) {
         hashSet.insert(new ObjectHashMockup(1));
      }
      Assert.assertTrue(hashSet.contains(mockup));

      System.out.println("...delete later...");
      Assert.assertTrue(hashSet.delete(mockup));

      System.out.println("...finished.");
   }
}
