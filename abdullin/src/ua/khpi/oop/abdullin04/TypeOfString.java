package ua.khpi.oop.abdullin04;

/**
 * �����, ������� ������� ����� ������� ����������� �� 3 �����(����������� �� 
 * �������, ��������� � ����������� �� �� �������, �� �� ���������) ������ � ������.
 * @author Abdullin Oleksii
 *
 */
public class TypeOfString {
		/**
		 * ����� �������� ���������� ����������� � ������
		 * @param str �����
		 * @return ���������� �����������
		 */
		public static int countsentences(String str, boolean dbg)
		{
			StringBuilder sb = new StringBuilder(str);
			int length = sb.length();
			int index = 0;
			int count = 0;
			for(; index < length; index++)
			{
				int temp;
				temp = findposition(sb, index, dbg);
				if(temp != -1) 
				{
					count++;
					index = temp;
				}
			}
			if(dbg) 
			{
				System.out.print("Count of sentences: ");
				System.out.println(count);
			}
			return count;
		}
		/**
		 * ����� ������ ��������� ����� ����������� �� ����� �����������, � ��������� ������.
		 * @param sb �����
		 * @param start ������, ������ ���� ������
		 * @return ������� ������ ������� �������� ����� �����������, ������� � �������� �������
		 */
		public static int findposition(StringBuilder sb, int start, boolean dbg) 
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
			if (dbg)
			{
				System.out.print("Position of punctuation mark: ");
				System.out.println(min);
			}
			return min;
		}
		/**
		 * ����� ������ ���������� ����������� ������� ����.
		 * @param str �����
		 * @param sentences ���������� ����������� � ������
		 */
		public static void findtypes(String str, int sentences, boolean dbg) 
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
				index = findposition(sb,index, dbg);
				type = typeofstring(senetence(sb, start, index, dbg), dbg);
				if(type == 0)
					vowel++;
				else if(type == 1)
					conconent++;
				else 
					other++;
				start = index + 1;
				index++;
			}
			if(dbg) 
			{
				System.out.print("Count of sentences which started on vowel: ");
				System.out.println(vowel);
				System.out.print("Count of sentences which started on concnent: ");
				System.out.println(conconent);
				System.out.print("Count of sentences which started neither vowel nor conconent: ");
				System.out.println(other);
			}
			makemas(sb, vowel, conconent, other, sentences, dbg);
		}
		/**
		 * ����� ����������� ���� �����������
		 * @param sb ����������� ������ ��������
		 * @return
		 */
		public static int typeofstring(StringBuilder sb, boolean dbg)
		{
			int i = 0;
			char firstchar = sb.charAt(i);
			while(firstchar == ' ') 
			{
				i++;
				firstchar = sb.charAt(i);
			}
			boolean isvowel = vowel(firstchar);
			if(dbg) 
			{
				System.out.print("Sentence: ");
				System.out.println(sb);
				System.out.print("First character in this sentence: ");
				System.out.println(firstchar);
			}
			if(isvowel == true) {
				if(dbg) 
					System.out.println("Type: vowel");
				return 0;
			}
			boolean isconconent = conconent(firstchar);

			if(isconconent == true) {
				if(dbg) {
					System.out.println("Type: coconent");	
				}
				return 1;
			}
			if(dbg) {
				System.out.println("Type: other");	
			}
			return 2;
		}
		/**
		 * ����� ��������� ����������� �� ������
		 * @param sb �����
		 * @param start ������� ������ �����������
		 * @param end ������� ����� �����������
		 * @return ���� �����������
		 */
		public static StringBuilder senetence (StringBuilder sb, int start, int end, boolean dbg) 
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
			if(dbg) 
			{
				System.out.print("Sentence: ");
				System.out.println(sb);	
			}
			return strb;
		}
		/**
		 * ����� �������� ���� ��������, ������ �� ������� �������� ����������� ��������� ���� ����.
		 * @param sb �����
		 * @param vowel ���������� ����������� ������������ �� �������
		 * @param conconent ���������� ����������� ������������ �� ���������
		 * @param other ���������� ����������� ������������ �� �� ������� � �� ���������
		 * @param sentences ���������� �����������
		 */
	public static void makemas(StringBuilder sb, int vowel, int conconent, int other, int sentences, boolean dbg) 
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
			index = findposition(sb,index, dbg);
			strb = senetence(sb, start, index, dbg);
			type = typeofstring(strb, dbg);
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
	 * ����� ������ ������� � ������������� ������ ����
	 * @param mas ������ � ������������� ������ ����
	 * @param count ���������� ����������� � �������
	 */
	public static void output(StringBuilder mas[], int count) 
	{
		for(int i = 0; count > i; i++)
		{
			System.out.println(mas[i]);
		}
	}
	/**
	 * ����� ������ ������ �������� ����������� ����� ����������� ������ ����
	 * @param mas ������ � ������������� ������ ����
	 * @param count ���������� ����������� � �������
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
	 * ����� ����������� �������� �� ������ ������� ������
	 * @param ch ������ ������ ������ �����������
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
	 * ����� ����������� �������� �� ������ ��������� ������
	 * @param ch ������ ������ ������ �����������
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