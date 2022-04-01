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
		int filmId  = 0;
		String keyword = "";

		while (runMenu) {
			System.out.println("Welcome to the film query app, please pick a menu item");
			System.out.println("1. Look up film by its id.");
			System.out.println("2. Look up a film by a search keyword");
			System.out.println("3. Exit the application");
			//play with this later
			userInput = input.next();

			switch (userInput) {
			case "1":
				System.out.println("Please enter film id:");
				filmId = input.nextInt();
				if (db.findFilmById(filmId) == null) {
					System.out.println("There is no film with the id: " + filmId + "\n");
				} else {
					System.out.println(db.findFilmById(filmId) + "\n");
				}
				break;
			case "2":
				System.out.println("Please enter seach keyword:");
				keyword = input.next();
				List<Film> keywordFilms = db.findFilmsByKeyword(keyword);
				if(keywordFilms.size() == 0) {
					System.out.println("There are no films for the keyword: "+ keyword + "\n");
				}else {
					System.out.println(keywordFilms+"\n");
				}
				break;
			case "3":
				runMenu = false;
				break;
			}
		}
	}

}
