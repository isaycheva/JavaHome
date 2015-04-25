package vectors;

public class ArrayVectorFactory implements VectorFactory {
    @Override
    public Vector createInstance(int size) {
        return new ArrayVector(size);
    }
}
