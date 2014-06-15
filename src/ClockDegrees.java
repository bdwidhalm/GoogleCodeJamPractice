/**
 *
 *  Come up with a formula to calculate the angle between
 *  the hour hand and the minute hand in a clock.
 *
 *
 * @author bdwidhalm
 *
 */

public class ClockDegrees
{

  public static void main(String[] args)
  {
    for (int hour = 0; hour <= 12; hour++)
    {
      for (int min = 0; min <= 59; min++)
      {
        System.out.println("    @: " + ((hour == 0) ? "12" : hour) + ((min < 10) ? ":0" : ":") + min);
        calcDegrees(hour, min);
      }
    }
  }

  private static void calcDegrees(int hour, int min)
  {
    int hourDegrees = (int)((30 * hour) + (0.5 * min));
    int minDegrees = 6 * min;
    int degreeBetweenHands = Math.abs(hourDegrees - minDegrees);
    int complAngle = 360 - degreeBetweenHands;
    int displayAngle = 0;
    if(degreeBetweenHands <= complAngle)
    {
      displayAngle = degreeBetweenHands;
    }
    else
    {
      displayAngle = complAngle;
    }

    System.out.println("angle: " + displayAngle + "\u00b0");
    // System.out.println("   complementary angle: " + complAngle + "\u00b0");
  }

}
