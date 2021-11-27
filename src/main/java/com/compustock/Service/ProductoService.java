package com.compustock.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compustock.models.Producto;
import com.compustock.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}
	
	
	public Producto findById(Long id) {
		//Si en encuetra ese producto por su id devolvera objeto Producto 
		//en caso de lo contrario null
		return productoRepository.findById(id).orElse(null);
	}
	
	public Producto save (Producto producto) {
		
		return productoRepository.save(producto);
	}
	
	public void delete(Long id) {
		
		productoRepository.deleteById(id);
	}
	

	
	
}
