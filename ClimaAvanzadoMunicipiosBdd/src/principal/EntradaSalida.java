package principal;

import java.util.ArrayList;
import java.util.Scanner;


public class EntradaSalida {
	private static Scanner sc=new Scanner(System.in);

	public static int mostrarProvincias() {
		
		System.out.println("Elige provincia nº:");
		AccesoBdd.mostrarProvincias();
		int i=sc.nextInt();
		sc.nextLine();
		return i;
		
	}

	public static int mostrarMunicipios(int provincia) {
		System.out.println("elige nº provincia:");
		AccesoBdd.mostrarMunicipios(provincia);
		int i=sc.nextInt();
		sc.nextLine();
		return i;
	}
	public static void mostrarClima(Clima c) {
		System.out.println("clima por fechas en "+c.getNombre()+", ( "+c.getProvincia() +" )");
		ArrayList<Dia> lista=c.getDias();
		/*for (int i = 0; i < lista.size(); i++) {
			Dia d=lista.get(i);
			imprimirDia(d);
		}*/
		for (Dia d: lista) {//foreach para imprimir arraylist de dias
					imprimirDia(d);
		}
	}

	private static void imprimirDia(Dia d) {
		//pitar fecha bonita formato spanish
		
		System.out.println("Dia: "+imprimirFecha(d.getFecha()));
		System.out.println("minimo: "+d.getMin()+"°---"+d.getMax()+"°max");
		
	}

	private static String imprimirFecha(String fecha) {
		String[] campo=fecha.split("-");
		String aux="";
		aux=aux+campo[2]+"-"+campo[1]+"-"+campo[0];
		return aux;
	}




}
