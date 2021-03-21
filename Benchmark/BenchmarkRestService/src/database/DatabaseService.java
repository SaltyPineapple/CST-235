package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;


import beans.Verse;

@Stateless
@Local
@Alternative
public class DatabaseService implements DatabaseInterface{
	String dbURL = "jdbc:mysql://localhost:3306/bible";
	String user = "root";
	String pass = "root";
	
	@Override
	public ArrayList<Verse> returnSelected(String word){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Verse> verses = new ArrayList<Verse>();
		
		
		try {
			
			con = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Database Connection Success!");
			
			stmt = con.prepareStatement("SELECT * FROM bible.bibledb_kjv where VERSETEXT like ?");
			
			stmt.setString(1, "%"+word+"%");
			
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Verse temp = new Verse(rs.getInt("BOOKID"), rs.getInt("CHAPTERNO"), rs.getInt("CHAPTERNO"), rs.getString("VERSETEXT"));
				verses.add(temp);
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return verses;
	}
	
	public ArrayList<Verse> returnAll(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Verse> verses = new ArrayList<Verse>();
		try {
			
		con = DriverManager.getConnection(dbURL, user, pass);
		System.out.println("Database Connection Success!");
		
		// sql 
		stmt = con.createStatement();
		
		// exec
		rs = stmt.executeQuery("SELECT * FROM bible.bibledb_kjv");	
		
		// loop stmt
		while(rs.next()) {
			Verse temp = new Verse(rs.getInt("BOOKID"), rs.getInt("CHAPTERNO"), rs.getInt("CHAPTERNO"), rs.getString("VERSETEXT"));
			verses.add(temp);
		}
		
		
		
		} 
		catch (SQLException e) {
			
			System.out.println("Error");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
			return verses;
		}
	
}
