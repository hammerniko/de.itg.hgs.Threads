package Z7_HP2011A3_Pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class ZeichenFlaeche extends JLabel {

	public static final int ANZAHL_SPALTEN = 15;
	public static final int ANZAHL_ZEILEN = 9;

	private int b;
	private int h;
	Graphics2D g2;

	public ZeichenFlaeche() {
		super();
		setOpaque(true);
		setDoubleBuffered(true);
		setBackground(Color.BLUE);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// G2D Objekt erlaubt mehr Grafikoptionen als das normale Graphics
		// Objekt
		g2 = (Graphics2D) g;

		// Liniendicke Aendern
		// g2.setStroke(new BasicStroke(LINIENDICKE));

		// Methode der Oberklasse (JComponent) ausfuehren
		super.paintComponent(g2);

		// aktuelle Breite und Hoehe merken
		b = this.getWidth();
		h = this.getHeight();

		// g.drawLine(0, 0, 150, 150);
	}

	public void zeichneFresspunkte(int x, int y) {

		Graphics g = getGraphics();
		g.fillOval(x, y, 5, 5);

	}

	public int getB() {
		return b;
	}

	public int getH() {
		return h;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setH(int h) {
		this.h = h;
	}
}
