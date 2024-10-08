package com.company.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
//  2.-esta clase tenemos que decorarla con una etiqueta de Spring que se llama service.
@Service

//1.-  se implementa la ICategoryService que es la interfaz y se agregan los metodos implementados en la interfaz
public class CategoryServiceImpl implements ICategoryService{

	@Autowired  //sirve para inyectar este objeto al contenedor de sprin
	//inyectar interfaz de categoria
	private ICategoryDao categoryDao;//2.- declarar propiedad privada ICategoryDao nombre de objeto categoryDao
	
	@Override  // 3.- sirve para inyectar el objeto y instaciar se usa spring
	@Transactional(readOnly = true)  //4.- sirve para decorar la clase ResponseEntity , se declara como metado transacional . readonly es una propiedad de lectura
	public ResponseEntity<CategoryResponseRest> search() {
		// TODO Auto-generated method stub
		// return null;
		CategoryResponseRest response = new CategoryResponseRest(); // 5.- se declara el objeto CategoryResponseRest y se coloca el nombre de response
		
		// 6.- se habre un bloque try catch
		try {
			//7.-  List se importa de java.util y Category de el model . categoryDao se utiliza para llamar a los metodo de consulta
			List<Category> category = (List<Category>) categoryDao.findAll();// se debe realizar el cast o casteo con (List<Category>)
			// 8.- se agrega las respuesta en response  y se setea set metadata
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("respuesta ok", "00", "Respuesta Exitosa");		
		} catch (Exception e) {
			// TODO: handle exception
			// 8.- tambien se agrega una respuesta con error
			response.setMetadata("respuesta no ok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.OK);
		
	}

	
	//este metodose agrega por que se agrego otro metodo en ICategoryService
	@Override
	@Transactional(readOnly = true) // tambien se agrega el metodo transaction
	// esto tambien se agrega en el controlador
	public ResponseEntity<CategoryResponseRest> searchByIb(Long id) {
		
		CategoryResponseRest response = new CategoryResponseRest(); // es lo mismo de arriba
	
		List<Category> list = new ArrayList<>();
		try {
			
			Optional<Category> category = categoryDao.findById(id); // se importa de java.util
			
			if(category.isPresent()) {  // ispresent verifica si la category existe
				list.add(category.get());
				response.getCategoryResponse().setCategory(list);	
				response.setMetadata("respuesta ok", "00", "Categoria encontrada");
			}else {
				
				response.setMetadata("respuesta no ok", "-1", "Categoria no encontrada");
				
				return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.NOT_FOUND);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			// 8.- tambien se agrega una respuesta con error
			response.setMetadata("respuesta no ok", "-1", "Error al consultar por id");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.OK);
		
	}


	@Override
	@Transactional()
	public ResponseEntity<CategoryResponseRest> save(Category category) {
		
		
		CategoryResponseRest response = new CategoryResponseRest(); // es lo mismo de arriba
		
		List<Category> list = new ArrayList<>();
		try {
			
			Category          categorySaved = categoryDao.save(category);
		//	objeto category	; variable categoriaSaved 	
			
			if(categorySaved != null) {
				list.add(categorySaved);
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("respuesta ok", "00", "Categoria guardada");
				
			}else {
				response.setMetadata("respuesta no ok", "-1", "Categoria no guardada");
				
				return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			// 8.- tambien se agrega una respuesta con error
			response.setMetadata("respuesta no ok", "-1", "Error al grabar categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.OK);
	}
	//despues se debe ir al controllador


	@Override
	@Transactional()
	public ResponseEntity<CategoryResponseRest> update(Category category , Long id) {


		CategoryResponseRest response = new CategoryResponseRest(); // es lo mismo de arriba
		
		List<Category> list = new ArrayList<>();
		try {
			
			Optional<Category> categorySearch = categoryDao.findById(id);
			
			if(categorySearch.isPresent()) {
				//se procedera a actualizar el registro
				categorySearch.get().setName(category.getName());
				categorySearch.get().setDescription(category.getDescription());
				
				Category categoryToUpdate = categoryDao.save(categorySearch.get());
				
				if(categoryToUpdate != null) {
					list.add(categoryToUpdate);
					response.getCategoryResponse().setCategory(list);
					response.setMetadata("respuesta ok", "00", "Categoria Actualizada");
				}
				
			}else {
				
				response.setMetadata("respuesta no ok", "-1", " categoria no encontrada");
				return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.BAD_REQUEST);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			// 8.- tambien se agrega una respuesta con error
			response.setMetadata("respuesta no ok", "-1", "Error al grabar categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoryResponseRest>(response , HttpStatus.OK);
	}
}
