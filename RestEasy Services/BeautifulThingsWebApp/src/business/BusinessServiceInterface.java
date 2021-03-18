package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Thing;

@Stateless
@Local
@Alternative

public interface BusinessServiceInterface {
	public int insertOne(Thing t);
	public ArrayList<Thing> readAll();
	public void sendThing(Thing t);
}
