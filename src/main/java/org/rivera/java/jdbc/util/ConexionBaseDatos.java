package org.rivera.java.jdbc.util;

import java.sql.*;
//Una sola conexión para toda la aplicación(Depende el tipo de aplicación)
public class ConexionBaseDatos {

  private static String url = "jdbc:mysql://localhost:3306/java_curso";
  private static String username = "root";
  private static String password = "sasa";
  private static Connection connection;
//PROYECTÓ DUPLICADO PARA TRABAJAR CON TRANSACCIONES !
  public static Connection getInstance() throws SQLException {
    if( connection == null ) {
      connection = DriverManager.getConnection(url, username, password);
    }
    return connection;
  }

}
