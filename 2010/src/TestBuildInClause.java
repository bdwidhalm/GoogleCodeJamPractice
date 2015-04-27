import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestBuildInClause
{

  public static void main(String[] args)
  {
    List<Integer> testList = new ArrayList<Integer>();
    testList.add(1);
    testList.add(2);
    testList.add(3);
    testList.add(4);
    testList.add(5);
    testList.add(6);
    testList.add(10);
    testList.add(11);
    testList.add(12);
    testList.add(13);

    System.out.println("TestList Before: " + testList.toString());
    System.out.println("Built In Clause: " + buildInClause(testList));

  }

  public static String buildInClause(Collection<?> obs)
  {
    StringBuilder sb = new StringBuilder();
    sb.append("(");

    if (obs != null && !obs.isEmpty())
    {

      Integer size = sb.length();
      for (Object o : obs)
      {
        sb.append(", ")
            .append(o.toString());
      }

      sb.delete(size, size + 2);
    }
    sb.append(")");

    return sb.toString();
  }

}
