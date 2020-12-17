package ua.khpi.oop.abdullin06;

import java.io.Serializable;
import java.util.Iterator;

public class Container implements Serializable{
	private String[] arraystring;
	private int size = 0; 
	
	public Container (String... masstr) {
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
		String[] newmas = new String[size+1];
		for(int i = 0; i < size; i++)
			newmas[i] = arraystring[i];
		newmas[size] = str;
		size++;
		arraystring = newmas;
	}
	
	void clear() {
		for(int i = 0; i < size; i++)
			arraystring[i] = null;
		size = 0;
	}
	
	boolean remove(String str) {
		boolean bool = false;
		int position = -1;
		for(int i = 0; i < size; i++) {
			if(arraystring[i].equals(str)) 
			{
				bool = true;
				position = i;
				break;
			}
		}
		if(position != -1) {
			
			String[] newmas = new String[size-1];
			for(int i = 0; i < position; i++ ){
				newmas[i]=arraystring[i];
			}
			for(int i = position, n = position + 1; n < size; n++, i++) {
				newmas[i] = arraystring[n];
			}
			size--;
			arraystring = newmas;
		}
		return bool;
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
	
	boolean contains(String str) {
		for(int i = 0; i < size; i++)
			if(arraystring[i].equals(str))
				return true;
		return false;
	}
	
	boolean containsAll(Container container) {
		int count = 0;
		if(size < container.size() || container.size() == 0)
			return false;
		for(int i = 0; i < size; i++ )
			for(int j = 0; j < container.size(); j++) 
				if(arraystring[i].equals(container.arraystring[j])) {
					count++;
					break;
				}
		if(count == container.size())
			return true;
		else
			return false;
	}
	
	public void printContainer() {
		if(size() > 0) 
		{
			for(String str : arraystring)
				System.out.println(str);
		}
		else 
		{
			System.out.println("Conatainer is empty.");
		}
		System.out.println();
	}
	
	public int find(String str) {
		int position = 0;
		for(String string : arraystring)
		{
			if(string.equals(str))
				return position;
			position++;
		}
		return -1;
	}
	
	public void sortAlphabet(int typeofsorting) {
		if(typeofsorting == 1) 
		{
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arraystring[j].compareTo(arraystring[j+1]) > 0)
					{
						String temp = arraystring[j];
						arraystring[j] = arraystring[j+1];
						arraystring[j+1] = temp;
					}
		}
		else if (typeofsorting == 2)
		{
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arraystring[j].compareTo(arraystring[j+1]) < 0)
					{
						String temp = arraystring[j];
						arraystring[j] = arraystring[j+1];
						arraystring[j+1] = temp;
					}
		}
	}
	
	public int compareElements (int position1, int position2) 
	{
		if(position1 > size || position2 > size)
			return -1;
		if(arraystring[position1 - 1].equals(arraystring[position2 - 1]))
			return 1;
		else
			return 0;
	}
	
	public MyIterator<String> iterator() {
		return new MyIterator<String>();
	}
	
	public class MyIterator<String> implements Iterator{
		int index;
		
		@Override
		public boolean hasNext()
		{
			if(index < size)
				return true;
			else
				return false;
		}
		
		@Override
		public Object next() 
		{
			return arraystring[index++];
		}

		@Override
		public void remove() 
		{
			Container.this.remove(arraystring[index - 1]);
		}
	}
}
