/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ToDoListItem {

    private ToDoList parentList;
    private Date date;
    private String itemDescription;
    private boolean isComplete;

    public ToDoListItem(ToDoList list) {

        // initialize vars
        parentList = list;
        date = new Date();
        itemDescription = "";
        isComplete = false;

    }

    public void editCompletion(boolean isComplete) {

        // change isComplete
        this.isComplete = isComplete;

    }

    public void editDescription(String itemDescription) {

        // change itemDescription
        this.itemDescription = itemDescription;

    }

    public void editDate(int day, int month, int year) {

        // change date
        date.changeDate(day, month, year);

    }

    public boolean getIsComplete() {

        return isComplete;

    }

    public String getItemDescription() {

        return itemDescription;

    }

    public String getDate() {

        return date.getDate();

    }

}
