package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_getFilmById_with_valid_id_returns_correct_film() {
	  Film f = db.findFilmById(1);
	  assertEquals(f.getId(), 1);
  }
  
  @Test
  void test_findLanguageByLanguageId_with_invalid_id_retunrs_null() {
	  String lang = db.findLanguageByLanguageId(-42);
	    assertNull(lang);
  }
  
  @Test
  void test_findLanguageByLanguageId_with_valid_id_retunrs_correct_lang() {
	  String lang = db.findLanguageByLanguageId(1);
	    assertEquals(lang.toLowerCase(), "english");
  }
  
  @Test
  void test_findActorById_with_invalid_id_return_correct_actor() {
	  Actor actor = db.findActorById(-42);
	  assertNull(actor);
  }
  
  @Test
  void test_findActorById_with_valid_id_returns_correct_Actor() {
	  Actor actor = db.findActorById(1);
	  assertEquals(actor.getId(), 1);
  }
  
  @Test
  void test_findActorsByFilmId_with_invalid_id_returns_empty() {
	  List<Actor> actors = db.findActorsByFilmId(-47);
	  List<Actor> temp = new ArrayList<Actor>();
	  assertEquals(actors,temp);
  }
  
  @Test
  void test_findActorsByFilmId_with_valid_id_returns_validArrayList() {
	  List<Actor> actors = db.findActorsByFilmId(1);
	  assertEquals(actors.get(0),new Actor(1, "Penelope", "Guiness") );
  }

}
