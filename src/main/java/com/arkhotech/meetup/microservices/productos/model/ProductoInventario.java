package com.arkhotech.meetup.microservices.productos.model;

public class ProductoInventario {

	private Integer id;
	
	private Integer idCategoria;
	
	private String nombre;
	
	private Integer precioNormal;
	
	private Integer precioPremium;
	
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecioNormal() {
		return precioNormal;
	}

	public void setPrecioNormal(Integer precioNormal) {
		this.precioNormal = precioNormal;
	}

	public Integer getPrecioPremium() {
		return precioPremium;
	}

	public void setPrecioPremium(Integer precioPremium) {
		this.precioPremium = precioPremium;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
