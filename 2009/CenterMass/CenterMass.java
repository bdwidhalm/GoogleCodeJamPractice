
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CenterMass
{
    private static String FILENAME = "sample.in";
    // private static String FILENAME = "A-small-attempt0.in";
    // private static String FILENAME = "A-large-practice.in";
    
    public static void main(String[] args)
    {
        BufferedReader br = null;
        String outFileName;
        if (FILENAME.contains("small"))
        {
            outFileName = "small.out";
        }
        else if (FILENAME.contains("large"))
        {
            outFileName = "large.out";
        }
        else
        {
            outFileName = "sample.out";
        }

        try
        {
            FileWriter fstream = new FileWriter(outFileName);
            BufferedWriter out = new BufferedWriter(fstream);

            br = new BufferedReader(new FileReader(FILENAME));
            int numberTestCases = Integer.parseInt(br.readLine());

            System.out.println("# Test Cases= " + numberTestCases);
            
            
            for (int i = 1; i <= numberTestCases; i++)
            {
                // get firefly count
                int count = Integer.parseInt(br.readLine());
                System.out.println("Fly Count= " + count);
                
                int[] orgXFly = new int[count];
                int[] orgYFly = new int[count];
                int[] orgZFly = new int[count];
                
                int xDist = 0;
                int yDist = 0;
                int zDist = 0;
                
                int[] orgVXFly = new int[count];
                int[] orgVYFly = new int[count];
                int[] orgVZFly = new int[count];
                
                for (int f = 0; f < count; f++)
                {
                    String[] flyInfo = br.readLine().split(" ");
                    orgXFly[f] = Integer.parseInt(flyInfo[0]);
                    orgYFly[f] = Integer.parseInt(flyInfo[1]);
                    orgZFly[f] = Integer.parseInt(flyInfo[2]);
                    
                    //xDist += orgXFly[f];
                    //yDist += orgYFly[f];
                    //zDist += orgZFly[f];
                    
                
                    orgVXFly[f] = Integer.parseInt(flyInfo[3]);
                    orgVYFly[f] = Integer.parseInt(flyInfo[4]);
                    orgVZFly[f] = Integer.parseInt(flyInfo[5]);
                }
                
                xDist = calcDist(orgXFly);
                yDist = calcDist(orgYFly);
                zDist = calcDist(orgZFly);
                
                System.out.println("xDist= " + xDist);
                System.out.println("yDist= " + yDist);
                System.out.println("zDist= " + zDist);
                
                double dist = Math.sqrt((xDist*xDist)+(yDist*yDist)+(zDist*zDist));
                System.out.println("dist= " + dist);
                
                double nextDist = 0.0;
                int time = 1;
                
                int[] nextXFly = nextPoint(orgXFly, orgVXFly);
                int[] nextYFly = nextPoint(orgXFly, orgVXFly);
                int[] nextZFly = new int[count];
                
                while (nextDist < dist)
                {
                    xDist = calcDist(nextXFly);
                    yDist = calcDist(nextYFly);
                    zDist = calcDist(nextZFly);
                }
                
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
    
    private static int calcDist(int[] points)
    {
        int dist = 0;
        for(int i = 0; i < points.length; i++)
        {
            dist += points[i];
        }
        return dist;
    }
    
    private static int[] nextPoint(int[] orgPoint, int[] velocity)
    {
        int[] returnValue = new int[orgPoint.length];
        for (int i = 0; i < orgPoint.length; i++)
        {
            returnValue[0] = orgPoint[i] * velocity[i];
        }
        return returnValue;
    }
}
