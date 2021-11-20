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

}