import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RopeIntranet
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
        int ropes = Integer.parseInt(br.readLine());
        List<Integer> leftValues = new ArrayList<Integer>();
        List<Integer> rightValues = new ArrayList<Integer>();
        int count = 0;
        for (int j = 1; j <= ropes; j++)
        {
          String[] ropePositions = br.readLine().split(" ");
          leftValues.add(Integer.parseInt(ropePositions[0]));
          rightValues.add(Integer.parseInt(ropePositions[1]));
        }

        for (int j = 0; j < ropes; j++)
        {
          for (int k = j + 1; k < ropes; k++)
          {
            float slope1 = rightValues.get(j) - leftValues.get(j);
            float slope2 = rightValues.get(k) - leftValues.get(k);
            if(slope1 == slope2)
            {
              // lines are parallel do nothing;
              continue;
            }
            else
            {
              float commonX = (leftValues.get(j) - leftValues.get(k))/(slope2 - slope1);
              if (commonX > 0 && commonX < 1)
              {
                count++;
              }
            }
          }
        }

        System.out.println("Case #" + i + ": " + count);
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
