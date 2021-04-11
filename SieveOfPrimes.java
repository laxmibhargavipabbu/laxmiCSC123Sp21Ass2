package Assignment2;
public class SieveOfPrimes
{
    public static void SieveOfPrime(int n)
    {
        boolean arrPrime[] = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i <= n; i++)
        {
            arrPrime[i] = true;
        }
 
        for (int j = 2; j * j <= n; j++) 
        {
            if (arrPrime[j] == true) 
            {
               for (int i = j * j; i <= n; i = i+j)
               {
                    arrPrime[i] = false;
               }
            }
        }
        for (int i = 2; i <= n; i++)
        {
            if (arrPrime[i] == true)
             {
             	 System.out.printf(i + " is a prime.\n");
             	 count ++;
             }
        }
        System.out.printf("%d primes found \n", count);
    }
    
    public static void main(String args[])
    {
        int n = 999;
        SieveOfPrime(n);
    }
}