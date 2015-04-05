package vectors;

import java.io.Serializable;

public class ArrayVector implements Vector, Serializable {
    private double[] elements;

    public ArrayVector(int length) {
        elements = new double[length];

    }

    public double getElement(int index) {
        if (index < 0 || index >= elements.length)
            throw new VectorIndexOutOfBoundsException();
        return elements[index];
    }

    public void setElement(int index, double value) {
        if (index < 0 || index >= elements.length)
            throw new VectorIndexOutOfBoundsException();
        elements[index] = value;
    }

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

    public static void main(String[] args) throws IncompatibleVectorSizesException {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};

        ArrayVector x = new ArrayVector(xdata.length);
        for (int i = 0; i < xdata.length; i++) {
            x.setElement(i, xdata[i]);
        }
        ArrayVector y = new ArrayVector(ydata.length);
        for (int i = 0; i < ydata.length; i++) {
            y.setElement(i, ydata[i]);
        }

        System.out.println("x = " + vectorToString(x));
        System.out.println("y = " + vectorToString(y));
        System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        System.out.println("x.max = " + x.max());
        System.out.println("x.min = " + x.min());
        System.out.println("10x = " + vectorToString(Vectors.mult(x, 10.0)));
        System.out.println("|x| = " + x.getNorm());
        System.out.println("<x, y> = " + Vectors.scalarMult(x, y));
    }

    private static String vectorToString(Vector vector) {
        String result = "";
        for (int i = 0; i < vector.getSize() - 1; i++) {
            result += vector.getElement(i) + ", ";
        }
        return result + vector.getElement(vector.getSize() - 1);
    }
}
