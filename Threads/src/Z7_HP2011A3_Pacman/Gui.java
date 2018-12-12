package Z7_HP2011A3_Pacman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class Gui extends JFrame {
	
	//Deklaration für Bidirektionale Assoziation
	//Gui-Steuerung
	Steuerung dieSteuerung;
	
	//Komponenten für grafische Oberfläche
	JPanel contentPane;
	JPanel panelSpielfeld;
	JPanel panelStart;
		
	JButton btStart;
	JTextField tfPunkte;
	JLabel lbPunkte;
	
	//Konstanten
	public static final String TITEL = "PacManMikro";
	public static final String BT_START = "Start";
	public static final String LB_PUNKTE = "Punkte:";
	public static final int SIZE_TEXTFIELD_X = 80;
	public static final int SIZE_TEXTFIELD_Y = 40;
	public static final int SIZE_FRAME_X = 640;
	public static final int SIZE_FRAME_Y = 480;
	
	
	public Gui(Steuerung s) {
		
		//Die eigene Steuerung zeigt auf 
		//das übergebene Steuerungsobjekt
		//damit ist die bidirektionale Assoziation
		//zwischen Gui und Steuerung erstellt
		dieSteuerung = s;
		
		
		//Oberflaechenkomponenten erstellen
		Dimension d = new Dimension(SIZE_FRAME_X, SIZE_FRAME_Y);
		setSize(d);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setTitle(TITEL);
		
		BorderLayout bl = new BorderLayout();
				
		contentPane = new JPanel(bl);
		
		panelSpielfeld = new JPanel();
		panelSpielfeld.setLayout(null);
		
		GridLayout gl = new  GridLayout(8, 1,10,10);
		gl.setHgap(10);
				
		panelStart = new JPanel(gl);
		
		btStart = new JButton(BT_START);
		lbPunkte = new JLabel(LB_PUNKTE);
		
		tfPunkte = new JTextField();
		tfPunkte.setEditable(false);
		tfPunkte.setSize(SIZE_TEXTFIELD_X,SIZE_TEXTFIELD_Y);
		tfPunkte.setBackground(Color.WHITE);
	
		
		
		panelStart.add(btStart);
		panelStart.add(lbPunkte);
		panelStart.add(tfPunkte);
		
		
		contentPane.add(panelSpielfeld, bl.CENTER);
		contentPane.add(panelStart,bl.EAST);
		
		
		
		setContentPane(contentPane);
		
		setVisible(true);
	}

}
