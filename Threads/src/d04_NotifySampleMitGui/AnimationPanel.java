package d04_NotifySampleMitGui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

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