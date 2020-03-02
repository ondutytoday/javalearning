package rabbit;

public class RabbitLab {
	public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();        
    }
}

