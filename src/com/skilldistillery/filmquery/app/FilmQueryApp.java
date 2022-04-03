package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(10000000);
		System.out.println(film);
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    List<Actor> Actors = db.findActorsByFilmId(film.getId());
//    System.out.println(Actors);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean runMenu = true;
		String userInput = "";
		int filmId = 0;
		String keyword = "";

		System.out.println("Welcome to the film query app, please pick a menu item");
		while (runMenu) {
			System.out.println("1. Look up film by its id.");
			System.out.println("2. Look up a film by a search keyword.");
			System.out.println("3. Exit the application");
			// play with this later
			userInput = input.nextLine().toLowerCase();

			switch (userInput) {
			case "1":
			case "look up film by its id":
				System.out.println("Please enter film id:");
				filmId = input.nextInt();
				if (db.findFilmById(filmId) == null) {
					System.out.println("There is no film with the id: " + filmId + "\n");
				} else {
					Film filmFound = db.findFilmById(filmId);
					System.out.println(filmFound.getTitle() + " " + filmFound.getRelease_year() + " "
							+ filmFound.getRating() + " " + filmFound.getDescription() + " " + filmFound.getLanguage()
							+ " " + filmFound.getActorList() + "\n");
					subMenu(input, filmFound);
				}
				break;
			case "2":
			case "look up a film by a search keyword":
				System.out.println("Please enter seach keyword:");
				keyword = input.next();
				List<Film> keywordFilms = db.findFilmsByKeyword(keyword);
				if (keywordFilms.size() == 0) {
					System.out.println("There are no films for the keyword: " + keyword + "\n");
				} else {
					System.out.println("There are " + keywordFilms.size() + " films with this keyword.");
					subMenu(input, keywordFilms);
				}
				break;
			case "3":
			case "exit":
				runMenu = false;
				break;
			}
		}
	}

	public void subMenu(Scanner input, Film foundFilm) {
		input.nextLine();
		System.out.println("1. Return to main menu.");
		System.out.println("2. View film details.");

		String userInput = "";
		userInput = input.nextLine().toLowerCase();
		switch (userInput) {
		case "1":
		case "return to main menu":
			break;
		case "2":
		case "view film details":
			printAllDetails(foundFilm);
			break;
		}
	}

	public void subMenu(Scanner input, List<Film> keywordFilms) {
		input.nextLine();
		System.out.println("1. Return to main menu.");
		System.out.println("2. View all film details.");

		String userInput = "";
		userInput = input.nextLine().toLowerCase();

		switch (userInput) {
		case "1":
		case "return to main menu":
			break;
		case "2":
		case "view all film details":
			printAllDetails(keywordFilms);
			break;
		}
	}

	public void printAllDetails(List<Film> keywordFilms) {
		for (Film film : keywordFilms) {
			System.out.println(film.toString() + "\n");
		}
	}

	public void printAllDetails(Film foundFilm) {
		System.out.println(foundFilm.toString());
	}
}
