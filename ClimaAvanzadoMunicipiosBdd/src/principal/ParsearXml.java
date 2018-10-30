package principal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ParsearXml {
	private static SAXBuilder builder=new SAXBuilder();

	public static Document crearXml(String peticion) {
		Document d=new Document();
		try {
			InputStream stream = new ByteArrayInputStream(peticion.getBytes("UTF-8"));
			d=builder.build(stream);
			//con esto hemos creado el document XMLde 1
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
 catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return d;	
	}
	public static Clima obtenerClima(Document doc){
		Clima c= new Clima();
		//doc=builder.build(new File("C:\\IFCT0609\\Directorio_eclipse\\XMLClima\\bin\\localidad_28092.xml"));
		//no hace falta trycatch pork se le pasa directo un Document
		Element raiz=doc.getRootElement();
		Element E_nombre=raiz.getChild("nombre");
		String nombre=E_nombre.getValue();
		c.setNombre(nombre);

		Element e_provincia=raiz.getChild("provincia");
		String provincia=e_provincia.getValue();
		c.setProvincia(provincia);
		//prediccion lleva los dias 
		Element prediccion=raiz.getChild("prediccion");
		List<Element> e_lista_dias=prediccion.getChildren();
		ArrayList<Dia> lista_dias=new ArrayList<>();

		/*for (Element element : e_lista_dias) {
			element
		}*/
		for (int i = 0; i < e_lista_dias.size(); i++) {
			Dia d= new Dia();
			Element e_dia=e_lista_dias.get(i);
			Attribute A_fecha=e_dia.getAttribute("fecha");
			String fecha=A_fecha.getValue();
			d.setFecha(fecha);
			//guardar attributo en 4 pasos
			Element temp=e_dia.getChild("sens_termica");
			String min=temp.getChild("minima").getValue();
			String max=temp.getChild("maxima").getValue();
			d.setMin(min);
			d.setMax(max);
			//en 3 pasos
			//ahora añadimo d a la lista de objetos dia
			lista_dias.add(d);
			
			
			
		}
		//completamos objeto clima
		c.setDias(lista_dias);
		
		
		return c;
	}

}
