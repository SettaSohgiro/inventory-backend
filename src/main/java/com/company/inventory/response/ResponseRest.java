package com.company.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {
	
	// 1.- crear un atributo privado que va a ser un ArrayList
	// dentro de ese ArrayList.Voy a hacer referencia a un Map y este objeto va a recibir dos String ya.
	// se llama al atributo metadata y sera un arraylist
	// despues se hace importación de primero ArrayList de java útil.
	// y hashMap de java.util
	private ArrayList<HashMap<String , String>> metadata = new ArrayList<>(); 
	
	// 2.- ahora se crean los metodos de getmetadata y set metadata en boton derecho y en Source y generate getter and setter

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}
	
	// 3.- solo modificaremos el setter y agregaremos 3 parametros de entrada

	public void setMetadata(String type, String code , String date) {
		//this.metadata = metadata;
		
		// 4.- ahora haremos la variable que seteara a string string con HashMap
		HashMap<String , String> map = new HashMap<String , String>();
		// 5.- ahora setearemos con map las  3 variables
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		// 6.- y con add se agregara la informacion a metadata
		metadata.add(map);
	}
	
	

}
