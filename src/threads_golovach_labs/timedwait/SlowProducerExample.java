package threads_golovach_labs.timedwait;

public class SlowProducerExample {
	public static void main(String[] args) {
        int producerSleepTime = 1500;
        int consumerWaitTime = 1000;

        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        new Thread(new ProducerTimed(1, producerSleepTime, buffer, 100), "Producer").start();
        new Thread(new ConsumerTimed(buffer, consumerWaitTime), "Consumer").start();
    }
}
