package ua.khpi.oop.abdullin05;

public class Container {
	private String[] arraystring;
	private int size = 0; 
	
	public Container (String[] masstr) {
		if(masstr.length != 0) 
		{
			size = masstr.length;
			arraystring = new String [size];
			for(int i = 0; i < size; i++)
				arraystring[i] = masstr[i];
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
			sb.append(arraystring[i] + " ");
		return sb.toString();
	}
	
	public void add(String str) {
		size++;
		String[] newmas = new String[size];
		for(int i = 0; i < size; i++)
			newmas[i] = arraystring[i];
		newmas[size-1] = str;
		arraystring = newmas;
	}
	
	void clear() {
		for(int i = 0; i < size; i++)
			arraystring[i] = null;
		size = 0;
	}
	
	public Object[] toArray() {
		Object[] obj = new Object[size];
		for(int i = 0; i < size; i++)
			obj[i] = arraystring[i];
		return obj;
	}
	
	int size() {
		return size;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
