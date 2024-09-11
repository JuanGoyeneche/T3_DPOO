package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

    public final int COSTO_POR_KM_CORPORATIVO = 900;
    public final int COSTO_POR_KM_NATURAL = 600;
    public final double DESCUENTO_GRANDES = 0.2;
    public final double DESCUENTO_MEDIANAS = 0.1;
    public final double DESCUENTO_PEQ = 0.02;

    public CalculadoraTarifasTemporadaBaja() {
        
    }

    
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        Ruta ruta = vuelo.getRuta();
        Aeropuerto ae1 = ruta.getOrigen();
        Aeropuerto ae2 = ruta.getDestino();
        int disti = Aeropuerto.calcularDistancia(ae1, ae2);
        
        if (cliente instanceof ClienteCorporativo) {
            return disti * COSTO_POR_KM_CORPORATIVO;
        } else {
            return disti * COSTO_POR_KM_NATURAL;
        }
    }

   
    public double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
            int tamanoEmpresa = clienteCorporativo.getTamanoEmpresa();
            if (tamanoEmpresa == 1) {
                return DESCUENTO_GRANDES;
            } else if (tamanoEmpresa == 2) {
                return DESCUENTO_MEDIANAS;
            } else if (tamanoEmpresa == 3) {
                return DESCUENTO_PEQ;
            }
        }
        return 0;
    }
}

