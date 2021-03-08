package br.com.abidux.sqlapi.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.abidux.sqlapi.models.utils.Utils;

public class Statements {
	
	private Table table;
	private Database database;
	public Statements(Table table) {
		this.table = table;
		this.database = table.getDatabase();
	}
	
	public SearchResults getFields(StatementFilter filter, Field... fields) {
		List<HashMap<String, Object>> results = new ArrayList<>();
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("select " + Utils.getStringFieldsName(fields) + " from " + table.getName() + " " + filter.getFilter());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				HashMap<String, Object> result = new HashMap<>();
				for (int i = 0; i < fields.length; i++) {
					String fieldName = fields[i].getName();
					result.put(fieldName, rs.getObject(fieldName));
				}
				results.add(result);
			}
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new SearchResults(results);
	}
	
	public SearchResults getFields(Field... fields) {
		List<HashMap<String, Object>> results = new ArrayList<>();
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("select " + Utils.getStringFieldsName(fields) + " from " + table.getName() + " ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				HashMap<String, Object> result = new HashMap<>();
				for (int i = 0; i < fields.length; i++) {
					String fieldName = fields[i].getName();
					result.put(fieldName, rs.getObject(fieldName));
				}
				results.add(result);
			}
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new SearchResults(results);
	}
	
	public boolean exists(Field field, StatementFilter filter) {
		boolean exists = false;
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("select " + field.getName() + " from " + table.getName() + " " + filter.getFilter());
			ResultSet rs = st.executeQuery();
			exists = rs.next();
			rs.close();
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	public void insert(Field[] fields, Object[] values) {
		String f = Utils.getStringFieldsName(fields);
		String v = Utils.getStringValues(values);
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("insert into " + table.getName() + " ("+f+") values ("+v+")");
			st.executeUpdate();
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Field field, Object value, StatementFilter filter) {
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("update " + table.getName() + " set " + field.getName() + "=" + (value.getClass().getSimpleName().equals("String") ? "\"" + value + "\"" : value) + " " + filter.getFilter());
			st.executeUpdate();
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(StatementFilter filter) {
		try {
			database.openConnection();
			PreparedStatement st = database.connection.prepareStatement("delete from " + table.getName() + " " + filter.getFilter());
			st.executeUpdate();
			st.close();
			database.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}