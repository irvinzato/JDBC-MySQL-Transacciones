package org.rivera.java.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;
//Generic para cualquier objeto
public interface Repositorio<T> {
  List<T> findAll() throws SQLException;
  T byId(Long id) throws SQLException;
  void save(T t) throws SQLException;
  void delete(Long id) throws SQLException;

}
