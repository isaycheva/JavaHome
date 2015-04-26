package vectors;

import java.util.Iterator;

public class SynchronizedVector implements Vector {

    private Vector vector;

    public SynchronizedVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public synchronized double getElement(int index) {
        return vector.getElement(index);
    }

    @Override
    public synchronized void setElement(int index, double value) {
        vector.setElement(index, value);
    }

    @Override
    public synchronized int getSize() {
        return vector.getSize();
    }

    @Override
    public synchronized double getNorm() {
        return vector.getNorm();
    }

    @Override
    public synchronized Iterator iterator() {
        return vector.iterator();
    }

    @Override
    public synchronized int hashCode() {
        return vector.hashCode();
    }

    @Override
    public synchronized boolean equals(Object obj) {
        return vector.equals(obj);
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
        return vector.clone();
    }

    @Override
    public synchronized String toString() {
        return vector.toString();
    }
}
