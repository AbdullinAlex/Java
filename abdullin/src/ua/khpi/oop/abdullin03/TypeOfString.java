package ua.khpi.oop.abdullin03;

/**
 * Класс, который находит самое длинное предложение из 3 типов(начинаеться на 
 * гласную, согласную и начинаеться ни на гласную, ни на согласную) 
 * @author Abdullin Oleksii
 *
 */
public class TypeOfString {
		/**
		 * Метод подсчета количества предложений в тексте
		 * @param str текст
		 * @return Количество предложений
		 */
		public static int countsentences(String str)
		{
			StringBuilder sb = new StringBuilder(str);
			int length = sb.length();
			int index = 0;
			int count = 0;
			for(; index < length; index++)
			{
				int temp;
				temp = findposition(sb, index);
				if(temp != -1) 
				{
					count++;
					index = temp;
				}
			}
			return count;
		}
		/**
		 * Поиск самого пергового знака указывающий на конец предложения, с указаного начала
		 * @param sb текст
		 * @param start начало, откуда надо искать
		 * @return Позицию самого первого признака конца предложения, начиная с указаной позиции
		 */
		public static int findposition(StringBuilder sb, int start) 
		{
			int[] index = new int [3];
			int min = 0;
			int i = 1;
			index[0] = sb.indexOf(".", start);
			index[1] = sb.indexOf("!", start);
			index[2] = sb.indexOf("?", start);
			min = index[0];
			for(; 3 > i; i++)
			{
				if(min > index[i] && index[i] != -1 )
					min = index[i]; 
				if(min == -1)
					min = index[i];
			}
			return min;
		}
		/**
		 * Метод поиска количества предложений разного типа
		 * @param str текст
		 * @param sentences количество предложений в тексту
		 */
		public static void findtypes(String str, int sentences) 
		{
			StringBuilder sb = new StringBuilder(str);
			int vowel = 0;
			int conconent = 0;
			int other = 0;
			int index = 0;
			int start = 0;
			int type = -1;
			for(int i = 0; i < sentences; i++) 
			{
				index = findposition(sb,index);
				type = typeofstring(senetence(sb, start, index));
				if(type == 0)
					vowel++;
				else if(type == 1)
					conconent++;
				else 
					other++;
				start = index + 1;
				index++;
			}
			makemas(sb, vowel, conconent, other, sentences);
		}
		/**
		 * 
		 * @param sb
		 * @return
		 */
		// метод определения типа предложения
		public static int typeofstring(StringBuilder sb)
		{
			int i = 0;
			char firstchar = sb.charAt(i);
			while(firstchar == ' ') 
			{
				i++;
				firstchar = sb.charAt(i);
			}
			boolean isvowel = vowel(firstchar);
			if(isvowel == true)
				return 0;
			boolean isconconent = conconent(firstchar);
			if(isconconent == true)
				return 1;
			return 2;
		}
		/**
		 * Метод выделения предложения из текста
		 * @param sb текст
		 * @param start позиция начала предложения
		 * @param end позиция конца предложения
		 * @return одно предложение
		 */
		public static StringBuilder senetence (StringBuilder sb, int start, int end) 
		{
			String str;
			char firstchar = sb.charAt(start);
			while(firstchar == ' ') 
			{
				start++;
				firstchar = sb.charAt(start);
			}
			str = sb.substring(start,end+1);
			StringBuilder strb = new StringBuilder(str);
			return strb;
		}
		/**
		 * 
		 * @param sb текст
		 * @param vowel количество предложений начинающиеся на гласную
		 * @param conconent количество предложений начинающиеся на согласную
		 * @param other количество предложений начинающиеся на не гласную и не согласную
		 * @param sentences количество предложений
		 */
	// метод создания трех массивов, каждый из которых содержит предложения подобного себе типа
	public static void makemas(StringBuilder sb, int vowel, int conconent, int other, int sentences) 
	{
		StringBuilder strb;
		StringBuilder[] masVowel = new StringBuilder[vowel];
		StringBuilder[] masConconent = new StringBuilder[conconent];
		StringBuilder[] masOther = new StringBuilder[other];
		int index = 0;
		int start = 0;
		int type = -1;
		int vowel1 = 0;
		int conconent1 = 0;
		int other1 = 0;
		for(int i = 0; i < sentences; i++) {
			index = findposition(sb,index);
			strb = senetence(sb, start, index);
			type = typeofstring(strb);
			if(type == 0) 
			{
				masVowel[vowel1] = strb;
				vowel1++;
			}
			else if(type == 1) 
			{
				masConconent[conconent1] = strb;
				conconent1++;
			}
			else 
			{ 
				masOther[other1] = strb;
				other1++;
			}
			start = index + 1;
			index++;
		}
		if(vowel != 0 )
		{
			System.out.println("This senteces are started on vowel:");
			output(masVowel, vowel);
			longer(masVowel, vowel);
		}
		else
			System.out.println("Here is not sentenses wich stated on vowel");
		if(conconent != 0)
		{
			System.out.println("This senteces are started on conconent:");
			output(masConconent, conconent);
			longer(masConconent, conconent);
		}
		else
			System.out.println("Here is not sentenses wich stated on conconent");
		if(other != 0)
		{
			System.out.println("This senteces are started neither vowel nor conconent:");
			output(masOther, other);
			longer(masOther, other);
		}
		else
			System.out.println("Here is not sentenses wich started neither vowel nor concnent");
		
	}
	/**
	 * Метод выводв массива с предложениями одного типа
	 * @param mas массив с предложениями одного типа
	 * @param count количество предложений в массиве
	 */
	//метод вывода массивов
	public static void output(StringBuilder mas[], int count) 
	{
		for(int i = 0; count > i; i++)
		{
			System.out.println(mas[i]);
		}
	}
	/**
	 * Метод поиска самого длинного предложения среди предложений одного типа
	 * @param mas массив с предложениями одного типа
	 * @param count количество предложений в массиве
	 */
	public static void longer(StringBuilder mas[], int count) 
	{
		int n = 0;
		int max = mas[0].length();
		for(int i = 1; count > i; i++) 
		{
			if(mas[i].length() > max)
			{
				max = mas[i].length();
				n = i;
			}
		}
		System.out.print("The longest sentence is: ");
		System.out.println(mas[n]);
		System.out.print("It has length: ");
		System.out.println(max);
		System.out.println();
	}
	/**
	 * Метод определения является ли символ гласной буквой
	 * @param ch Первый символ начала предложения
	 * @return true/false
	 */
	public static boolean vowel (char ch) {
		switch (Character.toLowerCase(ch))
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				return true;
			default:
				return false;
		}
		
	}
	/**
	 * Метод определения является ли символ согласной буквой
	 * @param ch Первый символ начала предложения
	 * @return true/false
	 */
	public static boolean conconent(char ch) {
		switch (Character.toLowerCase(ch))
		{
			case 'b':
			case 'c':
			case 'd':
			case 'f':
			case 'g':
			case 'h':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'v':
			case 'w':
			case 'x':
			case 'z':
				return true;
			default:
				return false;
		}
		
	}
}
