package principal;

import org.jdom2.Document;



public class Menu {

	public static void main(String[] args) {
		// pedir municipio luego localidad, luego mostrar ese clima
		//si la provicia un solo digito se le pone 0 delante
		//si el municipio es menor de 3 cifras e completa con 0s
		int provincia= EntradaSalida.mostrarProvincias();
		int Municipio=EntradaSalida.mostrarMunicipios(provincia);
		//calculamos codigo provincia+municipio
		String codigoXml=AccesoWeb.calcularC(provincia, Municipio);
		System.out.println(codigoXml);
		//sacamos los datos en string xml

		String URLconXml=PeticionWeb.obtenerDatos(codigoXml);
		//pasamos el xml a doc
		Document doc=ParsearXml.crearXml(URLconXml);
		//parseamos los datos
		Clima c=ParsearXml.obtenerClima(doc);
		//mostramos
		EntradaSalida.mostrarClima(c);

		
	}

}
