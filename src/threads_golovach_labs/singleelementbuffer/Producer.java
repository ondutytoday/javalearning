package threads_golovach_labs.singleelementbuffer;

public class Producer implements Runnable {
	//�������� ���������� � ������
	private int startValue;
	//�������� �� �������
	private final int period;
	//������
	//private final SingleElementBufferOptimized_A buffer;
	//private final SingleElementBufferOptimized_B buffer;
	private final SingleElementBuffer buffer;
	int counter = 1;
	
	public Producer(int startValue, int period, SingleElementBuffer buffer) {
	//public Producer(int startValue, int period, SingleElementBufferOptimized_A buffer) {	
		// TODO Auto-generated constructor stub
		this.startValue = startValue;
		this.period = period;
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				System.out.println(startValue + " produced");
				buffer.put(startValue++);
				Thread.sleep(period);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.getMessage());
				return;
			}
		}
		
	}
}
