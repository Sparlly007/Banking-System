
public class NameAndSSecurity {
	public String name = "";
	public long sSecurity = 0;
	
	/*public NameAndSSecurity(String name, int socialSecurity) {
		this.name = name;
		this.sSecurity = socialSecurity;
	}*/
	public void inputName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public long inputSocialSecurity(long number) {
		String input = Long.toString(number);
		if(input.length()==9) {
			long security = Long.parseLong(input);
			this.sSecurity = security;
			return security;
		}else
			return -1;
	}
	
	public long getSocialSecurity() {
		return sSecurity;
	}
}
