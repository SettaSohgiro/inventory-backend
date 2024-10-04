package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

// esta clase es Rest de un servicio y no un controller de MVC
// 1.- se decora como @RestController y se trae de sprind framework , para diferencias a una programacion en MVC
@RestController
// 2.- generar el mapping general del servicio y importar de sprindframework y en entre parentisis se designa la uri para llamarla ("/api/v1")
@RequestMapping("/api/v1")
public class CategoryRestController {
// 7.- se inyecta la dependencia con autowired
	@Autowired
	// 5.- se declara un onbeto interfaZ DE CATEGORY y se importa el servicio con nombre service
	private ICategoryService service;
	
	/**
	 * 
	 *gfet all the categories
	 * @return
	 */
	
	// 4.- se aplica el metodo de mapeo por get y se llama a la _URI /category
	@GetMapping("/category")
	//3.- se crea el metodo publico para obtener todas las categorias
	public ResponseEntity<CategoryResponseRest> searchCategory(){
		
		// 6.-  devolvera un response entity categoryresponse
		 ResponseEntity<CategoryResponseRest> response = service.search();
		 return response;
		
	}
	
	/**
	 * get categories by id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/category/{id}")

	public ResponseEntity<CategoryResponseRest> searchCategoryById(@PathVariable Long id){ // @PathVariable path variable sirve para recuperar la variable que se envia por la uri
		
		 ResponseEntity<CategoryResponseRest> response = service.searchByIb(id);
		 return response;
		
	}
	
	
	
}
