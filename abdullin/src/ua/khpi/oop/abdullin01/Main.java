package ua.khpi.oop.abdullin01;


public class Main {

	public static void main(String[] args) {
		int var1 = 176430;
		long var2 = 380957369663L;
		int var3 = 0b111111;
		int var4 = 022677;
		int var5 = ( 0 % 26 ) + 1;
		char var6 = (char) (64 + var5);
		int resPair1 = Main.countPair(var1);
		int resPair2 = Main.countPair(var2);
		int resPair3 = Main.countPair(var3);
		int resPair4 = Main.countPair(var4);
		int resPair5 = Main.countPair(var5);
		int resPair6 = Main.countPair((int)var6);
		int resUnpair1 = Main.countUnpair(var1);
		int resUnpair2 = Main.countUnpair(var2);
		int resUnpair3 = Main.countUnpair(var3);
		int resUnpair4 = Main.countUnpair(var4);
		int resUnpair5 = Main.countUnpair(var5);
		int resUnpair6 = Main.countUnpair((int)var6);
		int resOne1 = Main.countOne(var1);
		int resOne2 = Main.countOne(var2);
		int resOne3 = Main.countOne(var3);
		int resOne4 = Main.countOne(var4);
		int resOne5 = Main.countOne(var5);
		int resOne6 = Main.countOne(var6);
	}
	
	public static int countPair (long a) 
	{
		long rest = 0;
        long num = a;
        int c = 0;
        while (num != 0) 
        {
            rest = num % 10;
            num = num / 10;
            if (rest % 2 == 0)
                c++;
        }
        return c;
	}
	
	public static int countUnpair(long num)
	{
		long rest = 0;
		int c = 0;
		while(num != 0)
		{
			 rest = num % 10;
	         num = num / 10;
	         if (rest % 2 != 0)
	        	 c++;
	         
		}
		return c;
	}

	public static int countOne (long num) 
	{
		int c=0;
		long temp = num;
		for(; temp>0; temp=temp/2 )
		{
			if( num%2 == 1)
				c++;
			num/=2;
		}
		return c;
	}
	
}
