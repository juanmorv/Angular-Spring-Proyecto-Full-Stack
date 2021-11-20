package com.compustock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.compustock.models.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Optional <Producto> findById(Long id);

}
