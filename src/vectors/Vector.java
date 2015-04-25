package vectors;

import java.io.Serializable;
import java.util.Iterator;

public interface Vector extends Serializable {
    double getElement(int index);

    void setElement(int index, double value);

    int getSize();

    double getNorm();

    Iterator iterator();
}
