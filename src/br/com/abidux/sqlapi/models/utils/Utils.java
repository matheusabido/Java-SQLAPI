package br.com.abidux.sqlapi.models.utils;

import br.com.abidux.sqlapi.models.Field;
import br.com.abidux.sqlapi.models.Table;

public class Utils {
	
	public static String getStringFields(Field... fields) {
		StringBuilder builder = new StringBuilder();
		for (Field field : fields) {
			builder.append(field.getName()).append(" ").append(field.getType()).append(", ");
		}
		return builder.substring(0, builder.length()-2).toString();
	}
	
	public static String getStringValues(Object... fields) {
		StringBuilder builder = new StringBuilder();
		for (Object field : fields) {
			builder.append(field.getClass().getSimpleName().equals("String") ? "\"" + field + "\"" : field).append(", ");
		}
		return builder.substring(0, builder.length()-2).toString();
	}
	
	public static String getStringFieldsName(Field... fields) {
		StringBuilder builder = new StringBuilder();
		for (Field field : fields) {
			builder.append(field.getName()).append(", ");
		}
		return builder.substring(0, builder.length()-2).toString();
	}
	
	public static Field getField(Table table, String name) {
		for (Field field : table.getFields()) if (field.getName().equalsIgnoreCase(name)) return field;
		return null;
	}
	
}