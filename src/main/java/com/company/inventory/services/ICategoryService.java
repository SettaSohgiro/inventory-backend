package com.company.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.response.CategoryResponseRest;

// 1.- Voy a declarar todos los métodos que va a tener mi clase de servicio que luego va a implementar.

public interface ICategoryService {

	
	// 2.- metodo para obtener las categorias va a ser un ResponseEntity de CategoryResponseRest y va a ser un metodo  search
	public ResponseEntity<CategoryResponseRest> search();
	// 3.- metodo que va a obtener el id del registro y se debe enviar un parametro
	public ResponseEntity<CategoryResponseRest> searchByIb(Long id);
	
}
