package B_ThreadErzeugenMitInterface;

import javax.swing.text.DefaultEditorKit.BeepAction;

import org.jfugue.Pattern;
import org.jfugue.Player;
import org.jfugue.Rhythm;

public class MyThread implements Runnable {

    String name;
    int wait;
    char note;
    Thread t;
    
    Player player;
    Rhythm rythm; 
    Pattern song; 
    Pattern pattern1;
    Pattern pattern2;
    Pattern pattern3;
    Pattern pattern4;
    

    public MyThread(String name, int wait, char note) {
        player = new Player();
        rythm = new Rhythm();
        this.note = note;
        this.name = name;
        this.wait = wait;
        t = new Thread(this);
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
        
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            // TODO Automatisch generierter Erfassungsblock
            e.printStackTrace();
        }
                
    
        player = new Player(); player.play(song);
  
    }

    public void start() {
        if (!t.isAlive()) {
            t.start();
        }
    }

}
