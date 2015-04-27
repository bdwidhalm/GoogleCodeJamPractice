import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AlienLanguage
{
  public static void main(String[] args)
  {
    BufferedReader br = null;

    try
    {
      br = new BufferedReader(new FileReader("A-large-practice.in"));
      String currentLine = br.readLine();
      String[] testInfo = currentLine.split(" ");
      int wordLength = Integer.parseInt(testInfo[0]);
      int dictionarySize = Integer.parseInt(testInfo[1]);
      int numberTestCases = Integer.parseInt(testInfo[2]);
      List<String> dictionary = new ArrayList<String>();

      for (int i = 0; i < dictionarySize; i++)
      {
        dictionary.add(br.readLine());
      }

      for (int j = 0; j < numberTestCases; j++)
      {
        String testWord = br.readLine();
        // System.out.println(testWord);
        String regExWord = testWord.replace("(", "[");
        regExWord = regExWord.replace(")", "]");
        // System.out.println("RegEx? " + regExWord);
        int occurs = 0;

        for (String word : dictionary)
        {
          if (word.matches(regExWord))
          {
            occurs++;
          }
        }
        System.out.println("Case #" + (j + 1) + ": " + occurs);
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
