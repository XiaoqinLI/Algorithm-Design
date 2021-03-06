package java_fundation_exer;

import java.util.*;

public class TestTime
{
  public static void main (String[] args)
  {
     // Initialize the calendar object
     Calendar today = new GregorianCalendar();

     // Get the date
     int week = today.get(Calendar.DAY_OF_WEEK);
     System.out.println ("Day of the week = " + week);
     int day = today.get(Calendar.DAY_OF_MONTH);
     System.out.println ("day = " + day);
     int month = today.get(Calendar.MONTH);
     System.out.println ("month = " + (month+1));
     int year = today.get(Calendar.YEAR);
     System.out.println ("year = " + year);

     // Get the time
     int hour = today.get(Calendar.HOUR_OF_DAY);
     System.out.println ("hour = " + hour);
     int minute = today.get(Calendar.MINUTE);
     System.out.println ("minute = " + minute);
     int sec = today.get(Calendar.SECOND);
     System.out.println ("second = " + sec);

     // Time an event in a program to nanosecond precision
     long startTime = System.nanoTime();
     for (long i = 0; i < 1000000; i++)
     {
        long j = i - (i / 2) + (i / 3) - (i / 4) + (i / 5);
     }
     long endTime = System.nanoTime();
     long elapsedTime = endTime - startTime; 
     double seconds = elapsedTime / 1.0E09;
     System.out.println ("Elapsed Time = " + seconds + " seconds");

     // Time an event in a program to millisecond precision
     startTime = System.currentTimeMillis();
     for (long i = 0; i < 1000000; i++)
     {
        long j = i - (i / 2) + (i / 3) - (i / 4) + (i / 5);
     }
     endTime = System.currentTimeMillis();
     elapsedTime = endTime - startTime;
     seconds = elapsedTime / 1.0E03;
     System.out.println ("Elapsed Time = " + seconds + " seconds");
  }
}

