package a01a_ThreadErzeugenMitInterface;

public class MyThread implements Runnable{

	String name;
	int wait;
	Thread t;
	
	public MyThread(String name, int wait){
		t = new Thread(this);
		this.name = name;
		this.wait=wait;
		
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(name+": "+i);
			
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		t.start();
	}

	public void stop(){
		t.stop();
	}
}
