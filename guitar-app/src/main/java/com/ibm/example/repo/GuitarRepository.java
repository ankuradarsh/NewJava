package com.ibm.example.repo;

import java.util.List;

import com.ibm.example.model.Guitar;

public interface GuitarRepository {

	void addGuitar(Guitar guitar);

	Guitar getGuitar(String serialNumber);

	Guitar searchGuiter(Guitar guitar);

	List<Guitar> getAllGuitars();
	
	List<Guitar> getByTypes(String type);

}