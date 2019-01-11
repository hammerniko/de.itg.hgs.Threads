package Z7_HP2011A3_Pacman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class OberFlaeche extends JFrame implements KeyListener {

	
	// Deklaration fr Bidirektionale Assoziation
	// Gui-Steuerung
	Steuerung dieSteuerung;

	// Komponenten fuer grafische Oberfl�che
	JPanel contentPane;
	JPanel panelSpielfeld;
	JPanel panelStart;

	JButton btStart;
	JTextField tfPunkte;
	JLabel lbPunkte;
	ZeichenFlaeche zeichenFlaeche;

	// Konstanten
	public static final String TITEL = "PacManMikro";
	public static final String BT_START = "Start";
	public static final String LB_PUNKTE = "Punkte:";
	public static final int SIZE_TEXTFIELD_X = 80;
	public static final int SIZE_TEXTFIELD_Y = 40;
	public static final int SIZE_FRAME_X = 640;
	public static final int SIZE_FRAME_Y = 480;

	public OberFlaeche(Steuerung s) {

		// Die eigene Steuerung zeigt auf
		// das uebergebene Steuerungsobjekt
		// damit ist die bidirektionale Assoziation
		// zwischen Gui und Steuerung erstellt
		dieSteuerung = s;

		// Oberflaechenkomponenten erstellen
		Dimension d = new Dimension(SIZE_FRAME_X, SIZE_FRAME_Y);
		setSize(d);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setTitle(TITEL);

		BorderLayout bl = new BorderLayout();

		contentPane = new JPanel(bl);
		bl.setVgap(10);
		bl.setHgap(10);

		panelSpielfeld = new JPanel();
		panelSpielfeld.setLayout(null);
		panelSpielfeld.setOpaque(false);
		panelSpielfeld.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		 		
		GridLayout gl = new GridLayout(10, 1, 10, 10);
		gl.setHgap(10);

		panelStart = new JPanel(gl);

		btStart = new JButton(BT_START);
		lbPunkte = new JLabel(LB_PUNKTE);

		tfPunkte = new JTextField();
		tfPunkte.setEditable(false);
		tfPunkte.setSize(SIZE_TEXTFIELD_X, SIZE_TEXTFIELD_Y);
		tfPunkte.setBackground(Color.WHITE);

		panelStart.add(btStart);
		panelStart.add(lbPunkte);
		panelStart.add(tfPunkte);

		contentPane.add(panelSpielfeld, bl.CENTER);
		contentPane.add(panelStart, bl.EAST);

		setContentPane(contentPane);
		setVisible(true);

		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickStart();

			}
		});

	}

	public void ereignisTastatur(KeyEvent ke) {
		
		System.out.println("Pressed");
		
		int keyCode = ke.getKeyCode();
		int richtung=SpielFigur.STOPP;
		
		switch( keyCode ) { 
        case KeyEvent.VK_UP:
            richtung = SpielFigur.OBEN;
            break;
        case KeyEvent.VK_DOWN:
        	richtung = SpielFigur.UNTEN;
            break;
        case KeyEvent.VK_LEFT:
        	richtung = SpielFigur.LINKS;
            break;
        case KeyEvent.VK_RIGHT :
        	richtung=SpielFigur.RECHTS;
            break;
            
        default: break;     
		} 
        dieSteuerung.verarbeiteTastenDruck(richtung);   
	}

	public void clickStart() {
		System.out.println("Start clicked");
		dieSteuerung.starteSpiel();
		btStart.setEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		ereignisTastatur(ke);
     }

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub

	}

	public ZeichenFlaeche gibZeichenFlaeche() {
		return zeichenFlaeche;
	}

	public void schreibePunkte(int punktePacman) {
		tfPunkte.setText("" + punktePacman);

	}

	public void zeigeMeldung(String meldung) {

		JOptionPane.showMessageDialog(this, meldung);

	}

	public void setZeichenflaeche(ZeichenFlaeche zf) {
		System.out.println("Zeichenflaeche gesetzt");
		zeichenFlaeche = zf;
		
		zeichenFlaeche.setB(panelSpielfeld.getWidth());
		zeichenFlaeche.setH(panelSpielfeld.getHeight());
		
		zeichenFlaeche.setSize(panelSpielfeld.getWidth(),panelSpielfeld.getHeight());
		if (zf != null) {
			panelSpielfeld.add(zf);
			this.revalidate();
			this.repaint();
		}
		else {
			System.out.println("Zeichenflaeche = null");
		}
		
		this.addKeyListener(this);

		
	}

	public void setFocus() {
		this.requestFocus();
		
	}

	
	
}
