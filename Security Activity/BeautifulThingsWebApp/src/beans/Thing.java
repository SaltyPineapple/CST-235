package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@XmlRootElement(name="thing")
public class Thing {
	int id;
	String title;
	String desc;
	int value;
	
	public Thing(int id, String title, String desc, int value) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.value = value;
	}
	
	public Thing() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
