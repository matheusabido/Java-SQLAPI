package br.com.abidux.sqliteapi.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResults {
	
	private List<HashMap<String, Object>> results = new ArrayList<>();
	public SearchResults(List<HashMap<String, Object>> results) {
		this.results = results;
	}
	
	public HashMap<String, Object> first() {
		return results.get(0);
	}
	
	public HashMap<String, Object> last() {
		return results.get(results.size()-1);
	}
	
	public int[] getIntField(Field field) {
		int[] list = new int[results.size()];
		for (int i = 0; i < list.length; i++) list[i] = (int) results.get(i).get(field.getName());
		return list;
	}
	
	public float[] getFloatField(Field field) {
		float[] list = new float[results.size()];
		for (int i = 0; i < list.length; i++) list[i] = (float) results.get(i).get(field.getName());
		return list;
	}
	
	public double[] getDoubleField(Field field) {
		double[] list = new double[results.size()];
		for (int i = 0; i < list.length; i++) list[i] = (double) results.get(i).get(field.getName());
		return list;
	}
	
	public String[] getStringField(Field field) {
		String[] list = new String[results.size()];
		for (int i = 0; i < list.length; i++) list[i] = (String) results.get(i).get(field.getName());
		return list;
	}
	
	public boolean[] getBooleanField(Field field) {
		boolean[] list = new boolean[results.size()];
		for (int i = 0; i < list.length; i++) list[i] = (int)results.get(i).get(field.getName()) == 1;
		return list;
	}
	
	public List<HashMap<String, Object>> getResults() {
		return results;
	}
	
}