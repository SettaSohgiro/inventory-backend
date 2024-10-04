package com.company.inventory.services;

import java.util.List;

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
}