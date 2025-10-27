package game;

import helpers.FileIO;
import helpers.Medal;

public class PointsBoard {

	private Gamer[] gamers;
	private int[] totalPoints;
	private Medal[] gamerMedals;

	public PointsBoard() {
		gamers = FileIO.readGamersFromCSVFile();
		totalPoints = new int[gamers.length];
		gamerMedals = new Medal[gamers.length];
	}

	/**
	 * method that returns the number of gamers
	 * 
	 * @return int number of gamers in tournament
	 */
	public int getNumberOfGamers() {
		return gamers.length;
	}

	/**
	 * method that returns the Gamer object located at the gamerIndex
	 * 
	 * @param gamerIndex index of gamer in gamers array
	 * @return Gamer object located at the gamerIndex
	 */
	public Gamer getGamer(int gamerIndex) {
		return gamers[gamerIndex];
	}

	/**
	 * method that returns total scores for gamers
	 * 
	 * @return array of integers representing scores
	 */
	public int[] getScores() {
		return totalPoints;
	}

	/**
	 * method that returns the earned medal type for a gamer located at the
	 * gamerIndex
	 * 
	 * @param gamerIndex index of gamer in gamers array
	 * @return Medal that represents one of the Medal (enum) type
	 */
	public Medal getEarnedMedal(int gamerIndex) {
		return gamerMedals[gamerIndex];
	}

	/**
	 * method that retuns the earned medals for gamers as a result of playing 15
	 * matches
	 * 
	 * @return Medal array which are earned by gamers
	 */
	public Medal[] getMedals() {
		return gamerMedals;
	}

	/**
	 * method that sets the total score for each gamer and assigns medals earned to
	 * each gamer
	 * 
	 * @param manager MatchManagement object
	 */
	public void computeTotalPointsAndAssignMedals(MatchManagement manager) {
		for (int i = 0; i < gamers.length; i++) {
			int totalScore = manager.computeMatchPointsForGamer(i, gamers[i]);
			Medal medal = determineMedal(totalScore);

			totalPoints[i] = totalScore;
			gamerMedals[i] = medal;
		}

	}

	/**
	 * method that computes average points per match
	 * 
	 * @param gamerNo index of gamer in gamers array
	 * @return double average points per match
	 */
	public double computeAveragePoints(int gamerNo) {

		return ((double) totalPoints[gamerNo] / 15);
	}

	/**
	 * method that determines the Medal type according to total score of gamer
	 * 
	 * @param totalScore score of gamer over 15 matches
	 * @return Medal (enum) type earned at the end of 15 matches
	 */
	private Medal determineMedal(int totalScore) {
		if (totalScore >= 4000) {
			return Medal.GOLD;
		}

		else if (3500 <= totalScore && totalScore <= 3999) {
			return Medal.SILVER;
		}

		else if (2400 <= totalScore && totalScore <= 3499) {
			return Medal.BRONZE;
		}

		else { // totalScore < 2400
			return Medal.NONE;
		}

	}

	@Override
	public String toString() {
		String pointsBoardReprentation = "----Prints Board----\n";
		for (Gamer gamer : gamers) {
			pointsBoardReprentation += gamer.toString() + "\n";
		}

		return pointsBoardReprentation;
	}

}
