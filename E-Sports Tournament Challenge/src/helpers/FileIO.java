package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import game.Game;
import game.Gamer;

public class FileIO {

	private static final String gamersCSVPath = "..\\E-Sports Tournament Challenge\\gamers.csv";
	private static final String gamesCSVPath = "..\\E-Sports Tournament Challenge\\games.csv";

	/**
	 * method that reads gamer information from gamers.csv file and returns an array
	 * of Gamer objects with that information
	 * 
	 * @return array of gamer objects
	 */
	public static Gamer[] readGamersFromCSVFile() {

		File gamerCSVFile = new File(gamersCSVPath);
		Scanner fileReader = null;

		int numOfLines = 0;
		try {
			fileReader = new Scanner(gamerCSVFile);

			fileReader.nextLine();
			while (fileReader.hasNextLine()) {
				fileReader.nextLine();
				numOfLines++;
			}

			fileReader.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File with name gamers.csv not found !!");
			System.exit(0);
		}

		Gamer[] gamers = new Gamer[numOfLines];

		try {

			fileReader = new Scanner(gamerCSVFile);

			fileReader.nextLine();

			int gamerIndex = 0;
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				int ID = Integer.parseInt(tokenizer.nextToken());
				String nickName = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				String phone = tokenizer.nextToken();
				int experienceYears = Integer.parseInt(tokenizer.nextToken());

				Gamer gamer = new Gamer(ID, nickName, name, phone, experienceYears);
				gamers[gamerIndex] = gamer;
				gamerIndex++;

			}

			fileReader.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File with name games.csv not found !!");
			System.exit(0);
		}

		return gamers;
	}

	/**
	 * method that reads game info from games.csv file and returns an array of Game
	 * objects with that information
	 * 
	 * @return array of Game objects
	 */
	public static Game[] readGamesFromCSVFile() {
		File gamesCSVFile = new File(gamesCSVPath);
		Scanner fileReader = null;

		int numOfGames = 0;
		try {
			fileReader = new Scanner(gamesCSVFile);

			fileReader.nextLine();
			while (fileReader.hasNextLine()) {
				fileReader.nextLine();
				numOfGames++;
			}

			fileReader.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File with name gamers.csv not found !!");
			System.exit(0);
		}

		Game[] games = new Game[numOfGames];
		int gameIndex = 0;

		try {

			fileReader = new Scanner(gamesCSVFile);

			fileReader.nextLine();
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				int ID = Integer.parseInt(tokenizer.nextToken());
				String gameName = tokenizer.nextToken();
				int basePointPerRound = Integer.parseInt(tokenizer.nextToken());

				Game game = new Game(ID, gameName, basePointPerRound);
				games[gameIndex] = game;
				gameIndex++;
			}

			fileReader.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File with name gamers.csv not found !!");
			System.exit(0);
		}

		return games;
	}

}
