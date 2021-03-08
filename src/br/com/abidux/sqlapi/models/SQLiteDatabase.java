package br.com.abidux.sqlapi.models;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase extends Database {

	private File database;
	public SQLiteDatabase(File database) {
		this.database = database;
	}
	
	@Override
	public void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + database);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}