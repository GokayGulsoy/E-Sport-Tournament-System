package game;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Match {

	private int ID;
	private Game[] matchGames;
	private int rawPoints;
	private int matchPoints;
	private int skillPoints;
	private int bonusPoints;
	private int[] gameRounds;
	private static int idCounter = 0;
	
	public Match() {
		idCounter++;
		ID = idCounter;
		matchPoints = 0;
		skillPoints = 0;
		bonusPoints = 0;
		matchGames = new Game[3];
		gameRounds = new int[3];
		assignRounds();
	}
	
	public int getID() {
		return ID;
	}
	
	public Game[] getGames() {
		return matchGames;
	}
	
	public int[] getRounds() {
		return gameRounds;
	}
	
	public int getRawPoints() {
		return rawPoints;
	}
	
	public int getMatchPoints() {
		return matchPoints;
	}
	
	public int getSkillPoints() {
		return skillPoints;
	}
	
	public int getBonusPoints() {
		return bonusPoints;
	}
	
	public void setRawPoints(int rawPoints) {
		this.rawPoints = rawPoints;
	}
	
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints; 
	}
	
	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
	public void setMatchPoints(int matchPoints) {
		this.matchPoints = matchPoints;
	}
	
	public void assignGames(Game[] games){
		// randomly sampling integers in range 0-100
		Set<Integer> randomGameIndexes = new Random().ints(0, games.length)
				.distinct()
				.limit(3)
				.boxed()
				.collect(Collectors.toSet());
		
	
		int assignedGameIndex = 0;
		for (Integer gameIndex: randomGameIndexes) {
			matchGames[assignedGameIndex] = games[gameIndex];
			assignedGameIndex++;
		}
		
	}
	
	public int computeRawPoints() {
		int rawPoints = 0;
		for (int i = 0; i < matchGames.length; i++) {
			rawPoints += (gameRounds[i] * matchGames[i].getBasePoint());
		}
		
		return rawPoints; 
	}
	
	private void assignRounds() {
		Random rng = new Random();
		
		int gameIndex = 0; 
		while (gameIndex < 3) {
			int numOfRounds = 1 + rng.nextInt(10);
			gameRounds[gameIndex] = numOfRounds;
			gameIndex++;
		}
		
	}
	
	
}
