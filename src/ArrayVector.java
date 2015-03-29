public class ArrayVector {
    private double[] elements;

    public ArrayVector(int length) {
        elements = new double [length];

    }

    public double getElement(int index) {
        return elements[index];
    }

    public void setElement(int index, double value){
        elements[index] = value;
    }
    public int getSize(){
        return elements.length;
    }
    public double min(){
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
    public ArrayVector mult (double n) {
        ArrayVector vector = new ArrayVector(elements.length);
        for (int i = 0; i < elements.length; i++){
            vector.setElement(i, elements[i] * n);

        }
        return vector;
    }

    public ArrayVector sum(ArrayVector vector) {
        ArrayVector result = new ArrayVector(elements.length);
        for (int i = 0; i < elements.length; i++) {
            result.setElement(i, elements[i] + vector.getElement(i));
        }
        return result;
    }
}
