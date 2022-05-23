package com.ecodeup.ciudades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.ciudades.model.Ciudad;
import com.ecodeup.ciudades.model.Conexion;

/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */

public class CiudadDAO extends Conexion {
	private Connion con=this.conectar();
	private Connection connection;

	public CiudadDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	public CiudadDAO(){}
	// insertar artículo
	public boolean insertar(Ciudad ciudad) throws SQLException {
		String sql = "INSERT INTO Ciudad (id_ciudad,id_departamento_fk,nom_ciudad) VALUES (?, ?, ?)";
		System.out.println(ciudad.getNom_ciudad());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setInt(2, ciudad.getId_ciudad());

		statement.setString(4, ciudad.getNom_ciudad());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Ciudad> listarCiudades() throws SQLException {

		List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
		String sql = "SELECT * FROM Ciudad";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id_ciudad = resulSet.getInt("Id_Ciudad");
			String nom_ciudad = resulSet.getString("Nom_Ciudad");
			Ciudad ciudad = new Ciudad();
			ciudad.setId_ciudad(id_ciudad);
			ciudad.setNom_ciudad(nom_ciudad);
			listaCiudades.add(ciudad);
		}
		con.desconectar();
		return listaCiudades;
	}

	// obtener por id
	public Ciudad obtenerPorId(int id_ciudad) throws SQLException {
		Ciudad ciudad = null;

		String sql = "SELECT * FROM Ciudad WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_ciudad);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			ciudad = new Ciudad(res.getInt("id_ciudad"), res.getString("nom_ciudad"));
		}
		res.close();
		con.desconectar();

		return ciudad;
	}

	// actualizar
	public boolean actualizar(Ciudad ciudad) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Ciudad SET id_departamento_fk=?,nom_ciudad=? WHERE id_ciudad=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, ciudad.getId_ciudad());
		statement.setString(3, ciudad.getNom_ciudad());
		System.out.println(ciudad.getNom_ciudad());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Ciudad ciudad) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Ciudad WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, ciudad.getId_ciudad());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}