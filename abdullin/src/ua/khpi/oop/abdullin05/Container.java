package ua.khpi.oop.abdullin05;

import java.util.Iterator;

public class Container {
	private String[] arraystring;
	private int size = 0; 
	
	/**
	 * ����������� 
	 * @param masstr - ������ ����� (�����������)
	 */
	public Container (String... masstr) {
		if(masstr.length != 0) 
		{
			size = masstr.length;
			arraystring = new String [size];
			for(int i = 0; i < size; i++)
				arraystring[i] = masstr[i];
		}
	}
	
	/**
	 * ����� �������������� ���� ����������� � ���� �����
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
			sb.append(arraystring[i] + " ");
		return sb.toString();
	}
	
	/**
	 * ����� ���������� ������ � ����� ����������
	 * @param str - ������, ������� ����� ���������
	 */
	public void add(String str) {
		String[] newmas = new String[size+1];
		for(int i = 0; i < size; i++)
			newmas[i] = arraystring[i];
		newmas[size] = str;
		size++;
		arraystring = newmas;
	}
	
	/**
	 * ����� �������� ����� ����������
	 */
	void clear() {
		for(int i = 0; i < size; i++)
			arraystring[i] = null;
		size = 0;
	}
	
	/**
	 * ����� �������� ������ (������ ������)
	 * @param str - ������, ������� ����� �������
	 * @return  true - ����� ������� | false - ����� ������ ���
	 */
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
	
	/**
	 * ����� �������������� ������� �����, � ������ ��������
	 * @return  ������, ���������� � ���� ��� �������� ����������
	 */
	public Object[] toArray() {
		Object[] obj = new Object[size];
		for(int i = 0; i < size; i++)
			obj[i] = arraystring[i];
		return obj;
	}
	/**
	 * ����� ��������� ������� ����������
	 * @return  ��������� ��������� ����������
	 */
	int size() {
		return size;
	}
	/**
	 * ����� ��������� ���������� ��� �������� �������
	 * @param str ������, ������� ����� ����� � ����������
	 * @return true - �������� ������ ���� � ���������� | false - �������� ������ ���
	 */
	boolean contains(String str) {
		for(int i = 0; i < size; i++)
			if(arraystring[i].equals(str))
				return true;
		return false;
	}
	/**
	 * ����� ��������� ���������� ��� ������� ���� �������� ���������
	 * @param container ��������, ������� �������� � ���� ��� �������� ������ ��� �� ������ � ����������
	 * @return true - ��� �������� ������ ���� � ���������� | false - �� ��� ������ ���� � ����������
	 */
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
