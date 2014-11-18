package f01_Semaphoren;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SemTest {
 private static Semaphore sem = new Semaphore(4,true);
   private static AtomicInteger counter = new AtomicInteger(0);

   public void doCriticalWork() {
     try {
       sem.acquire();
       int currentCounter = counter.addAndGet(1);
       Thread.currentThread().sleep(100);
       System.out.println("current counter: " + currentCounter);
       counter.addAndGet(-1);
       sem.release();
     } catch (Exception e) {
     }
   }

   public static void main(String[] args) {
    for (int i=0; i<100; ++i) {
      new Thread(new Runnable() {
         public void run() {
          SemTest st = new SemTest();
          st.doCriticalWork();
         }
       }).start();
     }
  }
 }