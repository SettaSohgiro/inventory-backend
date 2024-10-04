package com.company.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.inventory.model.Category;

// 1.- se extiende a una clase CrudRepository y dentro  implemente este repositorio que va a ser category y separado por una coma y el tipo de dato que Long
public interface ICategoryDao extends CrudRepository<Category, Long>{

}
