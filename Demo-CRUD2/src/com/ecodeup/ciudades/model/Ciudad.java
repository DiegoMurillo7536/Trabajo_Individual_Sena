package com.ecodeup.ciudades.model;

public class Ciudad {
	private int id_ciudad;
	private int id_departamento_fk;
	private String nom_ciudad;
	/*Constructor sobrecargado*/
	public Ciudad(int id_ciudad, int id_departamento_fk, String nom_ciudad) {
		super();
		this.id_ciudad = id_ciudad;
		this.id_departamento_fk = id_departamento_fk;
		this.nom_ciudad = nom_ciudad;
	}
	public int getId_ciudad() {
		return id_ciudad;
	}
	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	public int getId_departamento_fk() {
		return id_departamento_fk;
	}
	public void setId_departamento_fk(int id_departamento_fk) {
		this.id_departamento_fk = id_departamento_fk;
	}
	public String getNom_ciudad() {
		return nom_ciudad;
	}
	public void setNom_ciudad(String nom_ciudad) {
		this.nom_ciudad = nom_ciudad;
	}
	
	
	
}
