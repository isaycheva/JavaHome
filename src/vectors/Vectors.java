package vectors;

public class Vectors {

    public static ArrayVector mult(Vector vector, double n) {
        ArrayVector result = new ArrayVector(vector.getSize());
        for (int i = 0; i < vector.getSize(); i++) {
            result.setElement(i, vector.getElement(i) * n);
        }
        return result;
    }

    public static Vector sum(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException();
        Vector result = new ArrayVector(vector1.getSize());
        for (int i = 0; i < result.getSize(); i++) {
            result.setElement(i, vector1.getElement(i) + vector2.getElement(i));
        }
        return result;
    }

    public static double scalarMult(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException();
        double result = 0.0;
        for (int i = 0; i < vector1.getSize(); i++) {
            result += vector1.getElement(i) * vector2.getElement(i);
        }
        return result;
    }
}
