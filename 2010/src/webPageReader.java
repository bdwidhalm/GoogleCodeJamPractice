import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class webPageReader
{

  public static void main(String[] args) throws IOException
  {

    String line = null;

    URL url = new URL("http://google.com");

    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

    while (rd.readLine() != null)
    {

      line = rd.readLine();

      // remove any HTML inserted
      String noHtml = line.replaceAll("\\<.*?>", "");
      // convert any newlines so they display
      // String htmlNote = noHtml.replace("\n", "<br/>");
      System.out.println(noHtml);

      // System.out.println(line);

    }

  }
}