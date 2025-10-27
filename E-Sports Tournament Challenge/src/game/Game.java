package game;

public class Game {
	
	private int ID;
	private String name;
	private int basePoint;
	
	public Game(int ID, String name, int basePoint) {
		this.ID = ID;
		this.name = name;
		this.basePoint = basePoint;
	}
	
	public int getId() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBasePoint() {
		return basePoint;
	}
	
	@Override 
	public String toString() {
		return "ID: " + ID + ", Name: " + name + ", Base point: " + basePoint;
	}
	
}
