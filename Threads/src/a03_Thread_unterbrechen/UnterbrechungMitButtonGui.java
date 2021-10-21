package a03_Thread_unterbrechen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UnterbrechungMitButtonGui extends JFrame {
	JPanel contentPane;
	JButton btStop;
	JButton btStart;
	ThreadMitInterrupt tm;

	public UnterbrechungMitButtonGui() {
		contentPane = new JPanel();
		btStart = new JButton("Start");
		btStop = new JButton("stop");
		contentPane.add(btStart);
		contentPane.add(btStop);

		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedstart();

			}
		});

		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedStop();
			}
		});

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(contentPane);
		this.pack();
	}

	protected void clickedStop() {
		if (tm != null) {
			tm.interrupt();
			tm = null;
		}
	}

	protected void clickedstart() {
		if (tm == null) {
			tm = new ThreadMitInterrupt();
			tm.start();
		}
	}

	public static void main(String[] args) {
		UnterbrechungMitButtonGui gui = new UnterbrechungMitButtonGui();
		gui.setVisible(true);
	}

}
