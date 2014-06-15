import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllYourBase
{
  private static String FILENAME = "A-small-practice.in";
  // private static String FILENAME = "A-large-practice.in";

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
        String message = br.readLine();
        Map<Character, Integer> uniqueMap = new HashMap<Character, Integer>();

        int value = 2;

        for (char ch : message.toCharArray())
        {
          if (uniqueMap.containsKey(ch))
          {
            continue;
          }
          if (uniqueMap.size() == 0)
          {
            uniqueMap.put(ch, 1);
          }
          else if (uniqueMap.size() == 1)
          {
            uniqueMap.put(ch, 0);
          }
          else
          {
            uniqueMap.put(ch, uniqueMap.size());
          }
        }

        int minBase = uniqueMap.size();

        if (uniqueMap.size() == 1)
        {
          minBase = 2;
        }

        long result = 0;

        for (char ch : message.toCharArray())
        {
          result = result * minBase + uniqueMap.get(ch);
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
