import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class FileFixIt
{
  public static void main(String[] args)
  {
    BufferedReader br = null;

    try
    {
      br = new BufferedReader(new FileReader("A-large-practice.in"));
      int numberTestCases = Integer.parseInt(br.readLine());

      for (int i = 1; i <= numberTestCases; i++)
      {
        // System.out.println("TestCase #" + i + " of " + numberTestCases);
        String[] testInfo = br.readLine().split(" ");
        int existDirectoryCount = Integer.parseInt(testInfo[0]);
        int makeDirectoryCount = Integer.parseInt(testInfo[1]);

        Set<String> existDirectory = new HashSet<String>();
        Set<String> makeDirectory = new HashSet<String>();

        // System.out.println("Existing count: " + existDirectoryCount);
        // System.out.println("    Make count: " + makeDirectoryCount);

        for (int j = 0; j < existDirectoryCount; j++)
        {
          String directory = br.readLine();
          existDirectory.add(directory);
          // System.out.println(directory);
          while(directory.replaceFirst("/", "").split("/").length > 1)
          {
            directory = directory.substring(0, directory.lastIndexOf("/"));
            existDirectory.add(directory);
            // System.out.println(directory);
          }
        }

        for (int k = 0; k < makeDirectoryCount; k++)
        {
          String directory = br.readLine();
          makeDirectory.add(directory);
          // System.out.println(directory);
          while(directory.replaceFirst("/", "").split("/").length > 1)
          {
            directory = directory.substring(0, directory.lastIndexOf("/"));
            makeDirectory.add(directory);
            // System.out.println(directory);
          }
        }

        makeDirectory.removeAll(existDirectory);

        System.out.println("Case #" + i + ": " + makeDirectory.size());
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
