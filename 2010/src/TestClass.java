
public class TestClass
{
  private int number;
  private String text;
  

  public TestClass()
  {
  }
  
  public TestClass(TestClass testClass)
  {
    this.number = testClass.number;
    this.text = testClass.text;
  }
  
  public int getNumber()
  {
    return number;
  }
  public void setNumber(int number)
  {
    this.number = number;
  }

  public String getText()
  {
    return text;
  }
  public void setText(String text)
  {
    this.text = text;
  }


  
  
}
