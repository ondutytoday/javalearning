package accordion;

public class Lab_Thread_Thread_Play_The_Accordion {
	public static void main(String[] args) throws InterruptedException {
		
			//threadCoordinator
			Runnable coordinator = new Runnable () {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
					//A+B
						Runnable printerA = new PrintRunnable("A  .", 100);
						Thread threadA = new Thread(printerA);
						threadA.start();
						
						Runnable printerB = new PrintRunnable(".  B", 99);
						Thread threadB = new Thread(printerB);
						threadB.start();
						
						try {
							threadA.join();
							threadB.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("-----");
						Runnable printerC = new PrintRunnable("  C", 100);
						Thread threadC = new Thread(printerC);
						threadC.start();
						try {
							threadC.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("-----");
					}
				}
			};
			Thread threadCoordinator = new Thread(coordinator);
			threadCoordinator.start();
				
		
	}
}
