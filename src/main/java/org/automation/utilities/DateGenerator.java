package org.automation.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateGenerator {

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }
    public String DateTimeGenerator(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println("generated Date is ======   " + date1);
        return date1;
    }

    public String getDateWithDays(String format, int dayToAdd) {

        LocalDate todayDate = LocalDate.now();
        LocalDate date = LocalDate.parse(todayDate.toString());
        LocalDate date2 = date.plusDays(dayToAdd);
        System.out.println("Date " + date + " plus 5 days is " + date2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date2);
    }
}
