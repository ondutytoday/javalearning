package threads;

public class EggVoice extends Thread
{
	@Override
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			try{
				sleep(1000);		//ѕриостанавливает поток на 1 секунду
			}catch(InterruptedException e){}
			
			System.out.println("€йцо!");	
		}
		//—лово Ђ€йцої сказано 5 раз
	}
}
