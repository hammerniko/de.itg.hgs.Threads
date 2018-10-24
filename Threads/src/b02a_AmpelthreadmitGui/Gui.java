package b02a_AmpelthreadmitGui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	
	public static final int BREITE = 400;
	public static final int HOEHE = 400;
	
	PanelAmpel a1;
	PanelAmpel a2;
	PanelAmpel a3;
	PanelAmpel a4;
	PanelAmpel a5;
	PanelAmpel a6;
	JButton btStart;
	JButton btStop;
	
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
			
			btStart = new JButton("Start");
			btStart.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
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
			
			contentPane.add(btStart);
			contentPane.add(btStop);
			setContentPane(contentPane);
			
		}

		protected synchronized void stopClicked() {
			System.out.println("Beenden geklickt");
			a1.beendeAmpel();
			a2.beendeAmpel();
			
		}

		protected void startClicked() {
			a1.starteAmpel();
			a2.starteAmpel();
			a3.starteAmpel();
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("****************Gui beendet ");
			// TODO Auto-generated method stub
			super.finalize();
			a1.beendeAmpel();
			a2.beendeAmpel();
			a3.beendeAmpel();
		}
		
		
}
