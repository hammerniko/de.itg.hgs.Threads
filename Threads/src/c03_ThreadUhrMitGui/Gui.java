package c03_ThreadUhrMitGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	//Assoziation
	Uhr dieUhr;
	
	//Komponenten
	JPanel contentPane;
	JPanel main;
	JButton btStart;
	JButton btStop;
	JButton btReset;
	JLabel	lbUhrzeit;
	
	public Gui(){
		dieUhr = new Uhr(this);
		initialize();
		
		
	}

	private void initialize() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setResizable(false);
		setSize(400, 100);
		
		btStart = new JButton("Start");
		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetClicked();
				
			}

			private void resetClicked() {
				startClicked();
			}
			
		});
		
		
		
		
		btStop = new JButton("Stop");
		btStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stopClicked();
				
			}

			
		});
		
		btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetClicked();
				
			}
		});
		
		lbUhrzeit = new JLabel("Uhrzeit");
		main = new JPanel();
		main.add(btStart);
		main.add(btStop);
		main.add(btReset);
		main.add(lbUhrzeit);
		
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(main,BorderLayout.CENTER);
		
		setContentPane(contentPane);
		
	}
	
	private void stopClicked() {
		System.out.println("Stop klick");
		dieUhr.stop();
	}
	
	private void startClicked() {
		System.out.println("Start klick");
		dieUhr.start();
	}

	private void resetClicked() {
		System.out.println("Reset klick");
	}

	public void zeigeZeit(String format) {
		lbUhrzeit.setText(format);
		
	}

}
