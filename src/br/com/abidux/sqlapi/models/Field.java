package br.com.abidux.sqlapi.models;

public class Field {
	
	private String name;
	private Object type;
	public Field(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getType() {
		return type;
	}
	
}