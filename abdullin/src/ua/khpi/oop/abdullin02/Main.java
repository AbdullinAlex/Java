package ua.khpi.oop.abdullin02;

import java.util.Random;

public class Main {

	public static void main(String[] args)
	{
		System.out.format("%5s%5s%7s\n", "Num1", "Num2", "Result");
		for(int i=0; 10>i;i++)
		{
			int num1 = Main.random();
			int num2 = Main.random();
			int res = Main.gcf(num1, num2);
			System.out.format("%5d%5d%7d\n", num1, num2, res);
		}
	}
	 
	public static int random() 
	{
		Random random = new Random();
		int r = random.nextInt(100);
		return r;
	}
	
	public static int gcf(int a, int b) 
	{
		while (a != b)
		{
	        if (a > b) 
	        {
	            int temp = a;
	            a = b;
	            b = temp;
	        }
	        b = b - a;
	    }
		return a;
	}
}
