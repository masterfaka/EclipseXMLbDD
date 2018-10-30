package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBdd { 
	private static String usuario="root";
	private static String password="";
	private static String url="jdbc:mysql://localhost:3306/climamunicipio?serverTimezone=UTC";


	public static void mostrarProvincias() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="SELECT * FROM `provincias`";
			Connection c= DriverManager.getConnection(url,usuario, password);
            Statement st= c.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
				String id=rs.getString("id_provincia");
				String prov=rs.getString("provincia");
				System.out.println("id: "+id+"--"+prov);
			}
            st.close();
            c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//cargar driver
	}


	public static void mostrarMunicipios(int pro) {
		String query="SELECT * FROM `municipios` WHERE `id_provincia`="+pro;
		try {
			Connection c= DriverManager.getConnection(url,usuario, password);
            Statement st= c.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
				//mostramos resultados
            	System.out.println(rs.getString("cod_municipio")+"--"+rs.getString("nombre"));
			}
            rs.close();
            c.close();
            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
