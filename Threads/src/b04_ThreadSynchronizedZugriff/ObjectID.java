package b04_ThreadSynchronizedZugriff;
import java.lang.*;
 import java.io.*;
 /**
  * Wird in der Methode GetID das Schlüsselwort synchronized weggelassen,
  * kann es vorkommen, das einige Threadobjekte die gleiche ID bekommen.
  * Da evtl. mehrere Threads gleichzeitig auf die Methode zugereifen.
  * Synchronized verhindert diesen gleichzeitigen Zugriff und "locked" die Methode
  * für andere Threads, so lange ein Thread sie bearbeitet.
  * 
  * Durch entfernen des Schl�sselwortes synchronized kann 
  * das Szenario getestet werden. Synchronized kostet Performance.
  * @author hr
  *
  */
 class  ObjectID {
  
  private static int seq=0;

   private int id;
   
   private synchronized int getID() {
     return seq++;
   }

  public  ObjectID() {
     id = getID();
     
   }

  public  void print() {
     System.out.println("ID: " + id);
   }

   public static void main(String[] args) {
	  
	   
     for (int i=0; i<100; ++i) {
       new Thread(new Runnable() {
         public void run() {
           try {
            Thread.currentThread().sleep(100);
           } catch (Exception e) {
        	   System.out.println("Fehler");
           }
           final ObjectID o = new ObjectID();
           o.print();
         }
       }).start();
     }
     
     
   }
 }