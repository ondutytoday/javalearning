package eclipscode;



public class Main {
	public static void main(String[] args)
	{
		 A.dodo();     // обращение к dodo класса A
	        B.dodo(); 
	}
}
class B {
    public static void dodo() {
        System.out.println("статический метод B");
    }
}

class A extends B {
    public static void dodo() {
        System.out.println("статический метод A");
    }
}

