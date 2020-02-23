package org.kefi.poc;

import java.util.concurrent.TimeUnit;

public class Process {

	public Integer process() throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(3);
		return 1;
	}
}
