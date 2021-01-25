package br.com.abidux.sqliteapi.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.abidux.sqliteapi.utils.Utils;

public class Table {
	
	private String name;
	private Field[] fields;
	private Database database;
	public Table(Database database, String name, Field... fields) {
		this.database = database;
		this.name = name;
		this.fields = fields;
		create();
	}
	
	private void create() {
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("create table if not exists " + name + "(" + Utils.getStringFields(fields) + ")");
			st.executeUpdate();
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Field getField(String name) {
		return Utils.getField(this, name);
	}
	
	public Statements getStatements() {
		return new Statements(this);
	}
	
	public Database getDatabase() {
		return this.database;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Field[] getFields() {
		return this.fields;
	}
	
}