

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rotate2010
{
  // private static String FILENAME = "A-small-practice.in";
  private static String FILENAME = "A-large-practice.in";

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
        boolean blue = false;
        boolean red = false;
        String[] testInfo = br.readLine().split(" ");
        int size = Integer.parseInt(testInfo[0]);
        System.out.println("Size: " + size);
        int winSize = Integer.parseInt(testInfo[1]);
        System.out.println("Score: " + winSize);
        String blueWinCheck = "";
        String redWinCheck = "";
        for (int w = 0; w < winSize; w++)
        {
          blueWinCheck = blueWinCheck + "B";
          redWinCheck = redWinCheck + "R";
        }

        System.out.println("To Score: ");
        System.out.println(blueWinCheck);
        System.out.println(redWinCheck);

        List<String> gameBoard = new ArrayList<String>();

        for (int r = 0; r < size; r++)
        {
          String row = br.readLine();
          // System.out.println("********** BEFORE: " + row);
          String rotatedRow = row;

          while (rotatedRow.endsWith(".") && (rotatedRow.contains("B") || rotatedRow.contains("R")))
          {
            rotatedRow = "." + rotatedRow.substring(0, rotatedRow.length() - 1);
            // System.out.println("END MOVE: " + rotatedRow);
          }

          if (rotatedRow.contains("B") || rotatedRow.contains("R"))
          {
            while ((rotatedRow.lastIndexOf(".") > rotatedRow.indexOf("B") && (rotatedRow.indexOf("B") != -1)) || (rotatedRow.lastIndexOf(".") > rotatedRow.indexOf("R") && (rotatedRow.indexOf("R") != -1)))
            {
              // System.out.println("LastIndex of . : " + rotatedRow.lastIndexOf("."));
              // System.out.println("    Index of B : " + rotatedRow.indexOf("B"));
              // System.out.println("    Index of R : " + rotatedRow.indexOf("R"));

              rotatedRow = "." + rotatedRow.substring(0, rotatedRow.lastIndexOf(".")) + rotatedRow.substring(rotatedRow.lastIndexOf(".") + 1);
              // System.out.println("MID MOVE: " + rotatedRow);
            }
          }
          //  System.out.println("**********  AFTER: " + rotatedRow);
          gameBoard.add(rotatedRow);
        }

        for (int g = 0; g < size; g++)
        {
          System.out.println(gameBoard.get(g));
        }

        for (int y = 0; y < size; y++)
        {
          // check horizontal
          if (gameBoard.get(y).contains(blueWinCheck))
          {
            System.out.println(gameBoard.get(y));
            System.out.println("* * * * * * * * * BLUE SCORES * * * * * * * * * ");
            blue = true;
          }
          if (gameBoard.get(y).contains(redWinCheck))
          {
            System.out.println(gameBoard.get(y));
            System.out.println("* * * * * * * * *  RED SCORES * * * * * * * * * ");
            red = true;
          }

          // check vertical
          String verticalRow = "";
          for (int z = 0; z < size; z++)
          {
            verticalRow = verticalRow + gameBoard.get(z).substring(y, y + 1);
          }
          //System.out.println("Vertical Check: " + verticalRow);
          if (verticalRow.contains(blueWinCheck))
          {
            System.out.println(verticalRow);
            System.out.println("* * * * * * * * * BLUE SCORES * * * * * * * * * ");
            blue = true;
          }
          if (verticalRow.contains(redWinCheck))
          {
            System.out.println(verticalRow);
            System.out.println("* * * * * * * * *  RED SCORES * * * * * * * * * ");
            red = true;
          }
        }

        for (int y = 0; y < size; y++)
        {
          for (int x = 0; x < size; x++)
          {
            // diagonals
            String diagonalA = "";
            String diagonalB = "";

            System.out.println("Diagonal Check:");
            System.out.println("x= " + x);
            System.out.println("y= " + y);

            for (int j = 0; j <= size; j++)
            {
              if ((y + j) < size && (x + j + 1) <= size)
              {
                diagonalA = diagonalA + gameBoard.get(y + j).substring(x + j, x + j + 1);
              }
              if ((y + j) < size && (x - j) > -1)
              {
                diagonalB = diagonalB + gameBoard.get(y + j).substring(x - j, x - j + 1);
              }
              // System.out.println("j= " + j);
            }

            System.out.println("   diagA Check: " + diagonalA);
            System.out.println("   diagB Check: " + diagonalB);

            if (diagonalA.contains(blueWinCheck) || diagonalB.contains(blueWinCheck))
            {
              System.out.println("* * * * * * * * * BLUE SCORES * * * * * * * * * ");
              blue = true;
            }
            if (diagonalA.contains(redWinCheck) || diagonalB.contains(redWinCheck))
            {
              System.out.println("* * * * * * * * *  RED SCORES * * * * * * * * * ");
              red = true;
            }
          }
        }

        String result = "";
        if (blue && red)
        {
          result = "Both";
        }
        else if (!blue && !red)
        {
          result = "Neither";
        }
        else if (blue && !red)
        {
          result = "Blue";
        }
        else if (!blue && red)
        {
          result = "Red";
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
