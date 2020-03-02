package serialization;

import java.io.Serializable;

public class Mama implements Serializable {
    String mamaName;

    public Mama(String mamaName) {
        this.mamaName = mamaName;
    }

    @Override
    public String toString() {
        return mamaName;
    }
}
