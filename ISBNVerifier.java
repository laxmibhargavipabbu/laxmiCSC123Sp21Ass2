package laxmiCSC123Sp21Ass2;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ISBNVerifier
{	
	public static Scanner createScanner(String input) throws FileNotFoundException
	{
		Scanner inputReader;
		inputReader = new Scanner(new File(input));
		return inputReader;
	}
	
	public static String checkISBN(String inputLine)
	{
		StringBuilder outputStrBldr = new StringBuilder();
		int hyphenCount = 0;
		int isbnSum = 0;
		int rem = 0;
		String[] dashes = inputLine.split("-");
		String isbn = "";
		isbn = isbn.replaceAll("-", ""); 

		outputStrBldr.append("A check on the ISBN ");
		outputStrBldr.append(inputLine);
		outputStrBldr.append(" yields:");
		
		if (inputLine.length() != 13)
		{
			outputStrBldr.append("Bad Length");
			return outputStrBldr.toString();
		}
		
		char checkSum = inputLine.charAt(12);
		if ((checkSum < '0' || checkSum > '9') && checkSum != 'X')
		{
			outputStrBldr.append("Final Character is bad");
			return outputStrBldr.toString();
		}
		
		for (int i = 0; i < 13; i++)
		{
			if (!(inputLine.charAt(i) > '0' || inputLine.charAt(i) < '9' || inputLine.charAt(i) != '-'))
			{
				outputStrBldr.append("Character not a digit or -");
				return outputStrBldr.toString();
			}
			if (inputLine.charAt(i) == '-')
			{
				hyphenCount++;
			}
		}
		
		if (hyphenCount != 3)
		{
			outputStrBldr.append("There are not 3 dashes as required");
			return outputStrBldr.toString();
		}
		
		for (int i = 0, j = 10; i < 12; i++)
		{
			if (inputLine.charAt(i) != '-')
			{
				isbnSum = isbnSum + ((inputLine.charAt(i) - '0') * j);
				j--;
			}
		}
		
		rem = isbnSum % 11;
		if ((11 - rem) == checkSum - '0')
		{
			outputStrBldr.append("Good Digits Match");
			return outputStrBldr.toString();
		}
		else if (checkSum == 'X' && (11 - rem) == 10)
		{
			outputStrBldr.append("Good - final digit is X");
			return outputStrBldr.toString();
		}
		else 
		{
			outputStrBldr.append("Final digit doesn't match check digit or X");
			return outputStrBldr.toString();
		}
	}
	public static void main (String [] args) throws IOException 
	{
		StringBuilder inputStrBldr = new StringBuilder();
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Please enter a the file name containing the ISBN Files: ");
		String inputFileName = keyboard.next();
		Scanner inputFile = createScanner(inputFileName);
		while (inputFile.hasNextLine())
        {
        	String lines = inputFile.nextLine();
        	inputStrBldr.append(checkISBN(lines));
        	inputStrBldr.append(System.getProperty("line.separator"));
		}
		System.out.println(inputStrBldr.toString());
	}		
}