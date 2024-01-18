package com.ibm.example.repo;

import java.util.ArrayList;
import java.util.List;

import com.ibm.example.model.Guitar;
import com.ibm.example.model.GuitarType;

public class Inventory implements GuitarRepository {

	private List<Guitar> guitars=null;

	{
		guitars = new ArrayList<Guitar>();
	}

	@Override
	public void addGuitar(Guitar guitar) {
		// TODO Auto-generated method stub
		guitars.add(guitar);
		System.out.println("Guiter inserted in the inventory"+guitar);

	}

	@Override
	public Guitar getGuitar(String serialNumber) {
		// TODO Auto-generated method stub
		Guitar tempGuitar = null;
		for (Guitar g : guitars) {
			if (g.getSerialNumber().equals(serialNumber)) {
				tempGuitar = g;
				break;
			}
		}
		return tempGuitar;
	}

	@Override
	public Guitar searchGuiter(Guitar guitar) {
		Guitar tempGuiter = null;
		for (Guitar g : guitars) {
			if (g.equals(guitar)) {
				tempGuiter = g;
				break;
			}

		}

		return tempGuiter;
	}
	
	@Override
	public List<Guitar> getAllGuitars(){
		sortByModel(guitars);
		return guitars;
	}
	
	private static void sortByModel(List<Guitar> guitars) {
		guitars.sort((obj1, obj2) -> obj1.getModel().compareTo(obj2.getModel()));
	}

	@Override
	public List<Guitar> getByTypes(String type) {
		List<Guitar> list = new ArrayList<>();
		for(Guitar g : guitars) {
			if(g.getType().equals(GuitarType.valueOf(type))) {
				list.add(g);
			}
		}
		return list;
	}

}