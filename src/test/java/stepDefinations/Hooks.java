package stepDefinations;

import java.io.IOException;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

	@Before("@UpdateQrCode")
	public void beforeScenario() throws IOException
	{		
		//execute this code Before Each Scenario from Feature File
			

	}

	@After("@UpdateQrCode")
	public void afterScenario() throws IOException
	{		
		//execute this code After Each Scenario from Feature File
			

	}
}
