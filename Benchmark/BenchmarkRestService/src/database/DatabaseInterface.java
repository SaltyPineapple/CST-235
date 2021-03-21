package database;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Verse;


@Local
public interface DatabaseInterface {
	public ArrayList<Verse> returnSelected(String word);
	public ArrayList<Verse> returnAll();
} 
