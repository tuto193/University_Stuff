
package util;

/**
 * A simple linked list. One may go through this list by {@link #advance()} until
 * the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 * 
 * @author Carlos A. Parra F. Totally
 * 
 */
public class GenericList<T> implements Cloneable{

   /**
    * Reference on the first Entry of this List
    */
   private GenericEntry<T> begin;
   /**
    * References before the actual Entry of this List
    */
   private GenericEntry<T> pos;

   /**
    * Create a new empty List.
    */
   public GenericList() {
      pos = begin = new GenericEntry<T>();
   }

   /**
    * Determines if this List is empty or not.
    * 
    * @return <code>true</code>, if there are no elements in this List
    */
   public boolean empty() {
      return begin.next == null;
   }

   /**
    * Determines if it is possible to {@link #advance()} in this List. Returns
    * <code>true</code> if the last position of this List has been reached. An
    * {@link #empty()} List will alway deliver <code>true</code>
    * 
    * @return <code>true</code> if the last Entry in this List already has been
    *         reached.
    */
   public boolean endpos() { // true, wenn am Ende
      return pos.next == null;
   }

   /**
    * Returns to the beginning of this List.
    */
   public void reset() {
      pos = begin;
   }

   /**
    * Advances one step in this List.
    * 
    * @throws RuntimeExcpetion
    *            if the last Entry of this List already has been reached.
    */
   public void advance() {
      if (endpos()) {
         throw new RuntimeException("Already at the end of this List");
      }
      pos = pos.next;
   }

   /**
    * Returns the actual element of this List.
    * 
    * @return the actual element
    * 
    * @throws RuntimeException
    *            if the last Entry of this List already has been reached.
    */
   public T elem() {
      if (endpos()) {
         throw new RuntimeException("Already at the end of this List");
      }
      return pos.next.o;
   }

   /**
    * Inserts <code>o</code> in this List. It will be placed before the actual
    * element. After insertion the inserted element will become the actual
    * element.
    * 
    * @param x
    *           the element to be inserted
    */
   public void add(T x) {
      GenericEntry<T> newone = new GenericEntry<T>(x, pos.next);

      pos.next = newone;
   }

   /**
    * Deletes the actual element of this List. The element after the actual
    * element will become the new actual element.
    * 
    * @throws RuntimeExcpetion
    *            if the last Entry of this List already has been reached.
    */
   public void delete() {
      if (endpos()) {
         throw new RuntimeException("Already at the end of this List");
      }
      pos.next = pos.next.next;
   }

   // LETS IMPLEMENT CLONEABLE ////////////////////////////////////////
   // We are not going to be convenrtional
   /**
    * Returns a clone of this GenericList, where all entries (BUT NOT THE OBJECTS
    POINTED AT BY THEM) are also Objects that don't refere to the ones they are taking from.

    @return a Copy (clone) of this Object.
    */
   public GenericList<T> clone() {
        GenericList<T> theClone = new GenericList<T> (); 

        this.reset();
        while( !this.endpos() ) {
            GenericEntry<T> zombie = new GenericEntry<T>( this.elem() );
            theClone.add( zombie.o );
            this.advance();
        }

        return theClone;
   }
}