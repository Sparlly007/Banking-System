package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import AccountEntity.Balance;
import AccountEntity.User;

public class Service {

    public void register(User user){
        try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root",
					"Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into accounts " + " (id, pw, name, email, checking, savings)" + " values ('"
					+ user.getId() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getEmail()
					+ "', '"
					+ user.getCBalance() + "', '" + user.getSBalance() + "')";
			myStmt.executeUpdate(sql);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
    }

    public User getUser(String pw){
        String name = "";
        String email = "";
		int checking = 0;
		int savings = 0;
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			ResultSet rs=myStmt.executeQuery("select * from accounts where pw like '" + pw + "'");
            if (!rs.isBeforeFirst() ) {    
                return null;
            } 
			while(rs.next()){
                name = rs.getString("name");
                email = rs.getString("email");
				checking = rs.getInt("checking");
				savings = rs.getInt("savings");
            }
		}catch (Exception exc){
			exc.printStackTrace();
		}

		Balance bl = new Balance(checking, savings);
		return new User(name, email, pw, bl);
	}

    public void deleteUser(User user){
        try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root",
					"Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			String sql = "delete from accounts where pw like '" + user.getPassword() + "'";
			myStmt.executeUpdate(sql);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
    }
    
}
