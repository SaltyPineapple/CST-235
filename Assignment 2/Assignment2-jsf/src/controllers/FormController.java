package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class FormController {
	
	public String OnSubmit() {
		
		// get user values from input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user1 = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// test purposes, log results to console
		System.out.println("First Name: " + user1.getFirstName());
		System.out.println("Last Name: " + user1.getLastName());
		
		// put user back in context
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user1);
		
		// show next page
		return "Response.xhtml";
	}
	

}
