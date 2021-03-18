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

import beans.Thing;

@Stateless
@Local
@Alternative
public class databaseService implements DatabaseInterface {
	// connect
	String dbURL = "jdbc:mysql://localhost:3306/localdb";
	String user = "root";
	String pass = "root";

	
	public int insertOne(Thing t){
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		
		try {
			con = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Database Connection Success!");
			
			// sql 
			stmt = con.prepareStatement("INSERT INTO localdb.thingstable (thing_Title, thing_Desc, thing_Val) values (?, ?, ?)");
			
			stmt.setString(1, t.getTitle());
			stmt.setString(2, t.getDesc());
			stmt.setInt(3, t.getValue());
			
			// exec
			rowsAffected = stmt.executeUpdate();	
			
			
			// loop stmt
			if(rowsAffected > 0) {
				System.out.println("Rows Inserted: " + rowsAffected);
			}
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		finally {
			//rs.close();
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowsAffected;
	
		
	}
	
	public ArrayList<Thing> readAll(){
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Thing> allThings = new ArrayList<Thing>();
		
		try {
			con = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Database Connection Success!");
			
			// sql 
			stmt = con.createStatement();
			
			// exec
			rs = stmt.executeQuery("SELECT * FROM localdb.thingstable");	
			
			// loop stmt
			while(rs.next()) {
				Thing temp = new Thing(rs.getInt("ID"), rs.getString("thing_Title"), rs.getString("thing_Desc"), rs.getInt("thing_Val"));
				allThings.add(temp);
				
				//System.out.println(String.format("ID: %d, Title: %s, Desc: %s, Val: %d", rs.getInt("ID"), rs.getString("thing_Title"), rs.getString("thing_DESC"), rs.getInt("thing_Val")));
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
		return allThings;
	}
	
}
