package vectors;

import java.util.Iterator;

public class UnmodifiableVector implements Vector {

    private Vector vector;

    public UnmodifiableVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public double getElement(int index) {
        return vector.getElement(index);
    }

    @Override
    public void setElement(int index, double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return vector.getSize();
    }

    @Override
    public double getNorm() {
        return vector.getNorm();
    }

    @Override
    public Iterator iterator() {
        return vector.iterator();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone =  super.clone();
        UnmodifiableVector result = (UnmodifiableVector) clone;
        result.vector = (Vector) vector.clone();
        return result;
    }
}
