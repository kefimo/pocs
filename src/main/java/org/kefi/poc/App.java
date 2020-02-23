package org.kefi.poc;

import java.time.Duration;
import java.time.Instant;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
       Process process = new Process();
       System.out.println("Start sequential Executions");
       Instant start = Instant.now();
       process.process();
       process.process();
       process.process();
       process.process();
       process.process();
       process.process();
       process.process();
       process.process();
       Instant end = Instant.now();
       Duration duration= Duration.between(start, end);
       System.out.println("Sequential duration: "+duration.getSeconds()+" secondes ");
    }
}
