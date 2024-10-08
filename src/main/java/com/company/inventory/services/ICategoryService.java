package com.company.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;

// 1.- Voy a declarar todos los métodos que va a tener mi clase de servicio que luego va a implementar.

public interface ICategoryService {

	
	// 2.- metodo para obtener las categorias va a ser un ResponseEntity de CategoryResponseRest y va a ser un metodo  search
	public ResponseEntity<CategoryResponseRest> search();
	// 3.- metodo que va a obtener el id del registro y se debe enviar un parametro
	public ResponseEntity<CategoryResponseRest> searchByIb(Long id);
	
	
	// 4.- cuando esta listo elservicio y se quierre agregar otro aqui se debe realizar primero
	//    metodo que va a guardar rl registro y se debe enviar 2 parametro . Category es la interfaz de datos
	public ResponseEntity<CategoryResponseRest> save(Category category);

	// 5.- update de categoria recibe una Category para actualizar y el id para buscar la category
	public ResponseEntity<CategoryResponseRest> update(Category category , Long id);
	
	
}
