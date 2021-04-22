package laxmiCSC123Sp21Ass2;
public class CompareTimes
{
	public static void main(String[] args)
	{
       Integer intReference = -1;
       int intNative = -1;
       
       long firstReference = System.currentTimeMillis();
       for(long i = 0; i < 10000000; i++)
       {
        intReference--;
       }
       long lastReference = System.currentTimeMillis();
       System.out.println("Wrapper time : " + (lastReference - firstReference)  + " milliseconds");
       
       long firstInt = System.currentTimeMillis();
       for(long i = 0; i < 10000000; i++)
       {
        intNative--;
       }
       long lastInt = System.currentTimeMillis();
       System.out.println("integer time : " + (lastInt - firstInt) + " milliseconds");
    }
}
