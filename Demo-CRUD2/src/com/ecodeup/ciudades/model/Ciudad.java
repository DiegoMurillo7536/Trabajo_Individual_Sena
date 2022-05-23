package com.ecodeup.ciudades.model;

public class Ciudad {
	private int id_ciudad;
	private String nom_ciudad;
	/*Constructor normalito*/
	public Ciudad() {}
	/*Constructor sobrecargado*/
	public Ciudad(int id_ciudad, String nom_ciudad) {
		super();
		this.id_ciudad = id_ciudad;
		this.nom_ciudad = nom_ciudad;
	}
	/*Getters and Setters*/
	public int getId_ciudad() {
		return id_ciudad;
	}
	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	public String getNom_ciudad() {
		return nom_ciudad;
	}
	public void setNom_ciudad(String nom_ciudad) {
		this.nom_ciudad = nom_ciudad;
	}
	
	
	
	
}
