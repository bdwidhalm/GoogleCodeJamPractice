
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TestWorld
{

  public final static String HASH_MD5 = "MD5";
  public final static String HASH_SHA1 = "SHA-1";

  public final static String HASH_DEFAULT = HASH_SHA1;

//random number generator
 private static final Random randomNumber = new Random();

 public static void main(String[] args) {
   char x = 'X';
   int i = 0;
   System.out.print(true  ? x : 0);
   System.out.print(false ? i : x);
}

 public static void puzzle6() {
   int x = 1984;
   int y = 2001;
   x ^= y ^= x ^= y;
   System.out.println("x = " + x + "; y = " + y);
}

 public static void ipColorTest()
 {
  System.out.println(ipToHtmlColor("172.17.1.2"));
 }

 public static String ipToHtmlColor(String ipAddress)
 {
   String[] ipNums = ipAddress.split("\\.");
   int red = Integer.parseInt(ipNums[1]);
   int green = Integer.parseInt(ipNums[2]);
   int blue = Integer.parseInt(ipNums[3]);
   return String.format("#%02x%02x%02x", red, green, blue);
 }

 public static void binaryTest()
 {
  System.out.println(binaryFirstTen());
 }

  public static List<Integer> binaryFirstTen()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (int i = 1; i <= 10; i++)
    {
      String binaryString = "";
      int binaryLength;
      int bitCheck;
      int counter = 1;
      int decimalNumber = 0;
      int multiplier = 1;
      for (int j = 0; j < i; j++)
      {
        binaryString += "1";
      }
      binaryLength = binaryString.length();
      while (counter <= binaryLength)
      {
        if (counter == 1)
        {
          bitCheck = Integer.parseInt(binaryString.substring(binaryLength - counter));
        }
        else
        {
          bitCheck = Integer.parseInt(binaryString.substring(binaryLength - counter, binaryLength - counter + 1));
        }
        counter += 1;
        decimalNumber = decimalNumber + bitCheck * multiplier;
        multiplier = multiplier * 2;
      }
      System.out.println("Binary Number: " + binaryString + " Decimal equivalant is: " + decimalNumber);
      output.add(decimalNumber);
    }
    return output;
  }

 public static void testUniquePair()
 {
   List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 3, 2, 4, 2, 5, 3, 3));
   int num = 6;

   System.out.println(uniquePair(intList, num));
 }

 public static List<List<Integer>> uniquePair(List<Integer> input, int number)
 {
   List<List<Integer>> output = new ArrayList<List<Integer>>();
   Set<List<Integer>> outSet = new HashSet<List<Integer>>();

   for (int i = 0; i < input.size(); i++)
   {
     for (int j = 0; j < input.size(); j++)
     {
       if ((input.get(i) + input.get(j) == number) && (i != j))
       {
         List<Integer> addList = new ArrayList<Integer>(Arrays.asList(input.get(i), input.get(j)));
         List<Integer> checkReverse = new ArrayList<Integer>(Arrays.asList(input.get(j), input.get(i)));

         if (!outSet.contains(checkReverse))
        {
          outSet.add(addList);
        }
       }
     }
   }

   output.addAll(outSet);

   return output;
 }

 public static void listQuestion()
 {
   List<Integer> input = new ArrayList<Integer>();
   input.add(1);
   input.add(2);
   input.add(3);
   input.add(4);

    List<Integer> output = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1));

    for (int i = 0; i < input.size(); i++)
    {
      int k = 1;
      for (int j = 0; j < input.size(); j++)
      {
        if (i != j)
        {
          k = k * input.get(j);
        }
      }
      output.add(k);
    }

    System.out.println(input);
    System.out.println(output);
    System.out.println("[24, 12, 8, 6]????");

 }

 public static void stringIntern()
 {
   String s = "abcdefgh";
   String t = "ijklmnop";
   String q = "abcdefgh";

   long startStringTime = System.currentTimeMillis();
   System.out.println(startStringTime);

   if(s.equals(t))
   {
     System.out.println("s=t True");
   }
   else
   {
     System.out.println("s=t False");
   }
   if(s.equals(q))
   {
     System.out.println("s=q True");
   }
   else
   {
     System.out.println("s=q False");
   }
   if(t.equals(q))
   {
     System.out.println("t=q True");
   }
   else
   {
     System.out.println("t=q False");
   }

   long stopStringTime = System.currentTimeMillis();
   System.out.println(stopStringTime);

   long startInternTime = System.currentTimeMillis();
   System.out.println(startInternTime);

   if(s.intern() == t.intern())
   {
     System.out.println("s=t True");
   }
   else
   {
     System.out.println("s=t False");
   }
   if(s.intern() == q.intern())
   {
     System.out.println("s=q True");
   }
   else
   {
     System.out.println("s=q False");
   }
   if(t.intern() == q.intern())
   {
     System.out.println("t=q True");
   }
   else
   {
     System.out.println("t=q False");
   }

   long stopInternTime = System.currentTimeMillis();
   System.out.println(stopInternTime);

   System.out.println("String.equals() time = " + stopStringTime);
   System.out.println("String.equals() time = " + stopInternTime);

 }

 public static void zeroTest()
 {
   String testZero = "0123";
   int testInt = 123;

   int convertedString = Integer.parseInt(testZero);

   System.out.println(testZero + " -> " + convertedString);

   System.out.println(testInt == convertedString);
 }


 public static void recycledNumbersTest()
 {
   int A = 1111;
   int B = 2222;

   System.out.println("For: A= " + A + " & B= " + B);

   int power = 1;
   int temp = A;

   System.out.println("power= " + power + "  temp= " + temp);

   while (temp >= 10)
   {
     power *= 10;
     temp /= 10;
     System.out.println("power= " + power + "  temp= " + temp);
   }

   int result = 0;

   for (int n = A; n <= B; ++n)
   {
     temp = n;
     System.out.println("n= " + n);
     while (true)
     {
       temp = (temp / 10) + ((temp % 10) * power);
       System.out.println("temp= " + temp);
       if (temp == n)
       {
         System.out.println("break out!!!");
         break;
       }
       if (temp > n && temp <= B)
       {
         result++;
         System.out.println(temp + " > " + n + " & " + temp + " <= " + B + " ....increment Result: " + result);
       }
     }
   }

   System.out.println("Result: " + result);

 }

 public static void trimUrl()
 {
   String returnValue = "http://databin.gilbertschools.net/databin";

   String developmentUrl = returnValue.substring(returnValue.indexOf(".net") + 4);

   System.out.println("Before: " + returnValue);
   System.out.println(" After: " + developmentUrl);

 }


  public static void randomNumberTest()
  {
    for (int i = 0; i < 20; i++)
    {
      System.out.println("Round #" + (i + 1));
      // randomly select to save or delete
      int saveDeleteInt = randomNumber.nextInt(2);
      // 0 for save....1 for delete
      System.out.println("Random Number: " + saveDeleteInt);
    }

  }

  public static void addingWeeks()
  {
    Calendar infoDate = Calendar.getInstance();

    infoDate.set(Calendar.DAY_OF_WEEK, 2);
    Date monDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Monday: " + monDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 3);
    Date tueDate = new Date(infoDate.getTime().getTime());
    System.out.println("  Tuesday: " + tueDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 4);
    Date wedDate = new Date(infoDate.getTime().getTime());
    System.out.println("Wednesday: " + wedDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 5);
    Date thuDate = new Date(infoDate.getTime().getTime());
    System.out.println(" Thursday: " + thuDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 6);
    Date friDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Friday: " + friDate.toString());

    infoDate.add(Calendar.WEEK_OF_YEAR, -1);
    infoDate.set(Calendar.DAY_OF_WEEK, 2);
    monDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Monday: " + monDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 3);
    tueDate = new Date(infoDate.getTime().getTime());
    System.out.println("  Tuesday: " + tueDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 4);
    wedDate = new Date(infoDate.getTime().getTime());
    System.out.println("Wednesday: " + wedDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 5);
    thuDate = new Date(infoDate.getTime().getTime());
    System.out.println(" Thursday: " + thuDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 6);
    friDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Friday: " + friDate.toString());


    infoDate.add(Calendar.WEEK_OF_YEAR, 2);
    infoDate.set(Calendar.DAY_OF_WEEK, 2);
    monDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Monday: " + monDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 3);
    tueDate = new Date(infoDate.getTime().getTime());
    System.out.println("  Tuesday: " + tueDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 4);
    wedDate = new Date(infoDate.getTime().getTime());
    System.out.println("Wednesday: " + wedDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 5);
    thuDate = new Date(infoDate.getTime().getTime());
    System.out.println(" Thursday: " + thuDate.toString());
    infoDate.set(Calendar.DAY_OF_WEEK, 6);
    friDate = new Date(infoDate.getTime().getTime());
    System.out.println("   Friday: " + friDate.toString());

  }



  public static void stringEqualsTest()
  {

    String lower = "b";
    String upper = "B";

    System.out.println("b == B ? - " + (lower == upper));
    System.out.println("b.equals(B) ? - " + (lower.equals(upper)));

  }



  public static void dateTimeTest()
  {
    long hour = 3600000;

    Date now = new Date();
    Date nowPlus4 = new Date();
    Date nowPlusLunch = new Date();
    Date nowPlus8 = new Date();

    nowPlus4.setTime(now.getTime() + (4 * hour));
    nowPlusLunch.setTime((long)(now.getTime() + (4.5 * hour)));
    nowPlus8.setTime(now.getTime() + (8 * hour));

    System.out.println("\nAfter adjustment");
    System.out.println("         now milli - " + now.getTime());
    System.out.println("    nowPlus4 milli - " + nowPlus4.getTime());
    System.out.println("nowPlusLunch milli - " + nowPlusLunch.getTime());
    System.out.println("    nowPlus8 milli - " + nowPlus8.getTime());

    System.out.println("\nDifferences");
    System.out.println("    now - nowPlus4 - " + (nowPlus4.getTime() - now.getTime()));
    System.out.println("now - nowPlusLunch - " + (nowPlusLunch.getTime() - now.getTime()));
    System.out.println("    now - nowPlus8 - " + (nowPlus8.getTime() - now.getTime()));

    System.out.println("\nDifferences converted to hours?");
    System.out.println("    now - nowPlus4 - " + (nowPlus4.getTime() - now.getTime()) / hour);
    System.out.println("now - nowPlusLunch - " + (nowPlusLunch.getTime() - now.getTime()) / hour);
    System.out.println("    now - nowPlus8 - " + (nowPlus8.getTime() - now.getTime()) / hour);

  }

  private static String generateHash(String algorithm, String path)
  {
    String returnValue = "";

    try
    {
      final int BUFFER_SIZE = 1024 * 1024;

      if ((algorithm == null) || ("".equals(algorithm)))
      {
        algorithm = HASH_DEFAULT;
      }

      MessageDigest digest = MessageDigest.getInstance(algorithm);

      File inputFile = new File(path);
      InputStream is = new FileInputStream(inputFile);
      byte[] buffer = new byte[BUFFER_SIZE];

      int read = 0;
      try
      {
        long count = 0;
        while ((read = is.read(buffer)) > 0)
        {
          digest.update(buffer, 0, read);

          count++;
        }

        returnValue = digestToString(digest);
      }
      catch (IOException e)
      {
        throw new RuntimeException("Unable to generate hashes for file: " + path, e);
      }
      finally
      {
        try
        {
          is.close();
        }
        catch (IOException e)
        {
          throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
        }
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }

    return returnValue;
  }

  private static String digestToString(MessageDigest digest)
  {
    byte[] sum = digest.digest();
    BigInteger bigInt = new BigInteger(1, sum);
    return bigInt.toString(16);
  }

}
