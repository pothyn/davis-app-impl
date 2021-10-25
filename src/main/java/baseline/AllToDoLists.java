/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import java.util.ArrayList;

public class AllToDoLists {

    private ArrayList<ToDoList> toDoLists;

    public AllToDoLists(){

        // initialize toDoLists

    }

    public int findToDoList(String description) {

        // run through the descriptions for toDoList and if they match
            // if they do match, which one will (because it is through one of the dropdowns)
                // return the index

        // return -1 for a catastrophic failure

    }


    public void addToDoList() {

        // go to create list page

        // take in data from user

        // go to add item page

        // create new ToDoList for the ArrayList

    }

    public void removeToDoList(int i) {

        // remove toDoList.get(i) from the toDoList arrayList

    }

    public void editToDoList(int i) {

        // go to editToDoList

        removeToDoList(i);

        // create a new to do list like in addToDoList BUT add at index i

    }

    public boolean saveToDoList(ArrayList<Integer> saveArray, String fileLocation) {

        // open file at fileLocation

        // if file not found then return false

        // run through each value of saveArray
            // save all of the data to each respective line

        return true;

    }

    public void loadToDoList(String fileLocation) {

        // open file at fileLocation

        // for each line
            // parse through data and call addToDoList()

    }

}
