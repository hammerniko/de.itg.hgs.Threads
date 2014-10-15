package c01_ThreadsMitZeit;

public class MyThread implements Runnable {

	int waitingTime;
	String name;
	Thread t;
	
	public MyThread(String name, int time){
		waitingTime=time;
		this.name = name;
		t=new Thread(this);
	}
	
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(name+": "+i);
			try {
				Thread.sleep(waitingTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void start(){
		t.start();
	}

}
