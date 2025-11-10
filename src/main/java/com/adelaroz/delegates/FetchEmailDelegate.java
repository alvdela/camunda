package com.adelaroz.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmailDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Coming from FetchEmail Delegate");
		
		System.out.println("userIdInput in FetchEmail delegate :: " + execution.getVariable("userIdInput"));
		
		execution.setVariable("userEmailIdFromDelegate", "alvdela@email.com");
	}

}
