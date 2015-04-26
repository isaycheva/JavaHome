package threads;

import vectors.Vector;

import java.util.Random;

public class WriteVectorThread extends Thread {

    private Vector vector;

    public WriteVectorThread(Vector vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < vector.getSize(); i++) {
            double value = (random.nextInt(99) + 1) + (random.nextInt(9) + 1) / 10.0;
            vector.setElement(i, value);
            System.out.println("Write: " + value + " to position " + i);
        }
    }
}
