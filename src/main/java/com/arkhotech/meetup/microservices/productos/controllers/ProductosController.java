package com.arkhotech.meetup.microservices.productos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.arkhotech.meetup.microservices.productos.model.Cliente;
import com.arkhotech.meetup.microservices.productos.model.Producto;
import com.arkhotech.meetup.microservices.productos.model.ProductoInventario;

@Controller
@RequestMapping(path="/productos")
public class ProductosController {

	private static final Logger logger = LoggerFactory.getLogger(ProductosController.class);
	
	/**
	 * Retorna todos los productos existentes en la base de datos con el precio final al publico
	 * @return JSon String
	 */
	@GetMapping(path="/")
	public @ResponseBody List<Producto> listAllProducts(@RequestParam(required = true, value = "rut") Integer rut) {
		logger.info("**** Ejecutando servicio Productos->listAllProducts() ");
		List<Producto> listadoProductos = new ArrayList<Producto>();
		RestTemplate restTemplate = new RestTemplate();
		
		ProductoInventario[] listadoProductosInventario = restTemplate.getForObject("http://localhost:18000/inventario/", ProductoInventario[].class);
		Cliente cliente = restTemplate.getForObject("http://localhost:15000/clientes/rut/{rut}", Cliente.class, rut);
		
		for (ProductoInventario pi : listadoProductosInventario) {
		    Producto producto = new Producto();
		    producto.setId(pi.getId());
		    producto.setIdCategoria(pi.getIdCategoria());
		    producto.setNombre(pi.getNombre());
			if (cliente.getTipoCliente() == 1) {
				producto.setPrecio(pi.getPrecioNormal());
			}
			else {
				producto.setPrecio(pi.getPrecioPremium());
			}
			listadoProductos.add(producto);
		}
		return listadoProductos;
	}

	
	/**
	 * Retorna todos los productos de la base de datos que estén
	 * asociados al idCategoría
	 * @param idCategoria
	 * @return JSon String
	 */
	@GetMapping(path="/categoria/{idCategoria}")
	public @ResponseBody Iterable<Producto> listAllProductsByCategory(@PathVariable Integer idCategoria, @RequestParam(required = true, value = "rut") Integer rut ) {
		logger.info("**** Ejecutando servicio Productos->listAllProductsByCategory() ");
		List<Producto> listadoProductos = new ArrayList<Producto>();
		RestTemplate restTemplate = new RestTemplate();
	
		ProductoInventario[] listadoProductosInventario = restTemplate.getForObject("http://localhost:18000/inventario/categoria/{idCategoria}", ProductoInventario[].class, idCategoria);
		Cliente cliente = restTemplate.getForObject("http://localhost:15000/clientes/rut/{rut}", Cliente.class, rut);

		for (ProductoInventario pi : listadoProductosInventario) {
		    Producto producto = new Producto();
		    producto.setId(pi.getId());
		    producto.setIdCategoria(pi.getIdCategoria());
		    producto.setNombre(pi.getNombre());
			if (cliente.getTipoCliente() == 1) {
				producto.setPrecio(pi.getPrecioNormal());
			}
			else {
				producto.setPrecio(pi.getPrecioPremium());
			}
			listadoProductos.add(producto);
		}
		return listadoProductos;
	}
	
	/**
	 * Retorna la información para publico de un producto según su id
	 * @param idProducto
	 * @return
	 */
	@GetMapping(path="/{idProducto}")
	public @ResponseBody Producto getProduct(@PathVariable Integer idProducto, @RequestParam(required = true, value = "rut") Integer rut ) {
		logger.info("**** Ejecutando servicio Productos->getProduct() ");
		RestTemplate restTemplate = new RestTemplate();
		
		ProductoInventario productoInventario = restTemplate.getForObject("http://localhost:18000/inventario/{idProducto}", ProductoInventario.class, idProducto);
		Cliente cliente = restTemplate.getForObject("http://localhost:15000/clientes/rut/{rut}", Cliente.class, rut);
	
	    Producto producto = new Producto();
	    producto.setId(productoInventario.getId());
	    producto.setIdCategoria(productoInventario.getIdCategoria());
	    producto.setNombre(productoInventario.getNombre());
		if (cliente.getTipoCliente() == 1) {
			producto.setPrecio(productoInventario.getPrecioNormal());
		}
		else {
			producto.setPrecio(productoInventario.getPrecioPremium());
		}

		return producto;
	}

	
}
