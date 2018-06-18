package Special_Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Implementation of an open hash set: one bucket holds all entries with the
 * same {@link Object#hashCode()}.
 */
public class OpenHashSet<T> implements HashSet<T>, Serializable {

   /**	
	 * An auto-generated SerialVersion
	 */
   	private static final long serialVersionUID = -4431830653862243945L;
    private transient MyList<T>[] buckets;
    private HashFunction<? super T> hashFunction;

   /**
    * An <code>OpenHashSet</code> with a hash table of length 10.
    */
   public OpenHashSet() {
      this(10);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    *
    * @param size length of the hash table
    */
   public OpenHashSet(int size) {
      this(size, null);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    * which uses <code>hashFunction</code> to define the equality of two objects.
    *
    * @param size         length of the hash table
    * @param hashFunction representation of the used hash function
    */
   public OpenHashSet(int size, HashFunction<? super T> hashFunction) {
      this.buckets = new MyList[size];
      for( int i = 0; i < size; i++ ) {
          this.buckets[i] = new MyList<T>();
      }
      this.hashFunction = hashFunction;
   }


   @Override
   public boolean contains(T o) {
      MyList<T> bucket = buckets[hashCode(o) % buckets.length];
      bucket.reset();
      while (!bucket.endpos()) {
         if (equals(o, bucket.elem())) {
            return true;
         }
         bucket.advance();
      }
      return false;
   }

   @Override
   public boolean insert(T o) {
      if (contains(o)) {
         return false;
      } else {
          // Here we can instance our List finally
         this.buckets[hashCode(o) % buckets.length].add(o);
         return true;
      }
   }

   @Override
   public boolean delete(T o) {
       // If the object is not inside, you might as well
       // not bother with deleting it
       if( this.contains( o ) ) {
            MyList<T> bucket = buckets[hashCode(o) % buckets.length];
            bucket.reset();
            while (!bucket.endpos()) {
                if (equals(o, bucket.elem())) {
                    bucket.delete();
                    return true;
                }
                bucket.advance();
            }
        }
        return false;
   }

   private int hashCode(T o) {
      return hashFunction == null ? o.hashCode() : hashFunction.hashCode(o);
   }

   private boolean equals(T o1, T o2) {
      if (hashFunction == null) {
         return o1.equals(o2);
      } else {
         return hashFunction.equals(o1, o2);
      }
   }

   /********************************************
    *       Special Serialization              *
    ********************************************/

    /**
     * Writes a single list with all the objects contained within the buckets
     * 
     * @param oout
     *            the object that will be written out, containing all of the objects inside the list
     * @throws IOException
     *            if it encounters an IOException 
     */
    private void writeObject( ObjectOutputStream oout ) throws IOException {
        /* // Create a new list to save all the objects
        // that are inside the buckets
        MyList<T> toWrite = new MyList<T>(); */
        // We just need a single Entry to save all of the elements of the buckets
        int bucketSize = buckets.length;
        oout.writeInt(bucketSize);
        // Save all objects in list
        for( int i = 0; i < buckets.length; i++ ) {
            int listSize = 0;
            if( buckets[i].elem() != null ) {
                while( !buckets[i].endpos() ) {
                    listSize++;
                    buckets[i].advance();
                }
            }
            buckets[i].reset();
            oout.writeInt(listSize);
        } 

        // Write all objects in that order into the file
        for( int i = 0; i < buckets.length; i++ ) {
            if( buckets[i].elem() != null ) {
                while( !buckets[i].endpos() ) {
                    oout.writeObject( buckets[i].elem() );
                    buckets[i].advance();
                }
            }

        }
            }

    /**
     * The List that was saved is then deserialized, 
     * and all the objects that were there are all
     * added back into the buckets (but not in the same
     * order...)
     * 
     * @param oin
     *          the input stream that is being read into
     * @throws IOException
     *          if it happens to encounter an IOException
     * @throws ClassNotFoundException
     *          if it encoutners a ClassNotFoundExcpetion
     */
    private void readObject( ObjectInputStream oin ) throws IOException, ClassNotFoundException  {
        int bucketSize = oin.readInt();
        MyList<T>[] newBuckets = new MyList[bucketSize];

        // Read the objects from the file and pack
        // them one by one into the buckets
        // They should be in the exact same order they
        // came in
        for( int i = 0; i < bucketSize; i++ ) {
            int list = oin.readInt();
            newBuckets[i] = new MyList<T>();
            for( int j = 0; j < list; j++ ) {
                newBuckets[i].add( (T) oin.readObject() );
            }
        } 
        this.buckets = newBuckets;
    }
}
