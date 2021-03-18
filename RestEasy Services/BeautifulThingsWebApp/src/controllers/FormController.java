package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Thing;
import business.BusinessServiceInterface;

@ManagedBean
public class FormController {
	
	public FormController() {
		
	}
	
	@Inject
	BusinessServiceInterface bs;
	
	public String onSubmitEdit() throws SQLException {
		// read get values from form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store get values in obj
		Thing t = context.getApplication().evaluateExpressionGet(context,"#{thing}", Thing.class);
		
		System.out.println("Title: " + t.getTitle());
		
		bs.insertOne(t);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("thing", t);
		
		
		// store in db
		
		// put vals in response page
		return "ReponsePage.xhtml";
	}
	
	public ArrayList<Thing> fetchAll() throws SQLException{
		return bs.readAll();
		
		
	}
	
	

}
