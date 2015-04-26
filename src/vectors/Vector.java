package vectors;

import java.io.Serializable;
import java.util.Iterator;

public interface Vector extends Serializable, Cloneable {
    double getElement(int index);

    void setElement(int index, double value);

    int getSize();

    double getNorm();

    Iterator iterator();

    Object clone() throws CloneNotSupportedException;
}
