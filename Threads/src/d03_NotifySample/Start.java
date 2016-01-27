package d03_NotifySample;

public class Start {
	

		public static void main(String[] args) {

			Message message = new Message("--- Hallo ---");

			Waiter waiter = new Waiter(message);
			Thread waiterThread = new Thread(waiter, "waiterThread");
			waiterThread.start();

			Notifier notifier = new Notifier(message);
			Thread notifierThread = new Thread(notifier, "notifierThread");
			notifierThread.start();

		}

	}

