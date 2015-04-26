package threads;

public class SequentialReadVectorThread implements Runnable {

    private VectorSynchronizer synchronizer;

    public SequentialReadVectorThread(VectorSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        while (synchronizer.canRead()) {
            try {
                synchronizer.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
