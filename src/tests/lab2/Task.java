package tests.lab2;

import vectors.ArrayVector;
import vectors.IncompatibleVectorSizesException;
import vectors.Vector;
import vectors.Vectors;

import java.util.Iterator;

public class Task {
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

        System.out.println("x = " + x.toString());
        System.out.println("y = " + y.toString());
        System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        System.out.println("x.max = " + x.max());
        System.out.println("x.min = " + x.min());
        System.out.println("10x = " + vectorToString(Vectors.mult(x, 10.0)));
        System.out.println("|x| = " + x.getNorm());
        System.out.println("<x, y> = " + Vectors.scalarMult(x, y));
    }

    private static String vectorToString(Vector vector) {
        String result = "";

        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            Double value = (Double) iterator.next();
            result += value + " ";
        }
        return result;
    }
}
