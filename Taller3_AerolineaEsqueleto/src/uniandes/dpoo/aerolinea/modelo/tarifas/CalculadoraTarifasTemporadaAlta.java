package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM = 1000;
	
	public CalculadoraTarifasTemporadaAlta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
		Aeropuerto ae1 = ruta.getOrigen();
		Aeropuerto ae2 = ruta.getDestino();
		int disti = Aeropuerto.calcularDistancia(ae1, ae2);
        return disti * COSTO_POR_KM;
	}
	
}
