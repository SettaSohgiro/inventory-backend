package com.company.inventory.response;

import java.util.List;

import com.company.inventory.model.Category;

import lombok.Data;

@Data // con @Data se crea los setter y getter para list

public class CategoryResponse {
	
	// 1.-  crearemos un atrbuto privado la cual es una lista de Category y se llamara category
	//    se importa de java.util 'List' y Category se importa del model Category creado anteriormente
	private List<Category> category;
	

}
