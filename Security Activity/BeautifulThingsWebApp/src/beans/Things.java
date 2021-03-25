package beans;

import java.util.ArrayList;

public class Things {

	ArrayList<Thing> things = new ArrayList<Thing>();
	
	
	
	public void add(Thing thing) {
		things.add(thing);
	}
	
	public void printAll() {
		System.out.println("===============");
		for(Thing thing : things) {
			System.out.println(String.format("ID: %d, Title: %s, Desc: %s, Val: %d", thing.id, thing.title, thing.desc, thing.value));
		}
		System.out.println("===============");
	}
	
	
	
}
