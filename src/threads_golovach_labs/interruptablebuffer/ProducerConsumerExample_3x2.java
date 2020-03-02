package threads_golovach_labs.interruptablebuffer;

public class ProducerConsumerExample_3x2 {
    public static void main(String[] args) {
        InterruptBuffer buffer = new InterruptBuffer();
        Thread[] producers = new Thread[]{
                new Thread(new InterruptedProducer(1, buffer)),
                new Thread(new InterruptedProducer(100, buffer)),
                new Thread(new InterruptedProducer(1000, buffer)),
        };
        for (Thread producer : producers) {
            producer.start();
        }
        Thread[] consumers = new Thread[]{
                new Thread(new InterruptedConsumer(buffer)),
                new Thread(new InterruptedConsumer(buffer)),
        };
        for (Thread consumer : consumers) {
            consumer.start();
        }
    }
}
