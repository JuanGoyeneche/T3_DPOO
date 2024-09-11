package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	public static final double IMPUESTO = 0.28;
	
	private List<Tiquete> tiquetesSinUsar;
	
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		tiquetesSinUsar = new LinkedList<Tiquete>( );
        tiquetesUsados = new LinkedList<Tiquete>( );
		
	}
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add( tiquete );
	}
	
	public int calcularValorTotalTiquetes() {
		int fini = 0;
		for (int i = 0; i < tiquetesSinUsar.size(); i++) {
			Tiquete tiquete = tiquetesSinUsar.get(i);
			fini += tiquete.getTarifa();
		}
		
		return fini;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for( int i = 0; i < tiquetesSinUsar.size(); i++ ) {
			Tiquete tiquete = tiquetesSinUsar.get(i);
			if (tiquete.getVuelo().equals(vuelo)) {
				tiquetesSinUsar.remove(i);
				tiquetesUsados.add(tiquete);
				i--;
			}
		}
	}

}
