package br.com.abidux.sqliteapi;

import br.com.abidux.sqliteapi.models.Database;
import br.com.abidux.sqliteapi.models.DatabaseBuilder;
import br.com.abidux.sqliteapi.models.Field;
import br.com.abidux.sqliteapi.models.SearchResults;
import br.com.abidux.sqliteapi.models.StatementFilter;
import br.com.abidux.sqliteapi.models.Statements;
import br.com.abidux.sqliteapi.models.Table;

public class Main {
	
	public static void main(String[] args) {
		Database database = new DatabaseBuilder("localhost", "3306", "test", "root", "").build();
		Field nome = new Field("nome", "text"), idade = new Field("idade", "int");
		Table table = new Table(database, "tabela", nome, idade);
		Statements st = table.getStatements();
		StatementFilter filter = new StatementFilter().where(nome, "Matheus");
		if (!st.exists(nome, filter)) {
			st.insert(new Field[] {nome, idade}, new Object[] {"Matheus", 14});
		} else st.update(idade, 15, filter);
		SearchResults results = st.getFields(filter, nome, idade);
		System.out.println(results.getStringField(nome)[0]);
		System.out.println(results.getIntField(idade)[0]);
	}
	
}