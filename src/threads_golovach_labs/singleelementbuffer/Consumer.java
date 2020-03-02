package threads_golovach_labs.singleelementbuffer;

public class Consumer implements Runnable{
	
	//private final SingleElementBufferOptimized_A buffer;
	//private final SingleElementBufferOptimized_B buffer;
	private final SingleElementBuffer buffer;
	int counter = 1;
	
	public Consumer(SingleElementBuffer buffer) {
	//public Consumer(SingleElementBufferOptimized_A buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			
			try {
				int elem = buffer.get();
				System.out.println(elem + " consumed");
				
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.getMessage());
				return;
			}
		}
		
	}
}
