import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Base
{
  public static void main(String args[])
  {
    Scanner scan = null;
    try
    {
      scan = new Scanner(new File(JOptionPane.showInputDialog("Please input filepath, e.g. C:/Documents/A-small.in")));
    }
    catch (FileNotFoundException e)
    {
    }
    String answer = "";
    int numCases = Integer.parseInt(scan.nextLine());
    for (int i = 0; i < numCases; i++)
    {
      answer += "Case #" + (i + 1) + ": ";
      String line = scan.nextLine();
      TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
      tm.put(line.charAt(0), 1);
      int cur = 2;
      for (int j = 1; j < line.length(); j++)
      {
        if (!tm.containsKey(line.charAt(j)))
        {
          if (tm.size() == 1)
            tm.put(line.charAt(j), 0);
          else
            tm.put(line.charAt(j), cur++);
        }
      }
      int base = tm.size(), numSec = 0;
      if (base == 1)
        base = 2;
      for (int j = line.length() - 1; j >= 0; j--)
      {
        numSec += ((int)(Math.pow(base, j))) * tm.get(line.charAt(line.length() - 1 - j));
      }
      answer += numSec + "\n";
    }

    PrintWriter pw = null;
    try
    {
      pw = new PrintWriter(new FileOutputStream("output.txt"));
    }
    catch (FileNotFoundException e)
    {
    }
    pw.write(answer);
    pw.close();
    scan.close();
  }
}
