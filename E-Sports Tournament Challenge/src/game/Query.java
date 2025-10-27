package game;

import helpers.Medal;

public class Query {

	private PointsBoard pointsBoard;
	private MatchManagement matchManager;

	public Query(PointsBoard pointsBoard, MatchManagement matchManager) {
		this.pointsBoard = pointsBoard;
		this.matchManager = matchManager;
	}

	/**
	 * method that runs all the queries indicated in the requirements spec
	 */
	public void runQueries() {
		displayHighestScoringMatch();
		displayLowestScoringMatchAndMostContributingGame();
		displayMatchWithLowestBonusPoints();
		displayHighestScoringGamer();
		displayTotalTournamentPoints();
		displayMedalDistribution();
	}

	/**
	 * method that displays the highest scoring match
	 */
	private void displayHighestScoringMatch() {

		Match highestScoringMatch = matchManager.getMatch(0, 0);
		int highestScore = highestScoringMatch.getMatchPoints();
		for (int i = 0; i < pointsBoard.getNumberOfGamers(); i++) {
			for (int j = 0; j < 15; j++) {
				Match match = matchManager.getMatch(i, j);
				if (match.getMatchPoints() > highestScore) {
					highestScore = match.getMatchPoints();
					highestScoringMatch = matchManager.getMatch(i, j);
				}
			}
		}

		Game[] games = highestScoringMatch.getGames();
		int[] rounds = highestScoringMatch.getRounds();

		System.out.println("1-Highest Scoring Match");
		System.out.println("Match ID: " + highestScoringMatch.getID());
		System.out.println("Games: [" + games[0].getName() + "," + games[1].getName() + "," + games[2].getName() + "]");
		System.out.println("Rounds: [" + rounds[0] + "," + rounds[1] + "," + rounds[2] + "]");
		System.out.println("Raw Points: " + highestScoringMatch.getRawPoints());
		System.out.println("Skill Points: " + highestScoringMatch.getSkillPoints());
		System.out.println("Bonus Points: " + highestScoringMatch.getBonusPoints());
		System.out.println("Match Points: " + highestScoringMatch.getMatchPoints());

	}

	/**
	 * method that displays the lowest scoring match and most contributing game
	 */
	private void displayLowestScoringMatchAndMostContributingGame() {
		Match lowestScoringMatch = matchManager.getMatch(0, 0);
		int lowestScore = lowestScoringMatch.getMatchPoints();
		for (int i = 0; i < pointsBoard.getNumberOfGamers(); i++) {
			for (int j = 0; j < 15; j++) {
				Match match = matchManager.getMatch(i, j);
				if (match.getMatchPoints() < lowestScore) {
					lowestScore = match.getMatchPoints();
					lowestScoringMatch = matchManager.getMatch(i, j);
				}
			}
		}

		Game[] games = lowestScoringMatch.getGames();
		int[] rounds = lowestScoringMatch.getRounds();

		System.out.println("\n2-Lowest Scoring Match");
		System.out.println("Match ID: " + lowestScoringMatch.getID());
		System.out.println("Games: [" + games[0].getName() + "," + games[1].getName() + "," + games[2].getName() + "]");
		System.out.println("Rounds: [" + rounds[0] + "," + rounds[1] + "," + rounds[2] + "]");
		System.out.println("Raw Points: " + lowestScoringMatch.getRawPoints());
		System.out.println("Skill Points: " + lowestScoringMatch.getSkillPoints());
		System.out.println("Bonus Points: " + lowestScoringMatch.getBonusPoints());
		System.out.println("Match Points: " + lowestScoringMatch.getMatchPoints());

		int indexOfMostContributingGame = 0;
		int highestContribution = games[0].getBasePoint() * rounds[0];

		for (int i = 1; i < games.length; i++) {
			int contributionOfGame = games[i].getBasePoint() * rounds[i];

			if (contributionOfGame > highestContribution) {
				highestContribution = contributionOfGame;
				indexOfMostContributingGame = i;
			}
		}

		System.out.println("Most Contributing Game in this Match:");
		System.out.println("Game: " + games[indexOfMostContributingGame].getName());
		System.out.println("Contribution: " + rounds[indexOfMostContributingGame] + " rounds x "
				+ games[indexOfMostContributingGame].getBasePoint() + " points=" + highestContribution);
	}

	/**
	 * method that displays the match with lowest bonus points
	 */
	private void displayMatchWithLowestBonusPoints() {
		Match matchWithLowestBonusPoints = matchManager.getMatch(0, 0);
		int lowestBonusPoint = matchWithLowestBonusPoints.getBonusPoints();
		for (int i = 0; i < pointsBoard.getNumberOfGamers(); i++) {
			for (int j = 0; j < 15; j++) {
				Match match = matchManager.getMatch(i, j);
				if (match.getBonusPoints() < lowestBonusPoint) {
					lowestBonusPoint = match.getBonusPoints();
					matchWithLowestBonusPoints = matchManager.getMatch(i, j);
				}
			}
		}

		Game[] games = matchWithLowestBonusPoints.getGames();
		int[] rounds = matchWithLowestBonusPoints.getRounds();

		System.out.println("\n3-Match with the Lowest Bonus Points");
		System.out.println("Match ID: " + matchWithLowestBonusPoints.getID());
		System.out.println("Games: [" + games[0].getName() + "," + games[1].getName() + "," + games[2].getName() + "]");
		System.out.println("Rounds: [" + rounds[0] + "," + rounds[1] + "," + rounds[2] + "]");
		System.out.println("Skill Points: " + matchWithLowestBonusPoints.getSkillPoints());
		System.out.println("Bonus Points: " + matchWithLowestBonusPoints.getBonusPoints());
		System.out.println("Match Points: " + matchWithLowestBonusPoints.getMatchPoints());

	}

	/**
	 * method that displays the highest scoring gamer
	 */
	private void displayHighestScoringGamer() {
		int[] totalScores = pointsBoard.getScores();

		int highestScore = totalScores[0];
		int highestScorerIndex = 0;
		for (int i = 1; i < totalScores.length; i++) {
			if (totalScores[i] > highestScore) {
				highestScore = totalScores[i];
				highestScorerIndex = i;
			}
		}

		Gamer highestScoringGamer = pointsBoard.getGamer(highestScorerIndex);
		System.out.println("\n4-Highest-Scoring Gamer");
		System.out.println("Nickname: " + highestScoringGamer.getNickName());
		System.out.println("Nickname: " + highestScoringGamer.getName());
		System.out.println("Total Points: " + highestScore);
		System.out.printf("Average Per Match: %.2f\n", pointsBoard.computeAveragePoints(highestScorerIndex));
		System.out.println("Medal: " + pointsBoard.getEarnedMedal(highestScorerIndex));
	}

	/**
	 * method that displays total tournament points
	 */
	private void displayTotalTournamentPoints() {
		int[] totalScores = pointsBoard.getScores();

		int totalTournamentScore = 0;
		for (int i = 0; i < totalScores.length; i++) {
			totalTournamentScore += totalScores[i];
		}

		System.out.println("\n5-Total Tournament Points");
		System.out.println("Total Tournament Points across 1500 matches: " + totalTournamentScore);
	}

	/**
	 * method that displays medal distribution at the end of the tournament
	 */
	private void displayMedalDistribution() {
		Medal[] medals = Medal.values();

		Medal[] gamerMedals = pointsBoard.getMedals();
		System.out.println("\n6-Medal Distribution");
		for (Medal medal : medals) {
			int medalCount = 0;
			for (int i = 0; i < gamerMedals.length; i++) {
				if (gamerMedals[i] == medal) {
					medalCount++;
				}
			}

			System.out.printf("%s: %d gamers (%.1f%%)\n", medal, medalCount,
					((double) (100 * medalCount) / gamerMedals.length));
		}

	}

}
