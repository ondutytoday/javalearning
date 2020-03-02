package synchronizedBlocks;

import java.util.Date;
import java.util.concurrent.*;

public class Main {
	static long numsOfOperations = 10_000_000_000L;	
	static int numOfThreads = Runtime.getRuntime().availableProcessors();
	public static void main(String[] args) {		
		System.out.println (new Date ());
		ForkJoinPool pool = new ForkJoinPool(numOfThreads);
		pool.invoke(new MyFork(0, numsOfOperations));
		System.out.println (new Date ());
	}
	
	static class MyFork extends RecursiveTask<Long> {
		long from, to;

		
		public MyFork(long from, long to) {
			super();
			this.from = from;
			this.to = to;
		}


		@Override
		protected Long compute() {
			// если разбито на правильное количество частей
			if ((to-from) <= numsOfOperations/numOfThreads) {
				long j = 0;
				for (long i = from; i < to; i++) {
					j+=i;
				}
				return j;
			}
			//если еще можнго разбить
			else {
				long middle = (to+from)/2;
				MyFork firstHalf = new MyFork(from, middle);
				firstHalf.fork();
				MyFork secondHalf = new MyFork(middle+1, to);
				secondHalf.fork();
				long secondValue = secondHalf.compute();
				return firstHalf.join() + secondValue;
			}
		}
		
	}
}
