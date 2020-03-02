package eclipscode;

import java.io.Serializable;

public class JavaClassSerializable implements Serializable {

    private int id;
    public static double d;
    private String string;
    private transient String transientString;

    public JavaClassSerializable(int id, double dd, String string, String transientString) {
        this.id = id;
        d = dd;
        this.string = string;
        this.transientString = transientString;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", d=" + d +
                ", string='" + string + '\'' +
                ", transientString='" + transientString + '\'';
    }
}
