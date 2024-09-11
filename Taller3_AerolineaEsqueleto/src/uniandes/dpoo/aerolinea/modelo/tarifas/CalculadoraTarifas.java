package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	
	public static final double IMPUESTO = 0.28;
	
	public CalculadoraTarifas() {
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente); 
	
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);
	
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int base = calcularCostoBase(vuelo, cliente);
		double porce = calcularPorcentajeDescuento​(cliente);
		int descu = (int) (base *(1-porce));
		int impuestos = calcularValorImpuestos(descu);
		return descu+impuestos;
	}
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto Destino = ruta.getDestino();
		
		return Aeropuerto.calcularDistancia(origen, Destino);
		
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		int fini = (int) (costoBase * IMPUESTO);
		return fini;
	}

}
