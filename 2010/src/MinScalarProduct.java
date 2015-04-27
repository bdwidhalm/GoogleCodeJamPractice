import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;


public class MinScalarProduct
{
  public static void main(String[] args)
  {
    BufferedReader br = null;

    try
    {
      br = new BufferedReader(new FileReader("A-large-practice.in"));
      String currentLine = br.readLine();

      int numberTestCases = Integer.parseInt(currentLine);
      // System.out.println("Test Cases: " + numberTestCases);

      for (int i = 1; i <= numberTestCases; i++)
      {
        int setSize = Integer.parseInt(br.readLine());
        // System.out.println("Set Size: " + setSize);

        String set1String = br.readLine();
        // System.out.println("Set1: " + set1String);
        String[] set1StringArray = set1String.split(" ");
        String set2String = br.readLine();
        // System.out.println("Set2: " + set2String);
        String[] set2StringArray = set2String.split(" ");

        int[] set1 = new int[setSize];
        int[] set2 = new int[setSize];

        for (int n = 0; n < setSize; n++)
        {
          // System.out.println("Set1: " + set1StringArray[n]);
          // System.out.println("Set2: " + set2StringArray[n]);
          set1[n] = Integer.parseInt(set1StringArray[n]);
          set2[n] = Integer.parseInt(set2StringArray[n]);
        }

        Arrays.sort(set1);
        Arrays.sort(set2);

        BigInteger sum = BigInteger.valueOf(0);

        // System.out.println("Set1 Size Test: " + set1.length);
        // System.out.println("Set2 Size Test: " + set2.length);
        for (int n = 0; n < setSize; n++)
        {
          BigInteger product = BigInteger.valueOf(0);
          product = BigInteger.valueOf(set1[n]).multiply(BigInteger.valueOf(set2[setSize - n - 1]));
          sum = sum.add(product);
          // System.out.println("Product: " + set1[n] + " * " + set2[setSize - n - 1] + " = " + product);
          // System.out.println("Sum: " + sum);
        }

          System.out.println("Case #" + i + ": " + sum.toString());

      }

    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    finally
    {
      try
      {
        br.close();
      }
      catch (IOException e)
      {
        System.out.println(e);
      }
    }

  }
}
