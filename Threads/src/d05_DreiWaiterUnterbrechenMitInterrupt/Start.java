package d05_DreiWaiterUnterbrechenMitInterrupt;

import java.util.concurrent.TimeUnit;

public class Start {
	 public static void main(String[] args)
	   {
	      Object ob = new Object();
	      Waiter wt1 = new Waiter(ob);
	      Waiter wt2 = new Waiter(ob);
	      Waiter wt3 = new Waiter(ob);
	      wt1.start();
	      wt2.start();
	      wt3.start();

	      try { TimeUnit.SECONDS.sleep(1); } catch(InterruptedException ex) {}

	      synchronized(ob)
	      {
	        System.out.println("main calls notify");
	         ob.notify();
	      }
	      try { TimeUnit.SECONDS.sleep(2); } catch(InterruptedException ex) {}
	    System.out.println("main interrupts all waiting threads");

	      //Wartende Threads unterbrechen
	      //wt1.interrupt();
	      //wt2.interrupt();
	      //wt3.interrupt();
	      
	      
	      //Wartende Threads benachrichtigen und abarbeiten
	      synchronized(ob)
	      {
	        System.out.println("main calls notifyAll");
	         ob.notifyAll();
	      }
	   }
	}

