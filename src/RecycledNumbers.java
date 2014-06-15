import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers
{
 //private static String FILENAME = "A-small-practice.in";
 // private static String FILENAME = "A-large-practice.in";
 // private static String FILENAME = "B-small-practice.in";
 // private static String FILENAME = "B-large-practice.in";
 // private static String FILENAME = "C-small-practice.in";
  private static String FILENAME = "C-large-practice.in";
 // private static String FILENAME = "D-small-practice.in";
 // private static String FILENAME = "D-large-practice.in";

 public static void main(String[] args)
 {
   BufferedReader br = null;
   String outFileName;
   if (FILENAME.contains("small"))
   {
     outFileName = "small.out";
   }
   else
   {
     outFileName = "large.out";
   }

   try
   {
     FileWriter fstream = new FileWriter(outFileName);
     BufferedWriter out = new BufferedWriter(fstream);

     br = new BufferedReader(new FileReader(FILENAME));
     int numberTestCases = Integer.parseInt(br.readLine());

     System.out.println(numberTestCases);

     for (int i = 1; i <= numberTestCases; i++)
     {
       int result = 0;

       String line = br.readLine();
       String a = line.split(" ")[0];
       String b = line.split(" ")[1];

       int intA = Integer.parseInt(a);
       int intB = Integer.parseInt(b);

       int power = 1;
       int temp = intA;

       while (temp >= 10)
       {
         power *= 10;
         temp /= 10;
       }

        for (int n = intA; n <= intB; n++)
        {
          temp = n;

          while(true)
          {
            temp = (temp / 10) + ((temp % 10) * power);
            if (temp == n)
            {
              // loop all around made 123 -> 231 -> 312 -> 123 or pattern 2121 -> 1212 -> 2121
              break;
            }
            if (temp > n && temp <= intB)
            {
              result++;
              // System.out.println("temp= " + temp);
            }
          }



        }





       System.out.println("Case #" + i + ": " + result);
       out.write("Case #" + i + ": " + result + "\n");
     }

     out.close();
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
