package eclipscode;



public class Main {
	public static void main(String[] args)
	{
		 A.dodo();     // ��������� � dodo ������ A
	        B.dodo(); 
	}
}
class B {
    public static void dodo() {
        System.out.println("����������� ����� B");
    }
}

class A extends B {
    public static void dodo() {
        System.out.println("����������� ����� A");
    }
}

