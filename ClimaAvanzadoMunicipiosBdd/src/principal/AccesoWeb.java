package principal;

public class AccesoWeb {

	public static String calcularC(int prov, int m) {
		String resultado="";
		if(prov<=9) {//si 1 digito a�adimos0 al principio
			resultado=resultado+"0"+prov;
		}else {//lo a�adimos igualmente pork sino cambia el codigo toal no sale
			resultado+=prov;
		}
		if (m<=9) {//si 1 digito a�adimos2 0s al principio sino 1
			resultado=resultado+"00"+m;
		}else if(m<=99) {
			resultado=resultado+"0"+m;
			
		}else {
			resultado+=m;			
		}
		return resultado;
	}

}
