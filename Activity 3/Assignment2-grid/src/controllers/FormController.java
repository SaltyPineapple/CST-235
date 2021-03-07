package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.ordersBusinessInterface;
import business.timerService;

@ManagedBean
public class FormController {
	
	@Inject
	public ordersBusinessInterface service;
	
	@EJB
	timerService timer;
	
	public String OnSubmit() {
		
		// get user values from input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user1 = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// test purposes, log results to console
		System.out.println("First Name is: " + user1.getFirstName());
		System.out.println("Last Name: " + user1.getLastName());
		
		// prints message to console to tell us which business service selected in beans.xml
		service.test();
		
		// start timer when log is clicked
		
		timer.setTimer(5000);
		
		// put user back in context
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user1);
		
		// show next page
		return "Response.xhtml";
	}
	
	public ordersBusinessInterface getService() {
		return service;
	}
	
	
	

}
