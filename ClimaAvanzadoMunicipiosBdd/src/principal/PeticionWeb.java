package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PeticionWeb {
	// ene sta çclase solo le pasamos una direccion y nos devuelve un
		//string
	private static String dir="http://www.aemet.es/xml/municipios/localidad_";
	// recordar añadir .xml


	public static String obtenerDatos(String cod_localidad) {
		dir=dir+cod_localidad+".xml";
		String resultadoURL= new String();
		try {
			URL direccionWeb= new URL(dir);
			//conectamos
			URLConnection conexion_web = direccionWeb.openConnection();
			//leemos con buffer e ImputStream reader: conex.getImpoutStream
			BufferedReader br= new BufferedReader(new InputStreamReader(conexion_web.getInputStream()));
			//seguimos como de construmbe
			String linea=br.readLine();
			while (linea!=null) {
				//lo metemos linea a linea
				resultadoURL+=linea;
				linea=br.readLine();
			}
			//no olvidar cerrar buffer
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultadoURL;
	}
	
}
