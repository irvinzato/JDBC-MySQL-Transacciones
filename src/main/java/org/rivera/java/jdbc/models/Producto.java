package org.rivera.java.jdbc.models;

import java.util.Date;

public class Producto {
  //PROYECTÓ DUPLICADO PARA TRABAJAR CON TRANSACCIONES !
  private Long id;
  private String name;
  private Integer price;
  private Date registerDate;
  private Categoria categoria;
  private String sku;

  public Producto() {
  }

  public Producto(Long id, String name, Integer price, Date registerDate) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.registerDate = registerDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  @Override
  public String toString() {
    String cat = (this.categoria == null) ?"No creada" : categoria.getName();
    return "id = " + id +
            ", name = " + name +
            ", price = " + price +
            ", registerDate = " + registerDate +
            ", category = " + cat +
            ", sku = " + sku;
  }
}
