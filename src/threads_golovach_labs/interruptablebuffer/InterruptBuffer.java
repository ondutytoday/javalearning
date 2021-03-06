package threads_golovach_labs.interruptablebuffer;

public class InterruptBuffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) {
        while (elem != null) {
            try {
                // ?
                producers = new ThreadNode(Thread.currentThread(), producers);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            consumers = consumers.nextNode;
            // ?
        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                // ?
                consumers = new ThreadNode(Thread.currentThread(), consumers);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            producers = producers.nextNode;
            // ?
        }
        return result;
    }
}
