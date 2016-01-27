package d03_NotifySample;
import java.util.Date;

public class Waiter implements Runnable {

	Message message;

	public Waiter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		synchronized (message) {
			try {
				System.out.println("Waiter wartet auf notifier");
				message.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Waiter ist fertig um: \t\t" + new Date());
		System.out.println("Waiter bekommt message: \t" + message.getText());
	}

}