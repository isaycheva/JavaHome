package threads;

import vectors.Vector;

public class ReadVectorThread extends Thread {

    private Vector vector;

    public ReadVectorThread(Vector vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.getSize(); i++) {
            System.out.println("Read: " + vector.getElement(i) + " from position " + i);
        }
    }
}
