package d01_waitAndNotify;

class MyResource {
	  boolean ready = false;
	  synchronized void waitFor() throws Exception {
	    System.out.println(Thread.currentThread().getName()+ " is entering waitFor().");
	     
	        wait();
	        

	    System.out.println(Thread.currentThread().getName() + " resuming execution.");
	  }
	  
	  synchronized void start() {
	    ready = true;
	    notify();
	  }
	}

	
	