package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private Ruta ruta;
	private String fecha;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;

	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		tiquetes = new HashMap<String, Tiquete>( );
	}
	
	

	public Ruta getRuta() {
		// TODO Auto-generated method stub
		return ruta;
	}

	public String getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		return tiquetes.values();
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		int capa = avion.getCapacidad();
		int tiquetesVen = tiquetes.size();
		
		if (tiquetesVen + cantidad > capa) {
			throw new VueloSobrevendidoException(this);
		}
		
		int precio = calculadora.calcularTarifa(this, cliente);
		int fini = 0;
		for (int i = 0; i<cantidad; i++) {
			Tiquete codi = GeneradorTiquetes.generarTiquete(this, cliente, precio);
			tiquetes.put(codi.getCodigo(), codi);
			cliente.agregarTiquete(codi);
			fini += precio;
		}
		return fini;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO 
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Vuelo otro = (Vuelo) obj;
		return ruta.equals(otro.getRuta()) && avion.equals(otro.getAvion()) && fecha.equals(otro.getFecha());
		
	}
	
}
