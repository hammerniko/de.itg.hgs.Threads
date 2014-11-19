package d02_Notify;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EarlyNotify extends Object {
  private List list;

  public EarlyNotify() {
    list = Collections.synchronizedList(new LinkedList());
  }

  public String removeItem() throws InterruptedException {
    synchronized (list) {
      while (list.isEmpty()) {
        print("wait()");
        list.wait();
        print("done with wait()");
      }
      String item = (String) list.remove(0);

      return item;
    }
  }

  public void addItem(String item) {
    print("entering");
    synchronized (list) {
      list.add(item);
      print("added: '" + item + "'");

      list.notifyAll();
      print("notified");
    }
    print("leaving");
  }

  private static void print(String msg) {
    String name = Thread.currentThread().getName();
    System.out.println(name + ": " + msg);
  }

  public static void main(String[] args) {
    final EarlyNotify enf = new EarlyNotify();

    Runnable runA = new Runnable() {
      public void run() {
        try {
          String item = enf.removeItem();
          print("returned: '" + item + "'");
        } catch (InterruptedException ix) {
          print("interrupted!");
        } catch (Exception x) {
          print("threw an Exception!!!\n" + x);
        }
      }
    };

    Runnable runB = new Runnable() {
      public void run() {
        enf.addItem("Hello!");
      }
    };

    try {
      Thread threadA1 = new Thread(runA, "A1");
      threadA1.start();

      Thread.sleep(500);

      Thread threadA2 = new Thread(runA, "A2");
      threadA2.start();

      Thread.sleep(500);

      Thread threadB = new Thread(runB, "B");
      threadB.start();

      Thread.sleep(1000);

      threadA1.interrupt();
      threadA2.interrupt();
    } catch (InterruptedException x) {
    }
  }
}
