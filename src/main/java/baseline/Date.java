/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {

    }

    public Date(int day, int month, int year) {

        changeDate(day, month, year);

    }


    public void changeDate(int day, int month, int year) {

        // set variables to given values here
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public String getDate() {

        // return Date as a String

        String date = year + "-";

        if(month < 10)
            date += "0" + month + "-";
        else
            date += month + "-";

        if(day < 10)
            date += "0" + day;
        else
            date += day;


        return date;

    }

}
