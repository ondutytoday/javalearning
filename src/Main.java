import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Object object = new Object();
        int hCode;
        hCode = object.hashCode();
        System.out.println(hCode);
        Object object1 = new Object();
        int hCode1;
        hCode1 = object1.hashCode();
        System.out.println(hCode1);


    }

}
