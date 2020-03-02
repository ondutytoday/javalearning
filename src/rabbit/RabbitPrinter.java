package rabbit;

public class RabbitPrinter implements Runnable {
	public static volatile int count = 0;
	
	public void run() {
		System.out.println("New rabbit born!" + count);
		count++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new RabbitPrinter()).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new RabbitPrinter()).start();

	}
}
