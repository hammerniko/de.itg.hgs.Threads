package a01_ThreadErzeugen;

public class MyThread extends Thread {

	String name;
	int wait;
	
	public MyThread(String name, int wait){
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

}
