package threads_golovach_labs.timedwait;

public class SingleConsumerTimedExample {
	public static void main(String[] args) {
        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        new Thread(new ConsumerTimed(buffer, 3000), "Consumer").start();
    }
}
