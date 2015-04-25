package vectors;

public class LinkedListVectorFactory implements VectorFactory {
    @Override
    public Vector createInstance(int size) {
        return new LinkedListVector(size);
    }
}
