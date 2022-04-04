package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver not found.");
			throw new RuntimeException("Unable to load MySQL driver class");
		}

	}

	@Override
	public Film findFilmById(int filmId) {
//		Implement the findFilmById method that takes an int film ID, and returns 
//		a Film object (or null, if the film ID returns no data.)
		try {
			String sqltext = "SELECT * FROM film WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

//Film(int id, String title, String description, int release_year, int language_id, int rental_duration, double rental_rate, int length, double replacment_cost, String rating, String specical_features)
			int lang = 0;
			Film newFilm = null;
			if (rs.next()) {
				// change to robs way using setters latter.
				newFilm = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), lang = rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(filmId),
						findLanguageByLanguageId(lang), findCategoryByFilmId(filmId));
			}

			return newFilm;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}


	@Override
	public String findLanguageByLanguageId(int langId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sqltext = "SELECT * From Language WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, langId);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getString("name");

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;

	}

	@Override
	public Actor findActorById(int actorId) {
//		Implement findActorById method that takes an int actor ID, and returns an Actor object (or null, if the actor ID returns no data.)
		try {
			String sqltext = "SELECT * FROM actor WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();

			rs.next();
//			Actor(int id, String first_name, String last_name)
			return new Actor(rs.getInt("Id"), rs.getString("first_name"), rs.getString("last_name"));

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
//		Implement findActorsByFilmId with an appropriate List implementation that will be populated using a ResultSet and returned.
//		Make sure your JDBC code uses PreparedStatement with bind variables instead of concatenating values into SQL strings.
//		SELECT a.first_name, a.last_name, f.id FROM actor a JOIN film_actor ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ? ORDER BY f.title;
		try {
			List<Actor> actorList = new ArrayList();
			String sqltext = "SELECT a.id,  a.first_name, a.last_name, f.id FROM actor a JOIN film_actor fa ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ? ORDER BY f.title";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				actorList.add(new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
			}
			return actorList;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}

	@Override
	public List<Film> findFilmsByKeyword(String string) {
		try {
			List<Film> filmList = new ArrayList<Film>();
			String sqltext = "SELECT * From film WHERE description LIKE ? or title LIKE ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setString(1, "%" + string + "%");
			stmt.setString(2, "%" + string + "%");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				filmList.add(new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features")));
			}
			return filmList;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}

	public String findCategoryByFilmId(int filmId) {
		String category = "";
		try {
			String sqltext = "SELECT f.id,  c.name FROM category c JOIN film_category fc ON c.id = fc.category_id JOIN film f ON fc.film_id = f.id WHERE f.id = ? ORDER BY f.title";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				category= rs.getString("name");
			}else {
				category = "idk";
			}
			
			
			return category;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return category;
	}
}
