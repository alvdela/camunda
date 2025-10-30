package com.adelaroz.controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "Today is a good day";
	}
	
	@RequestMapping(value = "/execute", method = RequestMethod.GET)
	public String execute() {
		/*
		 * Primero declaramos el ProcessEngine
		 */
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		/*	
		 * Obtenemos la instancia y le proporcionamos el id del proceso 
		 * (se puede ver en propiedades dentro de Camunda Modeler)	
		 */
		ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("first_bpmn_execute");
		
		String item = "Computer";
		
		//De esta forma podemos acceder a una variable en tiempo de ejecución desde bpmn
		instance.setVariable("itemName", item);
		
		//Creamos una businessKey para identificar el proceso que llama desde el bpmn
		instance.businessKey("execute-endpoint");
		
		/*
		 * Finalmente ejecutamos el proceso
		 */
		instance.executeWithVariablesInReturn();		
		
		return "BPMN has executed";
	}
	
	@GetMapping(value = "/tasks")
	public String tasks() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("tasks_execute");
		
		instance.executeWithVariablesInReturn();
		
		return "Tasks BPMN has executed";
	}
}
