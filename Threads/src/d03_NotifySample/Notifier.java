package d03_NotifySample;
import java.util.Date;

public class Notifier implements Runnable {

	Message message;

	public Notifier(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.print("Notifier schläft ...");
		try {
			for (int i = 0; i < 15; i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		synchronized (message) {
			//message.setText("Notifier nach der Pause");
			System.out.println("Notifier ruft notifying auf um:\t" + new Date());
			message.notify();
		}

	}

}