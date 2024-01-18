package com.ibm.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Guitar {

	private String serialNumber;
	private double price;
	private String builder;
	private String model;
	private GuitarType type;
	private String backWood;
	private String topWood;

	@Override
	public boolean equals(Object obj) {
		Guitar tempGuiter = null;
		if (obj instanceof Guitar) {
			tempGuiter = (Guitar) obj;
		}
		if (this.getSerialNumber().equals(tempGuiter.getSerialNumber())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Guiter [serialNumber=" + serialNumber + ", price=" + price + ", builder=" + builder + ", model=" + model
				+ ", type=" + type.getType() + ", backWood=" + backWood + ", topWood=" + topWood + "]";
	}

	public Guitar(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

}