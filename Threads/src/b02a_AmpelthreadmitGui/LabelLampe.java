package b02a_AmpelthreadmitGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class LabelLampe extends JLabel {
	Graphics g;
	private Color farbeAn, farbeAus;
	private Color aktFarbe;
	private int groesse;

	public LabelLampe(Color color){
		farbeAn = color;
		farbeAus = Color.gray;
		aktFarbe = farbeAus;
		groesse = 60;
		setPreferredSize(new Dimension(groesse, groesse));
		setOpaque(true);
		setDoubleBuffered(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(aktFarbe);
		int w = getWidth();
		int h = getHeight();
		g.fillOval(0, 0, w, h);
		
	}
	
	public void einschalten(){
		aktFarbe = farbeAn;
		repaint();
	}
	
	public void ausschalten(){
		aktFarbe = farbeAus;
		repaint();
	}
	
	
}
