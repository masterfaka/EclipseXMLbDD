package principal;
import java.util.ArrayList;

public class Clima {

	private String nombre, provincia;
	private ArrayList<Dia> dias;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public ArrayList<Dia> getDias() {
		return dias;
	}
	public void setDias(ArrayList<Dia> dias) {
		this.dias = dias;
	}
	

}
