package tests.lab7;

import threads.SequentialReadVectorThread;
import threads.SequentialWriteVectorThread;
import threads.VectorSynchronizer;
import vectors.Vector;
import vectors.Vectors;

public class Task2 {
    public static void main(String[] args) {
        Vector vector = Vectors.createInstance(5);
        VectorSynchronizer synchronizer = new VectorSynchronizer(vector);

        Thread writeThread = new Thread(new SequentialWriteVectorThread(synchronizer));
        writeThread.start();

        Thread readThread = new Thread(new SequentialReadVectorThread(synchronizer));
        readThread.start();
    }
}
