package d01_waitAndNotify;

public class Main {
	  public static void main(String args[]) throws Exception {
	    MyResource sObj = new MyResource();
	    
	    new MyThread("MyThread", sObj);
	    for (int i = 0; i < 10; i++) {
	      Thread.sleep(100);
	      System.out.print(".");
	    }
	    sObj.start();
	   
	  }
	}