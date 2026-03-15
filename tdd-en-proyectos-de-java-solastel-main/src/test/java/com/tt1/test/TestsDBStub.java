package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsDBStub {
	
	private DBStub db;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() { db= new DBStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInsertarYLeerToDo() {
		ToDo t = new ToDo("Test", "D", LocalDate.now(), false);
		db.createToDo(t);
		assertEquals(t, db.readToDo("Test"));
	}

	@Test
	void testInsertarEmail() {
		db.insertarEmail("test@unirioja.es");
		assertTrue(db.listarEmails().contains("test@unirioja.es"));
	}
}
