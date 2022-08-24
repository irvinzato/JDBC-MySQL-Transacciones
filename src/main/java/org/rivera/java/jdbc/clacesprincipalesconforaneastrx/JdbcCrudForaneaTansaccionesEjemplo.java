package org.rivera.java.jdbc.clacesprincipalesconforaneastrx;

import org.rivera.java.jdbc.models.Categoria;
import org.rivera.java.jdbc.models.Producto;
import org.rivera.java.jdbc.repositorio.ProductoRepositorioImplForanea;
import org.rivera.java.jdbc.repositorio.Repositorio;
import org.rivera.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class JdbcCrudForaneaTansaccionesEjemplo {
  public static void main(String[] args) throws SQLException {
    System.out.println("PROYECTO DUPLICADO PARA TRABAJAR CON TRANSACCIONES !. SI ALGÚN PROCESO FALLA NO CONTINUA " +
            "ES TODO O NADA, SE EJECUTA EL CÓDIGO COMPLETO O POR UN ERROR NO GUARDA NINGUNA OPERACIÓN");

    try (Connection conn = ConexionBaseDatos.getInstance()) {
      if( conn.getAutoCommit() ) {
        conn.setAutoCommit(false);
      }
      try {
      System.out.println("---- Búsqueda con todos los atributos de la tabla ----");
      Repositorio<Producto> repository = new ProductoRepositorioImplForanea();
      repository.findAll().forEach(System.out::println);

      System.out.println("---- Búsqueda por ID ----");
      System.out.println(repository.byId(2L));

      System.out.println("---- Creación de nuevo producto ----");
      Producto product = new Producto();
      product.setName("Teclado IBM mecánico");
      product.setPrice(1550);
      product.setRegisterDate(new Date());
      Categoria category = new Categoria();
      category.setId(2L);
      product.setCategoria(category);
      product.setSku("abc12345"); //LO CREO PRIMERO CORRECTAMENTE(SKU DEBE SER ÚNICO EN MI TABLA)
      repository.save(product);
      System.out.println("Producto guardado con éxito");
      repository.findAll().forEach(System.out::println);

      System.out.println("---- Actualizar producto ----");
      Producto producto = new Producto();
      producto.setName("Teclado RTX G");
      producto.setPrice(1760);
      producto.setId(8L);
      producto.setSku("abc12345"); //AQUÍ DEBE LANZAR EXCEPCIÓN, EL "SKU" YA LO TENGO EN MI TABLA
      Categoria category2 = new Categoria();
      category2.setId(2L);
      producto.setCategoria(category2);

      repository.save(producto);
      System.out.println("Actualización de producto exitosa");
      System.out.println( repository.byId(producto.getId()) );

      conn.commit();
      } catch( SQLException exception ) {
        conn.rollback();  //EN CASO DE FALLAR, REGRESA AL ESTADO QUE TENIA ANTES - (TODO O NADA)
        exception.printStackTrace();
      }

    }

  }
}
