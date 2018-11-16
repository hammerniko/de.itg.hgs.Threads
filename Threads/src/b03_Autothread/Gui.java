package b03_Autothread;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JFrame {
	
	public static final int BREITE = 400;
	public static final int HOEHE = 600;
	
	JPanel karte;
	LabelAuto lbAuto;
	JButton btTest;
	
		
	JPanel contentPane;

		public Gui(){
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(BREITE, HOEHE);
			contentPane = new JPanel();
			btTest = new JButton("Test");
			karte = new JPanel();
			lbAuto = new LabelAuto(0, 0);
			karte.setLayout(new FlowLayout());
			karte.add(lbAuto);
			karte.add(btTest);
			
			
			contentPane.setLayout(new BorderLayout());
			contentPane.add(karte, BorderLayout.CENTER);
			
			
			setContentPane(contentPane);
			
		}

		

		
		
		
}
