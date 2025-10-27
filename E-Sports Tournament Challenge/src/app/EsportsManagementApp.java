package app;

import game.MatchManagement;
import game.PointsBoard;
import game.Query;

/**
 * class that uses Query class instance to run all queries
 */
public class EsportsManagementApp {

	public static void main(String[] args) {
		PointsBoard pointsBoard = new PointsBoard();
		int numberOfGamers = pointsBoard.getNumberOfGamers();
		MatchManagement matchManager = new MatchManagement(numberOfGamers);

		pointsBoard.computeTotalPointsAndAssignMedals(matchManager);
		Query query = new Query(pointsBoard, matchManager);
		query.runQueries();

	}

}
