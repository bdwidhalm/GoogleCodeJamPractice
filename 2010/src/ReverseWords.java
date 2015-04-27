import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReverseWords
{
  public static void main(String[] args)
  {
    BufferedReader br = null;

    try
    {
      br = new BufferedReader(new FileReader("B-large-practice.in"));
      String currentLine = br.readLine();

      int numberTestCases = Integer.parseInt(currentLine);

      for (int i = 1; i <= numberTestCases; i++)
      {
        currentLine = br.readLine();
        String[] forward = currentLine.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("Case #" + i + ": ");

        for (int j = forward.length - 1; j >= 0; j--)
        {
          sb.append(forward[j] + " ");
        }
        System.out.println(sb.toString());
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
