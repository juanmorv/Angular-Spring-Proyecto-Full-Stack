package com.compustock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.compustock.Service.ProductoService;
import com.compustock.models.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//Cross siver para la politicas de peticiones del front end a backend
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/productos")
	public List<Producto> index() {
		return productoService.findAll();
	}

	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}

	@PostMapping("/productos") // La anotacion @RequestBody sirve para poder mapear a objeto Productos
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);

	}

	@PutMapping("/productos/{id}")
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = productoService.findById(id);

		productoActual.setNombre(producto.getNombre());
		productoActual.setTipo(producto.getTipo());
		productoActual.setDescripcion(producto.getDescripcion());
		productoActual.setPrecio(producto.getPrecio());

		return productoService.save(productoActual);
	}

	@DeleteMapping("/productos/{id}")
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}
}
