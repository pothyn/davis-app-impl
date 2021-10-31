/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {

        // initialize data
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public void changeDate(int day, int month, int year) {

        // set variables to given values here

    }

    public String getDate() {

        // return Date as a String

        return month + "/" + day + "/" + year;

    }

}
