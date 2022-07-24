import java.io.Serializable;

public class nameAndBirthDay implements Serializable{
	public String name = "";
	public String birthMonth = "";
	public String birthDate = "";
	public String birthYear = "";
	public String fullBirth = "";
	
	public void inputName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void putBirth(String date){
		this.fullBirth = date;
	}

	public void putBirth(String month, String date, String year){
		this.birthMonth = month;
		this.birthDate = date;
		this.birthYear = year;
		this.fullBirth = birthMonth + " " + date + ", " + year;
	}
	
	public String getBirth() {
		return fullBirth;
	}
}
