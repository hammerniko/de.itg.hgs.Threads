package c02_ThreadUhr;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Uhr implements Runnable{
	
	boolean isRunning = false;
	Thread t;
	Date date;
	DateFormat format;
	long time; 
	
	public Uhr(){
		
		date = new Date();
		format = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		isRunning = true;
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		while(isRunning){
			
			time = System.currentTimeMillis();
			date.setTime(time);
			warteEineSekunde();
			
			ausgabeZeit();
			
			
		}
		
	}
	
	private void warteEineSekunde(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ausgabeZeit(){
		System.out.println(format.format(date));
	}
	
	public void start(){
		if(!t.isAlive()){
			t.start();
		}
	}

}
