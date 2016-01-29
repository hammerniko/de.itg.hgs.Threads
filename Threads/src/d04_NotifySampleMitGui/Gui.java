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
                start.setText("Resume");
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
        this.getContentPane().add(aniPanel = new AnimationPanel(),
                BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(start = new JButton("Start"));
        panel.add(stop = new JButton("Pause"));
        stop.setEnabled(false);
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
	}

    class AnimationPanel extends JPanel {
        private Color[] color = new Color[] { Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN, Color.BLACK };
        private int colorIndex = 0;
        private boolean active = false;

        public void increaseIndex() {
            colorIndex = (colorIndex+1)%color.length;
            this.repaint();
        }
        
        public synchronized void setActive(boolean b) {
            this.active = b;
            start.setEnabled(!b);
            stop.setEnabled(b);
            this.notifyAll();
        }
        
        public synchronized boolean isActive() {
            return active;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color[colorIndex]);
            int w = this.getWidth(), h = this.getHeight();
            g.fillRect((w - 50) / 2, (h - 50) / 2, 50, 50);
            
            
        }
    }

    class AnimationThread implements Runnable {
        private AnimationPanel panel;
        public AnimationThread(AnimationPanel panel) {
            this.panel = panel;
        }
        
        public void run() {
            int i = 0;
            while (true) {
                System.out.println(i++ + ". Schleifendurchlauf des Threads");
                if (panel.isActive())
                    panel.increaseIndex();
                else
                    try {
                        synchronized(panel) {
                            panel.wait();
                        }
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
 
