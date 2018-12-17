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

public class OberFlaeche extends JFrame implements KeyListener{
	
	//
	private ZeichenFlaeche zeichenFlaeche;
	
	//Deklaration f�r Bidirektionale Assoziation
	//Gui-Steuerung
	Steuerung dieSteuerung;
	
	//Komponenten f�r grafische Oberfl�che
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
	
	
	public OberFlaeche(Steuerung s) {
		
		//Die eigene Steuerung zeigt auf 
		//das �bergebene Steuerungsobjekt
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
		bl.setVgap(10);
		bl.setHgap(10);
		
		panelSpielfeld = new JPanel();
		panelSpielfeld.setLayout(null);
		panelSpielfeld.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		
		GridLayout gl = new  GridLayout(10, 1,10,10);
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
		
		btStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickStart();
				
			}
		});
		
	}
	
	public void ereignisTastatur() {
		
	}
	
	public void clickStart() {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ZeichenFlaeche gibZeichenFlaeche(){
		return zeichenFlaeche;
	}

}
