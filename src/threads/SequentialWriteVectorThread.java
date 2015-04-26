package threads;

import java.util.Random;

public class SequentialWriteVectorThread implements Runnable {

    private VectorSynchronizer synchronizer;

    public SequentialWriteVectorThread(VectorSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (synchronizer.canWrite()) {
            double value = (random.nextInt(99) + 1) + (random.nextInt(9) + 1) / 10.0;
            try {
                synchronizer.write(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
