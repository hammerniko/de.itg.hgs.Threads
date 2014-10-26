package d01_waitAndNotify;

class MyThread implements Runnable {
	  MyResource myResource;

	  MyThread(String name, MyResource so) {
	    myResource = so;
	    new Thread(this, name).start();
	  }

	  public void run() {
	   
	    try {
	      myResource.waitFor();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
