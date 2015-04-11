package vectors;

public class ArrayVectorFactory implements VectorFactory {
    @Override
    public Vector createInstance(int i) {
        return new ArrayVector(i);
    }
}
