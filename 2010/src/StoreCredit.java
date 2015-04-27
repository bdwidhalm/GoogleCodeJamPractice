import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StoreCredit
{

  public static void main(String[] args)
  {
    BufferedReader br = null;

    try
    {
      br = new BufferedReader(new FileReader("A-large-practice.in"));
      String currentLine = br.readLine();

      int numberTestCases = Integer.parseInt(currentLine);

      for (int i = 1; i <= numberTestCases; i++)
      {
        int credit = Integer.parseInt(br.readLine());
        int items = Integer.parseInt(br.readLine());
        String itemsString = br.readLine();

        // System.out.println("Credit: " + credit);
        // System.out.println("Items: " + items);
        // System.out.println("Item List: " + itemsString);

        String[] itemsStringArray = itemsString.split(" ");
        int[] itemsArray = new int[itemsStringArray.length];

        for (int n = 0; n < itemsStringArray.length; n++)
        {
          itemsArray[n] = Integer.parseInt(itemsStringArray[n]);
        }

        for (int item1 = 0; item1 < items; item1++)
        {
          int cost = -1;
          for (int item2 = 0; item2 < items; item2++)
          {
            cost = itemsArray[item1] + itemsArray[item2];
            if (cost == credit && item1 != item2)
            {
              System.out.println("Case #" + i + ":  " + (item1 + 1) + " " + (item2 + 1));
              break;
            }
          }
          if (cost == credit)
          {
            break;
          }
        }

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
