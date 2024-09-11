package uniandes.dpoo.aerolinea.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public class RutaTest {
	
	
	
	private static Aeropuerto origen; 
	private static Aeropuerto destino;
	private Ruta ruta1;
	private Ruta ruta2;
	private Ruta ruta3;
	private Ruta ruta4;
	private Ruta ruta5;
	private Ruta ruta6;
	private Ruta ruta7;
	
	@BeforeAll
	static void crearAeropuertos() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception;
	
	@Test
	void testGetDuracion();
	
	@Test
	void testGetMinutos();
	
	@Test
	void testGetHoras();
	
}
