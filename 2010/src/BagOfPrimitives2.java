public class BagOfPrimitives2
{
  private int value1 = 1;
  private String value2 = "abc";
  private transient int value3 = 3;
  private String nullvalue = null;

  BagOfPrimitives2()
  {
    // no-args constructor
  }

  @Override
  public String toString()
  {
    return "value1: " + value1 + "  value2: " + value2 + "  value3: " + value3 + "  nullvalue: " + nullvalue;
  }


}
