

import java.util.ArrayList;
import java.util.List;


public class TestNullLists
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    List<Integer> test = new ArrayList<Integer>();

    if (test != null)
    {
      System.out.println("test == null");
    }
    else
    {
      System.out.println("test == null");
    }

  }

  private static List<Integer> getCacheCopy()
  {
    List<Integer> dataFileHistory = getList();

    if (dataFileHistory == null)
    {
      System.out.println("dataFileHistory == null");
    }

    if (dataFileHistory != null)
    {
      System.out.println("dataFileHistory != null");
    }

    if (dataFileHistory.size() > 0)
    {
      System.out.println("dataFileHistory.size() > 0");
    }

    return null;
  }

  private static List<Integer> getList()
  {
    return null;
  }
}
