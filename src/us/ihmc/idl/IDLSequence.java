package us.ihmc.idl;

public class IDLSequence <T>
{
   private final T[] sequence;
   private int pos = -1;
   
   public IDLSequence(T[] sequence)
   {
      this.sequence = sequence;
   }
   
   public T get(int i)
   {
      if(i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException();
      }
      return sequence[i];
   }
   
   public void set(int i, T val)
   {
      if(i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException();
      }
      
      sequence[i] = val;
   }
   
   public void add(T val)
   {
      sequence[++pos] = val;
   }
   
   public T remove()
   {
      return sequence[pos--];
   }
   
   
}
