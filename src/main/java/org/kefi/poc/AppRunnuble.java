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

public class AppRunnuble {


		 public static void main( String[] args ) throws InterruptedException
		    {
					
			 Instant start = Instant.now();																						
			 	Runnable runs = () -> {
					Process process = new Process();
					try {
						Integer result = process.process();
						System.out.println(result);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					//return process.process();
				};
				
				
				
				System.out.println("Start sequential Executions");
			       
				
				//ExecutorService service =  Executors.newFixedThreadPool(5);
				//ExecutorService service =  Executors.newFixedThreadPool(3);
				ExecutorService service =  Executors.newFixedThreadPool(10);
			//	service.invokeAll(listR
				List<Future> results = new ArrayList<Future>();
				for(int i =1;i<=9;i++)
					{
				Future result = service.submit(runs);
				results.add(result); 
					}
				
				results.stream().forEach(future -> {
					try {
						future.get();
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
					}
				}
				);
				
				 service.shutdown();
				 Instant end = Instant.now();
			       Duration duration= Duration.between(start, end);
			       System.out.println("Sequential duration: "+duration.getSeconds()+" secondes ");
			  
			      
		    }
	
}
