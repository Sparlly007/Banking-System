import java.sql.DriverManager;
import java.sql.*;

public class Password {
	private String pw = "";
	
	public void putPW(String password){
		this.pw = password; 
	}

	public String getPW(){
		return this.pw;
	}

	public boolean contains(String pwd) {
		String password = "";
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			ResultSet rs=myStmt.executeQuery("select * from accounts where pw like '" + pwd + "'");
			while(rs.next())  
				password = rs.getString("pw");
		}catch (Exception exc){
			exc.printStackTrace();
		}
		if(password.equals(pwd))
			return true;
		return false;
	}
	
}
