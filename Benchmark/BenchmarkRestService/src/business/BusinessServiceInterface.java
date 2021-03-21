package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Verse;

@Stateless
@Local
@Alternative
public interface BusinessServiceInterface {
	public ArrayList<Verse> returnSelected(String word);
	public ArrayList<Verse> returnAll();

}
