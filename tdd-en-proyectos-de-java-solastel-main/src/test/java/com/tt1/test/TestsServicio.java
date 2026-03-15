package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsServicio {

	private Servicio servicio;
	private Repositorio repo;
	private MailerStub mailer;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		DBStub db = new DBStub();
		repo = new Repositorio(db);
		mailer = new MailerStub();
		servicio = new Servicio(repo, mailer);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCrearTareaYListarPendientes() {
		servicio.createToDo("Estudiar", LocalDate.now().plusDays(1));
		assertEquals(1, servicio.listaPendientes().size());
	}
	
	@Test
	void testAlertaAutomaticaAlAñadirEmail() {
		repo.guardarToDo(new ToDo("Vencida", "Desc", LocalDate.now().minusDays(1), false));
		servicio.addEmail("test@unirioja.es");
		assertFalse(servicio.listaPendientes().isEmpty());
	}
	
	@Test
	void testMarcarTareaFinalizada() {
		servicio.createToDo("Hacer práctica", LocalDate.now().plusDays(2));
		servicio.marcarTareaFinalizada("Hacer práctica");
		assertTrue(servicio.listaPendientes().isEmpty());
	}

}
