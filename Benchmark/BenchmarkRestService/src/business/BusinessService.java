package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Verse;
import database.DatabaseInterface;


@Stateless
@Local
@Alternative
public class BusinessService implements BusinessServiceInterface {

	@Inject
	DatabaseInterface db;
	
	@Override
	public ArrayList<Verse> returnSelected(String word) {
		// TODO Auto-generated method stub
		return db.returnSelected(word);
	}
	
	public ArrayList<Verse> returnAll(){
		return db.returnAll();
	}

}
