package com.company.inventory.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data  // 6.- @data se trae de la libreria lombok el cual sirve para crear los setter y getter de forma automatica
@Entity  //1.-  se define con la anotacion de @Entity si hay error hay que importarlo de entity.java
@Table(name="category") //2.-   con  @Table crearemos la tabla en la base de datos es automatico con esta linea y 
						//en el atributo name: se colocara el nombre de la tabla
public class Category implements Serializable{ // 3.- se define un implement serializable y se importa de java.io  

	/**
	 * 
	 */
	private static final long serialVersionUID = -4310027227752446841L; // 4.- se debe generar un id por default 

	@Id // 7.- se debe setear el id y se importa de jakarta.persitense 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 8.- y se va a senalar que se autogenere el id  con un nuevo registro 
	
	// 5.- se crean los campos que llevara la tabla
	private Long id;
	private String name;
	private String description;
	
}
