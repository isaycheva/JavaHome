package vectors;

public interface Vector {
    double getElement(int index);

    void setElement(int index, double value);

    int getSize();

    double getNorm();
}
