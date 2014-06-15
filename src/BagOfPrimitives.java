public class BagOfPrimitives
{
  private int value1 = 1;
  private String value2 = "abc";
  private transient int value3 = 3;
  private String nullvalue = null;

  BagOfPrimitives()
  {
    // no-args constructor
  }

  @Override
  public String toString()
  {
    return "value1: " + value1 + "  value2: " + value2 + "  value3: " + value3 + "  nullvalue: " + nullvalue;
  }


}
