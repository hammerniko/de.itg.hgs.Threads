package Z7_HP2011A3_Pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class ZeichenFlaeche extends JLabel implements Grid {

	

	private int spriteNr;
	private int b;
	private int h;
	Graphics2D g2;

	public ZeichenFlaeche() {
		super();
		setOpaque(true);
		setDoubleBuffered(true);
		setBackground(Color.BLUE);
		spriteNr = 1;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// G2D Objekt erlaubt mehr Grafikoptionen als das normale Graphics
		// Objekt
		g2 = (Graphics2D) g;

		// Liniendicke Aendern
		// g2.setStroke(new BasicStroke(LINIENDICKE));

		

		// aktuelle Breite und Hoehe merken
		b = this.getWidth();
		h = this.getHeight();

		// g.drawLine(0, 0, 150, 150);
	}

	public void zeichneFresspunkte(int x, int y) {
		
		Graphics g = getGraphics();
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, FressPunkt.GROESSE_IN_PX, FressPunkt.GROESSE_IN_PX);
	}
	
	public void zeichnePacMan(int x, int y) {
		Graphics2D g = (Graphics2D) getGraphics();
		g.setColor(Color.red);
		
		//Grundkoerper
		g.fillOval(x, y, 20, 20);
		
		//Pacman geht nach rechts
		//und oeffnet und schliesst das Maul
		spriteNr = (spriteNr % 6) +1;
		System.out.println(spriteNr);
		g.setColor(Color.BLUE);
		switch (spriteNr) {
		case 1: g.fillArc(x, y, 20, 20, 45, -90); break; //Ganz auf
		case 2: g.fillArc(x, y, 20, 20, 40, -85); break;
		case 3: g.fillArc(x, y, 20, 20, 30, -70); break;
		case 4: g.fillArc(x, y, 20, 20, 20, -20); break; //geschlossen
		case 5: g.fillArc(x, y, 20, 20, 30, -70); break;
		case 6: g.fillArc(x, y, 20, 20, 40, -85); break;

		default:
			break;
		}
		
		//Pacman Auge
		g.setColor(Color.BLACK);
		
		switch (spriteNr) {
		case 1: g.fillOval(x+5, y+3, 5, 5); break; //
		case 2: g.fillOval(x+6, y+3, 5, 5); break;
		case 3: g.fillOval(x+7, y+3, 5, 5); break;
		case 4: g.fillOval(x+7, y+3, 5, 5); break; //geschlossen
		case 5: g.fillOval(x+7, y+3, 5, 5); break;
		case 6: g.fillOval(x+6, y+3, 5, 5); break; //geschlosse

		default:
			break;
		}
		
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
