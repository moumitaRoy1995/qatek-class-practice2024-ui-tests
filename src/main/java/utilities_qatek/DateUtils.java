package utilities_qatek;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth()
    {
        //create date object
        Date dNow = new Date();

        //create calender object for Gregorian Calender
        Calendar calender = new GregorianCalendar();

        //Set calendar object to current date
        calender.setTime(dNow);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calender.add(Calendar.MONTH,1);

        String date = sdf.format(calender.getTime());
        return date.split("-");
    }
}
