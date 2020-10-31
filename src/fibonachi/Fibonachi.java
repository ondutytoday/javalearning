package fibonachi;

import java.math.BigInteger;

public class Fibonachi {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger c;

        System.out.println("1: " + a);
        System.out.println("2: " + b);

        for (int i = 3; i < 101; i++) {
            c = a.add(b);
            System.out.println( i + ": " + c);
            a = b;
            b = c;
        }
/*        long a = 0;
        long b = 1;
        long c = 0;
        System.out.println(a);
        System.out.println(b);

        for (int i = 3; i < 101; i++) {
            System.out.println(a+b);
            c = a;
            a = b;
            b = c+b;
        }*/
    }
}
