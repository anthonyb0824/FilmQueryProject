package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorList;
	private String language;
	private String category;

	public String getLanguage() {
		return language;
	}

	public List<Actor> getActorList() {
		return actorList;
	}


	public Film() {
		super();
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actorList, String language, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actorList = actorList;
		this.language = language;
		this.category = category;
	}

	public Film(int id, String title, String description, int release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = release_year;
		this.languageId = language_id;
		this.rentalDuration = rental_duration;
		this.rentalRate = rental_rate;
		this.length = length;
		this.replacementCost = replacement_cost;
		this.rating = rating;
		this.specialFeatures = special_features;
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
				+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", actorList=" + actorList + ", language=" + language
				+ ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, languageId, length, rating, releaseYear, rentalDuration, rentalRate,
				replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelease_year() {
		return releaseYear;
	}

	public void setRelease_year(int release_year) {
		this.releaseYear = release_year;
	}

	public int getLanguage_id() {
		return languageId;
	}

	public void setLanguage_id(int language_id) {
		this.languageId = language_id;
	}

	public int getRental_duration() {
		return rentalDuration;
	}

	public void setRental_duration(int rental_duration) {
		this.rentalDuration = rental_duration;
	}

	public double getRental_rate() {
		return rentalRate;
	}

	public void setRental_rate(double rental_rate) {
		this.rentalRate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacment_cost() {
		return replacementCost;
	}

	public void setReplacment_cost(double replacment_cost) {
		this.replacementCost = replacment_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecical_features() {
		return specialFeatures;
	}

	public void setSpecical_features(String specical_features) {
		this.specialFeatures = specical_features;
	}

}
