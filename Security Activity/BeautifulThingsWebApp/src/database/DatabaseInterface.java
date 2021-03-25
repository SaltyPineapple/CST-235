package database;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Thing;

@Local
public interface DatabaseInterface {
	public int insertOne(Thing t);
	public ArrayList<Thing> readAll();
}
