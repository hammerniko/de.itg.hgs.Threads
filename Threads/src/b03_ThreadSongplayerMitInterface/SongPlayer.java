package b03_ThreadSongplayerMitInterface;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.rhythm.Rhythm;

public class SongPlayer implements Runnable {

    private String name;
    public String getName() {
		return name;
	}

	private int wait;
    private char note;
    
    //Threadobjekt
    private Thread t;
    
    RealtimePlayer player;
    Pattern song; 
    Pattern pattern1;
    Pattern pattern2;
    Pattern pattern3;
    Pattern pattern4;
    

    public SongPlayer(String name, int wait) {
    	//Threadobjekt erzeugen
        t = new Thread(this);
       
        try {
			player = new RealtimePlayer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.name = name;
        this.wait = wait;
                                
        pattern1 = new Pattern("I[Piano] C5q D5q E5q C5q");

        // "Dormez-vous?"
        pattern2 = new Pattern("E5q F5q G5h");

        // "Sonnez les matines"
        pattern3 = new Pattern("G5i A5i G5i F5i E5q C5q");

        // "Ding ding dong"
        pattern4 = new Pattern("C5q G4q C5h");

        // Put all of the patters together to form the song
        song = new Pattern();
        song.add(pattern1, 2); // Adds 'pattern1' to 'song' twice
        song.add(pattern2, 2); // Adds 'pattern2' to 'song' twice
        song.add(pattern3, 2); // Adds 'pattern3' to 'song' twice
        song.add(pattern4, 2); // Adds 'pattern4' to 'song' twice

    }

    @Override
    public void run() {
    	System.out.println("Songplayer "+getName()+" gestartet");
        try {
            System.out.println("Thread"+name+" wartet");
        	Thread.sleep(wait);
            
        } catch (InterruptedException e) {
            // TODO Automatisch generierter Erfassungsblock
            e.printStackTrace();
        }
        
        System.out.println("Thread"+name+" spielt");
        
        player.play(song); 
     }

    public void start() {
		if (t == null) {
			t = new Thread(this);
		}
		t.start(); 
	}

}
