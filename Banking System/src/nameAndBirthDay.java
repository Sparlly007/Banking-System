import java.io.Serializable;

public class nameAndBirthDay implements Serializable{
	public String name = "";
	public String birthMonth = "";
	public int birthDate = 0;
	public int birthYear = 0;
	
	public void inputName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void putBirthMonth(String month) {
		this.birthMonth = month;
	}
	
	public void putBirthDate(int date) {
		this.birthDate = date;
	}
	
	public void putBirthYear(int year) {
		this.birthYear = year;
	}
	
	public String printBirthDay() {
		String date = Integer.toString(birthDate);
		String year = Integer.toString(birthYear);
		return birthMonth + " " + date + ", " + year;
	}
}
