package org.kefi.poc;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppCallable {

	 public static void main( String[] args ) throws InterruptedException
	    {
				
		 	List<Callable<Integer>> listCallables = new ArrayList<Callable<Integer>>();																							;
			Callable<Integer> call1 = () -> {
				Process process = new Process();
				return process.process();
			};
			for(int i =1;i<=9;i++)
			listCallables.add(call1);
			
			
			System.out.println("Start sequential Executions");
		       Instant start = Instant.now();
			
			//ExecutorService service =  Executors.newFixedThreadPool(5);
			ExecutorService service =  Executors.newFixedThreadPool(3);
			//ExecutorService service =  Executors.newFixedThreadPool(10);
			List<Future<Integer>> listFutures = service.invokeAll(listCallables);
			if(listFutures!=null)
			{
				listFutures.stream().forEach(future ->{
					try {
						System.out.println(future.get());
					} catch (InterruptedException | ExecutionException e) {						
						e.printStackTrace();
					}
				});
				
			}
			 Instant end = Instant.now();
		       Duration duration= Duration.between(start, end);
		       System.out.println("Sequential duration: "+duration.getSeconds()+" secondes ");
		  
	    }
}
