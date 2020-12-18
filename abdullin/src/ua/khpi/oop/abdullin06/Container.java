package ua.khpi.oop.abdullin06;

import java.io.Serializable;
import java.util.Iterator;

public class Container implements Serializable{
	private String[] arraystring;
	private int size = 0; 
	
	/**
	 * Конструктор 
	 * @param masstr - массив строк (предложений)
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
	 * Метод преобразования всех предложений в один текст
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
			sb.append(arraystring[i] + " ");
		return sb.toString();
	}
	
	/**
	 * Метод добавления строки в конец контейнера
	 * @param str - строка, которая будет добавлена
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
	 * Метод отчистки всего контейнера
	 */
	void clear() {
		for(int i = 0; i < size; i++)
			arraystring[i] = null;
		size = 0;
	}
	
	/**
	 * Метод удаления строки (первая схожая)
	 * @param str - строка, которую нужно удалить
	 * @return  true - трока удалена | false - такой строки нет
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
	 * Метод преобразования массива строк, в массив объектов
	 * @return  массив, содержащий в себе все елементы контейнера
	 */
	public Object[] toArray() {
		Object[] obj = new Object[size];
		for(int i = 0; i < size; i++)
			obj[i] = arraystring[i];
		return obj;
	}
	
	/**
	 * Метод получения размера контейнера
	 * @return  количетво елементов контейнера
	 */
	int size() {
		return size;
	}
	
	/**
	 * Метод получения информации про указаный елемент
	 * @param str строка, которую нужно найти в контейнере
	 * @return true - указаная строка есть в контейнере | false - указаной строки нет
	 */
	boolean contains(String str) {
		for(int i = 0; i < size; i++)
			if(arraystring[i].equals(str))
				return true;
		return false;
	}
	
	/**
	 * Метод получения информации про наличее всех указаных елементов
	 * @param container кнтейнер, который содержет в себе все указаные строки для их поиска в контейнере
	 * @return true - все указаные строки есть в контейнере | false - не все строки есть в контейнере
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
	
	/**
	 * Метод вывода всех данных в Контейнере
	 */
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
	
	/**
	 * Метод поиска позиции указаного предложения в контейнере
	 * @param str искаемая строка
	 * @return позиция указаного елемента / -1 - если такого елемента тету
	 */
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
	
	/**
	 * Метод сортировки контейнера
	 * @param typeofsorting тип сортировки выбраный пользователем
	 */
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
	
	/**
	 * Метод сравнения  двух елементов из контейнера за указаными позициями
	 * @param position1 позиция первого елемента контейнера
	 * @param position2 позиция второго елемента контейнера
	 * @return -1 - указаны неверные позиции елементов | 1 - строки еквивалентны | 0 - строки не еквивалентны 
	 */
	public int compareElements (int position1, int position2) 
	{
		if(position1 > size || position2 > size || position1 < 0 || position2 < 0 )
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
