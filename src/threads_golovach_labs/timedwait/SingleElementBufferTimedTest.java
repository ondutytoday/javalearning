package threads_golovach_labs.timedwait;

public class SingleElementBufferTimedTest {
	public static void main(String[] args) {
        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        new Thread(new ProducerTimed(1, 1000, buffer, 100)).start();
    }
}
