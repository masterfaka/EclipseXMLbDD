# EclipseXMLbDD
Sacar cod_localidad de las tablas Bdd y parsear un xml con dicho cod

recordar hashmap como array_asoc:https://www.callicoder.com/java-hashmap/
public static String devolverAsignaturaPorNumero(int numero)
	{
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		mapa.put(1,"Matemáticas");
		mapa.put(2,"Lengua");
		String aux=mapa.get(numero);
		return aux;
