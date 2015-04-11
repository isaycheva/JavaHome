package vectors;

public class LinkedListVectorFactory implements VectorFactory {
    @Override
    public Vector createInstance(int i) {
        return new LinkedListVector(i);
    }
}
