/**
 * A Stack that holds Strings. Works after the LIFO (Last in first out)
 * principle.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 *
 */
public class StringStack {

    /*
    This is the empty/default constructor
     */
   public StringStack() {
      this.first = null;
   }

   /*//////////////////////////////////////////////////////////////////////
   But we also want a few other types of "constructors" to copy another
   StringStack into them
   */
   // Reference-Copy, because we are copying the same address (in memory)
   // from the old one into the new one
   public StringStack referenceCopy( StringStack toCopy ) {
       StringStack newCopy = new StringStack();
       newCopy = toCopy;
       return newCopy;
   }

   // Shallow-Copy, because we are creating a new space in memory, but copying
   // the the same values (and references) from the old one into the new one.
   public StringStack shallowCopy( StringStack toCopy ) {
       StringStack newCopy = new StringStack();
       newCopy.first = toCopy.first;
       return newCopy;
   }

   // Deep-copy: we empty ALL of the contents into our copyingMachine (as to
   // conserve the right order when copying them back), then we make individual
   // copies of each StringStackEntry, put the copy into the new Deep-Copy,
   // and put the original StringStackEntry back into the original StringStack
   public StringStack deepCopy( StringStack toCopy ) {
       StringStack copyingMachine = new StringStack();
       StringStack newCopy = new StringStack();

       // We empty all contents into the copyingMachine
       while( !toCopy.empty() ) {
           copyingMachine.push( toCopy.pop() );
       }

       // We copy the first element into the new copy, then we pop the original
       // one back into the original stack and set the copy in the deep-copy
       while( !copyingMachine.empty() ) {
           StringStackEntry copyEntry = new StringStackEntry( copyingMachine.peek().getString() );

           newCopy.push( copyEntry.getString() );
           toCopy.push( copyingMachine.pop() );
       }
       return newCopy;
   }
///////////////////////////////////////////////////////////////////////////////

   private StringStackEntry first;

   /**
    * Tests, whether this StringStack is empty or not.
    *
    * @return true if this StringStack is empty, else false
    */
   public boolean empty() {
      return this.first == null;
   }

   /**
    * Returns the first element in the stack. Throws Exception when stack is
    * empty
    *
    * @return First element or null if stack is empty
    * @throws RuntimeException
    *            if stack is empty.
    */
   public String peek() {
      if (!this.empty()) {
         return first.getString();
      } else {
         throw new RuntimeException("Stack is empty");
      }
   }

   /**
    * Deletes the first element in the stack and returns it. Throws Exception
    * when stack is empty
    *
    * @return first element in the stack
    * @throws RuntimeException
    *            if stack is empty.
    */
   public String pop() {
      if (!this.empty()) {
         String ret = first.getString();
         this.first = this.first.getNext();
         return ret;
      } else {
         throw new RuntimeException("Stack is empty");
      }
   }

   /**
    * Puts the String s on the stack.
    *
    * @param s
    *           String to be added.
    */
   public void push(String s) {
      if (this.empty()) {
         first = new StringStackEntry(s, null);
      } else {
         first = new StringStackEntry(s, first);
      }
   }

}
