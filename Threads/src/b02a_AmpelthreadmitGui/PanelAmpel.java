package b02a_AmpelthreadmitGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAmpel extends JPanel {

	public static final int WARTEN = 0;
	public static final int ROT = 1;
	public static final int ROTGELB = 2;
	public static final int GRUEN = 3;
	public static final int GELB = 4;
	public static final int BLINKEN = 5;
	public static final int AUS = 6;

	LabelLampe lbRot, lbGelb, lbGruen;
	JButton btStart;
	JButton btStop;

	String name;
	JLabel lbName;
	Ampel a;

	public PanelAmpel(String name, int zeit) {
		// Neuer Ampelthread
		a = new Ampel(name, ROT, zeit, zeit, zeit, zeit, this);
		this.name = name;

		btStart = new JButton("On");
		btStop = new JButton("Off");

		setDoubleBuffered(true);
		setLayout(new GridLayout(6, 1));
		lbName = new JLabel(name);
		lbName.setAlignmentX(CENTER_ALIGNMENT);
		lbRot = new LabelLampe(Color.red);
		lbGelb = new LabelLampe(Color.yellow);
		lbGruen = new LabelLampe(Color.green);
		add(lbName);
		add(lbRot);
		add(lbGelb);
		add(lbGruen);
		add(btStart);
		add(btStop);

		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				starteAmpel();

			}
		});

		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stoppeAmpel();

			}
		});

	}

	public void setzeAmpel(int farbe) {
		switch (farbe) {
		case ROT:
			System.out.println("Rot gesetzt");
			lbRot.einschalten();
			lbGelb.ausschalten();
			lbGruen.ausschalten();
			break;
		
		case ROTGELB:
			System.out.println("Rot gesetzt");
			lbRot.einschalten();
			lbGelb.einschalten();
			lbGruen.ausschalten();
			break;
			
		case GELB:
			lbGelb.einschalten();
			System.out.println("Gelb gesetzt");
			lbGruen.ausschalten();
			lbRot.ausschalten();
			break;
		case GRUEN:
			lbGruen.einschalten();
			lbRot.ausschalten();
			lbGelb.ausschalten();
			break;

		case AUS:
			lbGruen.ausschalten();
			lbRot.ausschalten();
			lbGelb.ausschalten();
			break;
		default:

			break;
		}

	}

	@Override
	protected void printComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString(name, 10, 10);

	}

	public void stoppeAmpel() {
		lbGruen.ausschalten();
		lbRot.ausschalten();
		lbGelb.ausschalten();
		a.stop();
	}

	public void starteAmpel() {
		a.start();
	}
}
