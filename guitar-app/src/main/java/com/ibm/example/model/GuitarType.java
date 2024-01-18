package com.ibm.example.model;

public enum GuitarType {
	Acoustics("Acoustics"),
	Electric("Electric"),
	Jazz("Jazz"),
	Bass("Bass");
	
	private String type;

	private GuitarType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}