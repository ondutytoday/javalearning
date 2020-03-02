package serialization;

import java.io.Serializable;

public class Director extends Worker implements Serializable {
    String way;

    public Director(String name, int age, Mama mama, String way) {
        super(name, age, mama);
        this.way = way;
    }

    @Override
    public String toString() {
        return super.toString() + "Director{" +
                "way='" + way + '\'' +
                '}';
    }
}
