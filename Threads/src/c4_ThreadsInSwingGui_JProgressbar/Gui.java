/**
 * In diesem Beispiel wird nach einem klick auf einen Button ein SwingWorker Thread
 * getsartet, welcher langsam eine Schleife druchläuft.
 * 
 * Da Swing nicht Threadsicher ist, wird über die Callback-Methoden eines Swing-Worker
 * Objekt die JProgressbar aktualisiert.
 * 
 * Nach erledigter Arbeit wird die JProgressbar auf den Maximalwert gesetzt.
 * 
 *Anstatt der for-Schleife könnte z.B. auch ein Up- oder Download einer größeren
 *Datei stattfinden.  
 * 
 * @author Hammer
 *
 */
package c4_ThreadsInSwingGui_JProgressbar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;


public class Gui extends JFrame {
	//Konstanten
    private static final String STATUS = "Status";
	private static final String SWINGWORKER_FINISHED = "Swingworker finished";
	private static final int WAIT100MS = 100;
	
	private static final String TITLE = "Threads in Swing";
	private static final String TU_WAS = "Tu was...";
	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;
	protected static final int MAX = 30;
	protected static final int MIN = 0;

	JPanel contenPane;
	JButton btnLoad;
	JProgressBar pb;
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Gui gui = new Gui();
				gui.setVisible(true);

			}
		});

	}

	public Gui() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITLE);

		contenPane = new JPanel();
		contenPane.setLayout(new BorderLayout());
		btnLoad = new JButton(TU_WAS);
		btnLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedLoadButton();
			}
		});

		pb = new JProgressBar(MIN, MAX);
		contenPane.add(btnLoad, BorderLayout.CENTER);
		contenPane.add(pb, BorderLayout.SOUTH);
		setContentPane(contenPane);

	}

	/**
	 * Der erste ObjektParameter des SwingWorkers bestimmt den Rückgabewert der doInBackground()-Methode.
	 * Es muss ein komplexer Datentyp zurueckgegeben werden. Dieser Wert kann mit get() aus der callback-Methode
	 * done() geholt werden.
	 * 
	 * Der zweite Objektparameter ermöglicht einen Fortschritt über die Methode
	 * publish() innerhalb der Methode doInBackground() während der Laufzeit des SwingWorker-Threads abzusetzen
	 * Der Wert kann dann in der callbackMethode process() abgerufen werden.
	 * 
	 */
	protected void clickedLoadButton() {
		
		SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

			@Override
			protected Boolean doInBackground() throws Exception {
				
				//Irgendetwas tun was länger dauert
				for (int i = MIN; i < MAX; i++) {
					Thread.sleep(WAIT100MS);
					
					//Testausgabe auf der Konsole
					System.out.println("Hello"+i);
					
					//Datentyp bestimtm durch den 2.ten Objektparameter 
					//Sende den Wert der Variablen raus
					publish(i);
					
				}
				
				//Rückgabewert wenn doInBackground fertig ist (Kann mit get() in done() abgerufen werden
				return true;
			}
			
			
			/**
			 * Der Aufruf von process während des Threads kann nicht garantiert werden,
			 * weshalb eine ganze Liste von Objekten des zweiten Objektparameters übergeben wird.
			 */
			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				super.process(chunks);
				
				//letzten Integerwert aus der Liste holen
				int value = chunks.get(chunks.size()-1);
				
				//Progressbar aktualisieren
				pb.setValue(value);
				btnLoad.setText(TU_WAS+" "+value);
				
			}
			
			

			
			@Override
			protected void done() {
				
				super.done();

				try {
					
					//nach erledigter Arbeit Threadsicher ein Swing-Interface hier updaten 
					//get holt den Boolschen Wert aus der doInBackgound Methode
					Boolean status = get();
					btnLoad.setText(STATUS+status);
					System.out.println(SWINGWORKER_FINISHED);
					pb.setValue(MAX);
					
				} catch (InterruptedException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				
			}
			
		};
		
		//Swing Thread starten als Hintergundthread starten
		worker.execute();

	}
}
