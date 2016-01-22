package b02a;

import java.awt.FlowLayout;

import javax.swing.*;

public class Gui extends JFrame {
	
	public static final int BREITE = 400;
	public static final int HOEHE = 400;
	
	JPanel contentPane;

		public Gui(){
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(BREITE, HOEHE);
			contentPane = new JPanel();
			contentPane.setLayout(new FlowLayout());
			PanelAmpel a1 = new PanelAmpel("A",1000);
			PanelAmpel a2 = new PanelAmpel("B",800);
			PanelAmpel a3 = new PanelAmpel("C",900);
			contentPane.add(a1);
			contentPane.add(a2);
			contentPane.add(a3);
			
			setContentPane(contentPane);
			
		}
}
