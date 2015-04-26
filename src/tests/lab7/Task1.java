package tests.lab7;

import threads.ReadVectorThread;
import threads.WriteVectorThread;
import vectors.Vector;
import vectors.Vectors;

public class Task1 {
    public static void main(String[] args) {
        Vector vector = Vectors.createInstance(5);

        Thread writeThread = new WriteVectorThread(vector);
        writeThread.start();

        Thread readThread = new ReadVectorThread(vector);
        readThread.start();
    }
}
