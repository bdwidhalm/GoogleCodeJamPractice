import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SpeakingTongues
{
  private static String FILENAME = "A-small-practice.in";

  // private static String FILENAME = "A-large-practice.in";
  // private static String FILENAME = "B-small-practice.in";
  // private static String FILENAME = "B-large-practice.in";
  // private static String FILENAME = "C-small-practice.in";
  // private static String FILENAME = "C-large-practice.in";
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

      Map<Character, Character> key = getKey();

      System.out.println(numberTestCases);

      for (int i = 1; i <= numberTestCases; i++)
      {
        String result = "";

        String code = br.readLine();
        for (char ch : code.toCharArray())
        {
          result = result + key.get(ch);
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

  private static Map<Character, Character> getKey()
  {
    BufferedReader keyRead = null;
    Map<Character, Character> keyMap = new HashMap<Character, Character>();

    try
    {
      keyRead = new BufferedReader(new FileReader("keyMap.key"));

      String code = keyRead.readLine();
      String read = keyRead.readLine();

      for (int i = 0; i < code.length(); i++)
      {
        keyMap.put(code.charAt(i), read.charAt(i));
        // System.out.println(code.charAt(i)+ " = " + read.charAt(i));
      }

      char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

      for (char c : alpha)
      {
        System.out.println(c + " = " + keyMap.get(c));
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
        keyRead.close();
      }
      catch (IOException e)
      {
        System.out.println(e);
      }
    }


    return keyMap;
  }
}
