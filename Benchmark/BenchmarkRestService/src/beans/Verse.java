package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@XmlRootElement(name="verse")
public class Verse {
	private int BOOKID;
	private int CHAPTERID;
	private int VERSENUM;
	private String VERSETEXT;
	

	public Verse(int bOOKID, int cHAPTERID, int vERSENUM, String vERSETEXT) {
		BOOKID = bOOKID;
		CHAPTERID = cHAPTERID;
		VERSENUM = vERSENUM;
		VERSETEXT = vERSETEXT;
	}
	
	
	
	public Verse() {}



	public int getBOOKID() {
		return BOOKID;
	}
	public void setBOOKID(int bOOKID) {
		BOOKID = bOOKID;
	}
	public int getCHAPTERID() {
		return CHAPTERID;
	}
	public void setCHAPTERID(int cHAPTERID) {
		CHAPTERID = cHAPTERID;
	}
	public int getVERSENUM() {
		return VERSENUM;
	}
	public void setVERSENUM(int vERSENUM) {
		VERSENUM = vERSENUM;
	}
	public String getVERSETEXT() {
		return VERSETEXT;
	}
	public void setVERSETEXT(String vERSETEXT) {
		VERSETEXT = vERSETEXT;
	}
	
	
}
