package threads_golovach_labs.timedwait;

import java.util.concurrent.TimeoutException;

public class ProducerTimed implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBufferTimed buffer;
    private final long timeout;

    public ProducerTimed(int startValue, int period, SingleElementBufferTimed buffer, long timeout) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++, timeout);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                return;
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " time out.");
                return;
            }
        }
    }
}
