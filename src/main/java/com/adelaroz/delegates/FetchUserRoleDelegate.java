package com.adelaroz.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class FetchUserRoleDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		System.out.println("Coming from FetchUserRoleDelegate");
		
		execution.setVariable("userRoleFromDelegate", "software engineer");
		
	}

}
