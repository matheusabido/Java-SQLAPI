package br.com.abidux.sqlapi.models;

public class StatementFilter {
	
	private String filter;
	
	public StatementFilter where(String field, String value) {
		this.filter = "WHERE " + field + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter where(String field, Number value) {
		this.filter = "WHERE " + field + "=" + value;
		return this;
	}
	
	public StatementFilter where(String field, boolean value) {
		this.filter = "WHERE " + field + "=" + value;
		return this;
	}
	
	public StatementFilter where(Field field, String value) {
		this.filter = "WHERE " + field.getName() + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter where(Field field, Number value) {
		this.filter = "WHERE " + field.getName() + "=" + value;
		return this;
	}
	
	public StatementFilter where(Field field, boolean value) {
		this.filter = "WHERE " + field.getName() + "=" + value;
		return this;
	}
	
	public StatementFilter and(String field, String value) {
		this.filter += " AND " + field + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter and(String field, Number value) {
		this.filter += " AND " + field + "=" + value;
		return this;
	}
	
	public StatementFilter and(String field, boolean value) {
		this.filter += " AND " + field + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter and(Field field, String value) {
		this.filter += " AND " + field.getName() + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter and(Field field, Number value) {
		this.filter += " AND " + field.getName() + "=" + value;
		return this;
	}
	
	public StatementFilter and(Field field, boolean value) {
		this.filter += " AND " + field.getName() + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter or(String field, String value) {
		this.filter += " OR " + field + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter or(String field, Number value) {
		this.filter += " OR " + field + "=" + value;
		return this;
	}
	
	public StatementFilter or(String field, boolean value) {
		this.filter += " OR " + field + "=" + value;
		return this;
	}
	
	public StatementFilter or(Field field, String value) {
		this.filter += " OR " + field.getName() + "=\"" + value + "\"";
		return this;
	}
	
	public StatementFilter or(Field field, Number value) {
		this.filter += " OR " + field.getName() + "=" + value;
		return this;
	}
	
	public StatementFilter or(Field field, boolean value) {
		this.filter += " OR " + field.getName() + "=" + value;
		return this;
	}
	
	public String getFilter() {
		return filter;
	}
	
}