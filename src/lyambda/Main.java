package lyambda;

public class Main {
    public static void main(String[] args) {

        MyNumber num = (y) -> Math.random()*y;
        System.out.println(num.getValue( 100));

    }
}

interface MyNumber {
    double getValue (double j);

}
