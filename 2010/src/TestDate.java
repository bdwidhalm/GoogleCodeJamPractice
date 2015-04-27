import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TestDate
{

  public static void main(String[] args)
  {
    SimpleDateFormat formatDate = new SimpleDateFormat("ww EEE MMM dd, yyyy GG");
    Calendar startDate = Calendar.getInstance();
    startDate.set(Calendar.YEAR, 1582);
    startDate.set(Calendar.MONTH, 9);
    startDate.set(Calendar.DAY_OF_MONTH, 1);
    
    for(int i = 0; i <= 60; i++)
    {
      System.out.println(formatDate.format(startDate.getTime()));
      startDate.add(Calendar.DAY_OF_YEAR, 1);
    }
    
    startDate.set(Calendar.YEAR, 1582);
    startDate.set(Calendar.MONTH, 9);
    String test = formatDate.format(startDate.getTime());
    startDate.set(Calendar.DAY_OF_MONTH, 1);
    String test2 = formatDate.format(startDate.getTime());
    startDate.set(Calendar.DAY_OF_WEEK, 1);
    
    System.out.println("\n\n");
    
    
    for (int j = 1; j <= 6; j++)
    {
      printWeekDates(startDate);
      printDays(startDate);
      System.out.print("|-------------------------------------------------------------------------------------------------------------|\n");
      startDate.add(Calendar.WEEK_OF_YEAR, 1);
    }
    
  }
  
  private static void printWeekDates(Calendar firstDate)
  {
    SimpleDateFormat formatDay = new SimpleDateFormat("dd");
    
    Calendar useDate = Calendar.getInstance();
    useDate.set(Calendar.YEAR, firstDate.get(Calendar.YEAR));
    useDate.set(Calendar.MONTH, firstDate.get(Calendar.MONTH));
    useDate.set(Calendar.DAY_OF_MONTH, firstDate.get(Calendar.DAY_OF_MONTH));

    System.out.print("|    ");
    for (int i = 1; i <= 7; i++)
    {
      System.out.print("| ");
      System.out.print(formatDay.format(useDate.getTime()));
      
        System.out.print("           ");
        
        useDate.add(Calendar.DAY_OF_YEAR, 1);
    }
    System.out.print("|\n");
  }
  
  
  private static void printDays(Calendar firstDate)
  {
    
    Calendar useDate = Calendar.getInstance();
    useDate.set(Calendar.YEAR, firstDate.get(Calendar.YEAR));
    useDate.set(Calendar.MONTH, firstDate.get(Calendar.MONTH));
    useDate.set(Calendar.DAY_OF_MONTH, firstDate.get(Calendar.DAY_OF_MONTH));
    

    for (int j = 0; j < 4; j++)
    {
      if (j == 1)
      {
        SimpleDateFormat formatWeek = new SimpleDateFormat("ww");
        System.out.print("| " + formatWeek.format(useDate.getTime()) + " ");
      }
      else
      {
        System.out.print("|    ");
      }
      System.out.print("|              |              |              |              |              |              |              |\n");
    }
  }
}
