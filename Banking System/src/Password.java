import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Password implements Serializable{
	private Map<String, User> security = new HashMap<String, User>();
	
	public void add(String password, User user) {
		security.put(password, user);
		
		if(security.containsKey(password))
			security.replace(password, user);
	}
	
	public User get(String pw) {
		return security.get(pw);
	}
	
	public boolean contains(String pw) {
		if(security.containsKey(pw))
			return true;
		else
			return false;
	}
	
	public static void serializeDataOut(Password pw)throws IOException {
		String filename = "Test.txt";
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pw);
		oos.close();
	}
	
	public static Password serializeDataIn() throws ClassNotFoundException, IOException{
		   String fileName= "Test.txt";
		   FileInputStream fin = new FileInputStream(fileName);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   Password pw= (Password) ois.readObject();
		   ois.close();
		   return pw;
		}
}
