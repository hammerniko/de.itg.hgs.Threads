package d03_NotifySample;
import java.util.Date;

public class Notifier implements Runnable {

	Message message;

	public Notifier(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("Notifier schläft ...");
		try {
			Thread.sleep(1000);
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