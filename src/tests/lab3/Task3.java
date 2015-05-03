package tests.lab3;

import vectors.*;

public class Task3 {
    public static void main(String[] args) throws IncompatibleVectorSizesException {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};

        LinkedListVector x = new LinkedListVector();
        for (double aXdata : xdata) {
            x.add(aXdata);
        }
        LinkedListVector y = new LinkedListVector();
        for (double aYdata : ydata) {
            y.add(aYdata);
        }

        System.out.println("x = " + vectorToString(x));
        System.out.println("y = " + vectorToString(y));
        System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        System.out.println("10x = " + vectorToString(Vectors.mult(x, 10.0)));
        System.out.println("|x| = " + x.getNorm());
        System.out.println("<x, y> = " + Vectors.scalarMult(x, y));

        try {
            System.out.println("x[6] = " + x.getElement(6));
        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName());
        }

        y.remove(1);
        try {
            System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName());
        }
    }

    private static String vectorToString(Vector vector) {
        String result = "";
        for (int i = 0; i < vector.getSize() - 1; i++) {
            result += vector.getElement(i) + ", ";
        }
        return result + vector.getElement(vector.getSize() - 1);
    }
}
