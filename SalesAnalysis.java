package Assignment2;
import java.util.*;
import java.io.*;

public class SalesAnalysis
{
	public static double getWeeklySales(String strLine) 
	{
		double sum = 0.0;
		strLine.trim();
		String[] salesNum = strLine.split(",");
		for(int j=0; j<salesNum.length;j++)
		{
			sum = sum + Double.parseDouble(salesNum[j]); 
		}
		
		return sum;
	}
	public static void main (String [] args) throws IOException
	{
		int week=0;
		int weeknumH=0;
		int weeknumL=0;
		int i=0;
		double sum=0.0;
		double totalSum=0.0;
		double totalAverage=0.0;
		double average=0.0;
		double[] weekSum = new double[5];
		double temp;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Please enter the input file name: ");
		String input = keyboard.next();
		
		File inputFile = new File(input);
		Scanner inputReader = new Scanner(inputFile);
		
        while (inputReader.hasNextLine())
        {
        		String strLines = inputReader.next();
        		week++;
        		sum = getWeeklySales(strLines);
        		weekSum[i] = sum;
        		System.out.printf("\n");
        		System.out.printf("Total sales for week %d: " + '$' + "%,.2f\n", week, sum);
        		average = (double) sum/7;
        		System.out.printf("Average daily sales for week %d: " + '$' + "%,.2f\n\n", week, average);
        		i++;
        }
        temp = weekSum[0];
        
        for(int j = 0; j<weekSum.length;j++)
        {
        	totalSum = totalSum + weekSum[j];
        	if(weekSum[j]>0 && weekSum[j] > temp)
        	{
        		weeknumH = j + 1; //because j started from 0 value
        	}
        	if (weekSum[j] < temp && weekSum[j] > 0)
			 {
			  weeknumL = j + 1 ; //because j started from 0 value
			 }
        }
        
        totalAverage = totalSum/week;
       	
        System.out.printf("Total sales for all weeks: " + '$' + "%,.2f\n", totalSum);	
        System.out.printf("Average weekly sales: " + '$' + "%,.2f\n\n", totalAverage);	
        System.out.printf("The highest sales were made during week %d \n", weeknumH);	
        System.out.printf("The Lowest sales were made during week %d \n\n", weeknumL);	
    }
}