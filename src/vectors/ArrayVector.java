package vectors;

import java.util.Iterator;

public class ArrayVector implements Vector {
    private double[] elements;

    public ArrayVector(int length) {
        elements = new double[length];
    }

    @Override
    public double getElement(int index) {
        if (index < 0 || index >= elements.length)
            throw new VectorIndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public void setElement(int index, double value) {
        if (index < 0 || index >= elements.length)
            throw new VectorIndexOutOfBoundsException();
        elements[index] = value;
    }

    @Override
    public int getSize() {
        return elements.length;
    }

    public double min() {
        double min = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min)
                min = elements[i];
        }
        return min;
    }

    public double max() {
        double max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max)
                max = elements[i];
        }
        return max;
    }

    @Override
    public double getNorm() {
        try {
            return Math.sqrt(Vectors.scalarMult(this, this));
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();
        }
        return -1.0;
    }

    public void sort() {
        for (int j = 0; j < elements.length; j++) {
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    double swap = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = swap;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < elements.length - 1; i++) {
            result.append(elements[i]).append(", ");
        }
        return result.append(elements[elements.length - 1]).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof ArrayVector))
            return false;
        ArrayVector vector = (ArrayVector) obj;
        if (elements.length != vector.getSize())
            return false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != vector.getElement(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash ^= elements.length;
        for (Double value : elements) {
            long bits = Double.doubleToLongBits(value);
            hash ^= (int) (bits ^ (bits >>> 32));
        }
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        ArrayVector result = (ArrayVector) clone;
        result.elements = elements.clone();
        return result;
    }

    @Override
    public Iterator iterator() {
        return new ArrayVectorIterator();
    }

    private class ArrayVectorIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public Object next() {
            double value = elements[index];
            index++;
            return value;
        }

        @Override
        public void remove() {

        }
    }
}
