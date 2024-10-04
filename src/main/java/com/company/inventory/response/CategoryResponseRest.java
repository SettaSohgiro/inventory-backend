package com.company.inventory.response;

import lombok.Getter;
import lombok.Setter;

@Getter  // 2.- funcion de lomdock para traer el metodo de getter 
@Setter  // 3.- funcion de lomdock para traer el metodo de setter es diferente a @Data 

// 1.- primero se extiende esta clase se aprobecha la herencia de ResponseRest y esta clase se encarga de setter la metadata
public class CategoryResponseRest extends ResponseRest{

	// 2.- se  declarar finalmente un atributo privado que va a ser CategoryResponse
	// 
	private  CategoryResponse categoryResponse = new CategoryResponse();
}
