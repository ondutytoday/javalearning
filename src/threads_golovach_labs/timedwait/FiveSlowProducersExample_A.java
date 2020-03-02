package threads_golovach_labs.timedwait;

public class FiveSlowProducersExample_A {
	public static void main(String[] args) {
		int producerSleepTime = 1200;
        int consumerWaitTime = 1000;
        
        //buffer
        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        
        //consumer
        new Thread(new ConsumerTimed(buffer, consumerWaitTime), "Consumer").start();
        
        //producers
        new Thread(new ProducerTimed(1, producerSleepTime, buffer, 100), "Producer-1").start();
        new Thread(new ProducerTimed(100, producerSleepTime, buffer, 100), "Producer-2").start();
        new Thread(new ProducerTimed(10000, producerSleepTime, buffer, 100), "Producer-3").start();
	}
}
