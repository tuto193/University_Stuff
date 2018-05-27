package util;

/**
 * An Entry holds an Object <code>o</code> and a reference <code>next</code> to
 * the next Entry such that a linked List of Entry elements is generated.
 * 
 * @author Carlos A. Parra F.... totally
 */
class GenericEntry<T> {

   T o;
   GenericEntry<T> next;

   GenericEntry() {
      this(null, null);
   }

   GenericEntry(T o) {
      this(o, null);
   }

   GenericEntry(T o, GenericEntry e) {
      this.o = o;
      this.next = e;
   }

}
