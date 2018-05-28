package util;

/**
 * Created by Fabian on 24.05.2018
 */
public class GenericListTest {

   public static void main(String[] args) {

      GenericList<String> list = new GenericList<>();

      list.add("a");
      list.add("b");
      list.add("c");
      list.add("d");

      GenericList<String> clone = list.clone();

      cloneTest(list,clone);
   }

   public static void cloneTest(Object x, Object clone) {
      System.out.println("x.clone() != x");
      if (clone != x) {
         System.out.println("Passed");
      } else {
         System.out.println("Failed");
      }
      System.out.println();

      System.out.println("x.clone.getClass() == x.getClass(), which is not an absolute requirement");
      if (clone.getClass() == x.getClass()) {
         System.out.println("Passed");
      } else {
         System.out.println("Failed");
      }
      System.out.println();

      System.out.println(" x.clone().equals(x), which is not an absolute requirement");
      if (clone.equals(x)){
         System.out.println("Passed");
      } else {
         System.out.println("Failed");
      }
      System.out.println();
   }
}