package br.com.abidux.sqliteapi.models;

import java.io.File;

public class DatabaseBuilder {
	
	private File database;
	private DatabaseType type;
	public DatabaseBuilder(String path, String name) {
		this.database = new File(path.length() == 0 ? "./" : path, name + ".db");
		this.type = DatabaseType.SQLITE;
	}
	
	private String host, port, db, user, password;
	public DatabaseBuilder(String host, String port, String database, String user, String password) {
		this.host = host;
		this.port = port;
		this.db = database;
		this.user = user;
		this.password = password;
		this.type = DatabaseType.MYSQL;
	}
	
	public Database build() {
		return type == DatabaseType.SQLITE ? new SQLiteDatabase(database) : new MySQLDatabase(host, port, db, user, password);
	}
	
}