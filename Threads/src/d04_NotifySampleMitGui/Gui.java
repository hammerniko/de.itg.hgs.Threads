package d04_NotifySampleMitGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JFrame {
	
    public static void main(String[] args) {
        new Gui();
    }
    
    //Komponenten
    private JButton start, stop;
    private AnimationPanel aniPanel;

    //Konstruktor
    public Gui() {
        initialize();
        
        new Thread(new AnimationThread(aniPanel)).start();
        
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aniPanel.setActive(true);
                
            }
        });
        
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aniPanel.setActive(false);
            }
        });
    }

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 200, 200);
        this.setLocationRelativeTo(null);
        
        aniPanel = new AnimationPanel();
        this.getContentPane().add(aniPanel,BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(start = new JButton("Start"));
        panel.add(stop = new JButton("Pause"));
        
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
	}

    

    
}
 
