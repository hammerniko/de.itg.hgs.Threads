package Z7_HP2011A3_Pacman;

import java.util.Timer;
import java.util.TimerTask;



public class MyTimer {
	
	
	Steuerung dieSteuerung;
	private long dasIntervall;
	private Timer timer;

	public MyTimer(Steuerung s, int pIntervall) {
		dieSteuerung = s;
		dasIntervall = (long) pIntervall;
	}
	
	public void starte() {
		timer = new Timer();
		timer.schedule(new Task(), 1000, dasIntervall);
		
	}
	
	public void stoppe() {
		timer.cancel();
	}

	class Task extends TimerTask {
	    int count = 1;

	    // run is a abstract method that defines task performed at scheduled time.
	    public void run() {
	    	
	        //System.out.println(count+" :Timer");
	        //count++;
	    	dieSteuerung.tickTimer();
	    	}
	    }
	}

	

