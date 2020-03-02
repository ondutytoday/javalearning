package threads_golovach_labs.singleelementbuffer;

public class _0_SingleProducerExample_1x1 {
	public static void main(String[] args) {
		SingleElementBuffer buffer = new SingleElementBuffer();
		//SingleElementBufferOptimized_A buffer = new SingleElementBufferOptimized_A();
		//SingleElementBufferOptimized_B buffer = new SingleElementBufferOptimized_B();

		new Thread (new Producer(1, 100, buffer)).start();
		new Thread (new Producer(100, 100, buffer)).start();
		new Thread(new Consumer (buffer)).start();
		
	}
}
