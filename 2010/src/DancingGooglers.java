import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class DancingGooglers
{
  // private static String FILENAME = "A-small-practice.in";
  // private static String FILENAME = "A-large-practice.in";
   private static String FILENAME = "B-small-practice.in";
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

      System.out.println(numberTestCases);

      for (int i = 1; i <= numberTestCases; i++)
      {
        String result = "";

        String[] row = br.readLine().split(" ");
        int numGooglers = Integer.parseInt(row[0]);
        int numSurprises = Integer.parseInt(row[1]);
        int scoreToCheck = Integer.parseInt(row[2]);

        for (int j = 3; j < row.length; j++)
        {

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
