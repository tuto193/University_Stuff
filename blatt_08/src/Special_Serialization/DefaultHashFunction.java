package Special_Serialization;

public class DefaultHashFunction<T> implements HashFunction<T> {
   @Override
   public boolean equals(T o1, T o2) {
      return o1.equals(o2);
   }

   @Override
   public int hashCode(T o) {
      return o.hashCode();
   }
}
