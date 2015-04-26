package threads;

import vectors.Vector;

public class VectorSynchronizer {

    private Vector vector;
    private volatile int current = 0;
    private final Object lock = new Object();
    private boolean set = false;

    public VectorSynchronizer(Vector vector) {
        this.vector = vector;
    }

    public double read() throws InterruptedException {
        double val;
        synchronized(lock) {
            if (!canRead()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = vector.getElement(current++);
            System.out.println("Read: " + val);
            set = false;
            lock.notifyAll();
        }
        return val;
    }

    public void write(double val) throws InterruptedException {
        synchronized(lock) {
            if (!canWrite()) throw new InterruptedException();
            while (set)
                lock.wait();
            vector.setElement(current, val);
            System.out.println("Write: " + val);
            set = true;
            lock.notifyAll();
        }
    }

    public boolean canRead() {
        return current < vector.getSize();
    }

    public boolean canWrite() {
        return (!set && current < vector.getSize()) || (set &&
                current < vector.getSize() - 1);
    }
}
