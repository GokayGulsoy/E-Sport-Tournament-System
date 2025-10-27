package game;

import helpers.FileIO;

public class MatchManagement {

	private Match[][] gamerMatches;
	private Game[] games;

	public MatchManagement(int numOfGamers) {
		gamerMatches = new Match[numOfGamers][15];
		games = FileIO.readGamesFromCSVFile();
		generateMatches();
	}

	/**
	 * method that returns Match object with row index as gamerIndex and column
	 * index as matchIndex
	 * 
	 * @param gamerIndex index of gamer (row) in gamerMatches 2D-array
	 * @param matchIndex index of match (column) in gamerMatches 2D-array
	 * @return
	 */
	public Match getMatch(int gamerIndex, int matchIndex) {
		return gamerMatches[gamerIndex][matchIndex];
	}

	/**
	 * method that randomly chooses three games to play in a match
	 */
	private void generateMatches() {
		for (int i = 0; i < gamerMatches.length; i++) {
			for (int j = 0; j < 15; j++) {
				Match match = new Match();
				match.assignGames(games);

				gamerMatches[i][j] = match;
			}
		}
	}

	/**
	 * method that computes total points for a specific gamer
	 * 
	 * @param gamerNo index of gamer (row) in gamerMatches 2D-array
	 * @param gamer   gamer object for which totalPoints to be computed
	 * @return int total points for a gamer over 15 matches
	 */
	public int computeMatchPointsForGamer(int gamerNo, Gamer gamer) {
		int totalPoints = 0;
		for (int i = 0; i < 15; i++) {
			Match match = gamerMatches[gamerNo][i];

			int rawPoints = match.computeRawPoints();
			int skillPoints = (int) Math.floor((rawPoints * (1 + (Math.min(gamer.getExperienceYears(), 10) * 0.02))));

			int bonusPoints = determineBonusPoints(rawPoints);
			int matchPoints = skillPoints + bonusPoints;

			match.setRawPoints(rawPoints);
			match.setSkillPoints(skillPoints);
			match.setBonusPoints(bonusPoints);
			match.setMatchPoints(matchPoints);

			totalPoints += matchPoints;
		}

		return totalPoints;
	}

	/**
	 * method that determines bonus points with respect to raw points
	 * 
	 * @param rawPoints raw points computed via (basePoints * rounds9
	 * @return int bonus point computed according to rawPoints value
	 */
	private int determineBonusPoints(int rawPoints) {
		if (0 <= rawPoints && rawPoints <= 199) {
			return 10;
		}

		else if (200 <= rawPoints && rawPoints <= 399) {
			return 25;
		}

		else if (400 <= rawPoints && rawPoints <= 599) {
			return 50;
		}

		else { // rawPoints >= 600
			return 100;

		}

	}

}
