import java.util.Collection;


public class TestRegistryMethods
{

  private static String buildInClause(Collection<?> obs)
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
