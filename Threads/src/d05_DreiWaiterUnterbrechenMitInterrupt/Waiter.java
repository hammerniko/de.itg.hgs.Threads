package d05_DreiWaiterUnterbrechenMitInterrupt;
import java.time.LocalTime;

public class Waiter extends Thread
{
   private Object ob;

   /**
    */
   public Waiter(Object ob)
   {
    this.ob = ob;
   }

   public void run()
   {
    // waiter warten sofort
      synchronized(ob)
      {
         try
         {
            System.out.println(this.getName() + " waits");
            ob.wait();
            System.out.println(this.getName() + " ends waiting");
         }
         catch(InterruptedException ex)
         {
            System.out.println(this.getName() + " " +ex);
         }
      }
   }
}