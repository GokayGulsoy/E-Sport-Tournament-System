package game;

public class Gamer {

	private int ID;
	private String nickName;
	private String name;
	private String phoneNumber;
	private int experienceYears; 
	
	public Gamer(int ID, String nickName, String name, String phoneNumber, int experienceYears) {
		this.ID = ID;
		this.nickName = nickName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.experienceYears = experienceYears;
	}

	public int getID() {
		return ID;
	}

	public String getNickName() {
		return nickName;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getExperienceYears() {
		return experienceYears;
	}
	
	@Override
	public String toString() {
		return "ID: " + ID +  ", Nickname: " + nickName + ", Name: " + name + ", Phone number: " + phoneNumber + ", Experience Years: " + experienceYears;
	}
	
}
