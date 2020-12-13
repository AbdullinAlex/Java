package ua.khpi.oop.abdullin04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean dbg = false;
		for (String str: args) 
		{
			if(str.equals("-h") || str.equals("-help"))
			{
				System.out.println("Autor: Abdullin Alex.");
				System.out.println("Group: CIT-119a");
				System.out.println("Task: Find 3 types of sentences which satrted on vowel, conconent and other. Find the longest in each type.");
				System.out.println("Algoruthm: Find from the text count of senteces. Define each sentence with a type. Make three arrays. Each array store all sentences with one type. \nFind the longest sentence in each arrsy.");
			}
			if(str.equals("-d") || str.equals("-debug"))
			{
				dbg = true;
			}
		}
		Menu(dbg);
	}
	
	public static void Menu(boolean dbg) {
		String str = "Text for working programm.";
		boolean endprog = true;
		StringBuilder sb = new StringBuilder(str);
		Scanner in = new Scanner(System.in);
		int menu;
		while(endprog) {
			System.out.println("1. Input data");
			System.out.println("2. Show data");
			System.out.println("3. Make a task");
			System.out.println("4. Exit");
			menu = in.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("Please, enter the text.");
				String str1 = in.nextLine();
				str1 = in.nextLine();
				sb.delete(0, sb.length());
				sb = new StringBuilder(str1);
				break;
			case 2:
				if(sb == null)
				{
					System.out.println("Data is empty");
				}
				else
				{
					System.out.print("Data: ");
					System.out.println(sb);
				}
				break;
			case 3:
				if(sb == null)
				{
					System.out.println("Data is empty");
				}
				else
				{
					TypeOfString.findtypes(sb.toString(),TypeOfString.countsentences(sb.toString(), dbg), dbg);
				}
				break;
			case 4:
				endprog = false;
				in.close();
				break;
			default: 
				System.out.println("Error! Chose another command.");
				break;
			}
		}
	
	}

}
