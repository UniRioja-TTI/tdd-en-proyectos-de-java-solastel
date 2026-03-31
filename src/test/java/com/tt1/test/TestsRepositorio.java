package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsRepositorio {
	
	private Repositorio repo;
	private DBStub db;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		db = new DBStub();
		repo = new Repositorio(db);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMarcarComoCompletado() {
		ToDo t = new ToDo("Tarea", "D", null, false);
		db.createToDo(t);
		repo.marcarCompletado("Tarea");
		assertTrue(db.readToDo("Tarea").getCompletado());
	}

}
