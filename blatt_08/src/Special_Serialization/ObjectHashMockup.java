package Special_Serialization;

class ObjectHashMockup {

   private final int hashCode;
   private final Object object;

   ObjectHashMockup(int hashCode) {
      this.hashCode = hashCode;
      this.object = new Object();
   }

   @Override
   public boolean equals(Object o) {
      if (o.getClass() == ObjectHashMockup.class) {
         return this.object.equals(((ObjectHashMockup) o).object);
      }
      return this.object.equals(o);
   }

   @Override
   public int hashCode() {
      return hashCode;
   }
}
