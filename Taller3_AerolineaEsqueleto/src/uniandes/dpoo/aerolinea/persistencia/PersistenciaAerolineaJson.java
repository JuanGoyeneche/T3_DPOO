package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{
	
	

	public PersistenciaAerolineaJson() {
		
	}

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
		// TODO Auto-generated method stub
		String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
        JSONObject raiz = new JSONObject( jsonCompleto );

        //cargarClientes( aerolinea, raiz.getJSONArray( "clientes" ) );
        cargarAerolinea( aerolinea, raiz.getJSONArray( "aerolinea" ) );
		
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub
		JSONObject jobject = new JSONObject( );

        // Salvar clientes
		//salvarAerolinea( aerolinea, jobject );

        // Salvar tiquetes
		//salvarAerolinea( aerolinea, jobject );

        // Escribir la estructura JSON en un archivo
        PrintWriter pw = new PrintWriter( archivo );
        jobject.write( pw, 2, 0 );
        pw.close( );
		
	}

}
