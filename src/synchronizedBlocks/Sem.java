package synchronizedBlocks;

import java.util.concurrent.*;

public class Sem {
	public static void main(String[] args) throws InterruptedException {
		Exchanger <String> exchanger = new Exchanger<>();
		
		new A(exchanger);
		new B(exchanger);
		
	}
	
	
	public static class A extends Thread {
		Exchanger<String> exchanger;

		public A(Exchanger<String> exchanger) {
			
			this.exchanger = exchanger;
			start();
		}

		@Override
		public void run() {
			try {
				System.out.println(exchanger.exchange("Ghbdtn"));
				sleep(1000);
				System.out.println(exchanger.exchange("skjdhfsj"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public static class B extends Thread {
		Exchanger<String> exchanger;

		public B(Exchanger<String> exchanger) {
	
			this.exchanger = exchanger;
			start();
		}
		
		@Override
		public void run() {
			try {
				System.out.println(exchanger.exchange("123"));
				sleep(1000);
				System.out.println(exchanger.exchange("1233432"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
