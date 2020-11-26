package ua.khpi.oop.abdullin03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please, enter the text.");
		String str = in.nextLine();
		System.out.println();
		
		TypeOfString.findtypes(str,TypeOfString.countsentences(str));
		
		in.close();
	}

}
