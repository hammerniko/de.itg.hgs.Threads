package b02a_AmpelthreadmitGui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	
	public static final int BREITE = 400;
	public static final int HOEHE = 600;
	
	PanelAmpel a1;
	PanelAmpel a2;
	PanelAmpel a3;
	
		
	JPanel contentPane;

		public Gui(){
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(BREITE, HOEHE);
			contentPane = new JPanel();
			contentPane.setLayout(new FlowLayout());
			a1 = new PanelAmpel("A",1000);
			a2 = new PanelAmpel("B",800);
			a3 = new PanelAmpel("C",100);
			
			contentPane.add(a1);
			contentPane.add(a2);
			contentPane.add(a3);
			
			contentPane.setDoubleBuffered(true);
			
			setContentPane(contentPane);
			
		}

		

		
		
		
}
