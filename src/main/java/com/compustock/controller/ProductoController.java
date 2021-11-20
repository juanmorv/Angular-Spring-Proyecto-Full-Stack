package com.compustock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.compustock.Service.ProductoService;
import com.compustock.models.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
