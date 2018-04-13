/**
 * Represents an entry of a <code>StringStack</code> which holds a String and a
 * reference to the next StringStackEntry.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class StringStackEntry {
   
   /**
    * The next StringStackEntry
    */
   private StringStackEntry next;
   /**
    * The String which this StringStackEntry represents
    */
   private String s;

   /**
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    */
   public StringStackEntry(String s) {
      this(s, null);
   }

   /**
    * 
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    * @param next
    *           the StringStackEntry next will be visible if this
    *           StringStackEntry is removed from the stack.
    */
   public StringStackEntry(String s, StringStackEntry next) {
      this.s = s;
      this.next = next;
   }

   public StringStackEntry getNext() {
      return this.next;
   }

   public String getString() {
      return this.s;
   }
}
