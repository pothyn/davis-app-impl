/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private SimpleStringProperty description;
    private SimpleStringProperty dueDateString;
    private SimpleBooleanProperty isComplete;

    public Item() {
        this.description = new SimpleStringProperty();
        this.dueDateString = new SimpleStringProperty();
        this.isComplete = new SimpleBooleanProperty();
    }

    public Item(String description, String dueDateString, boolean isComplete) {
        this.description = new SimpleStringProperty(description);
        this.dueDateString = new SimpleStringProperty(dueDateString);
        this.isComplete = new SimpleBooleanProperty(isComplete);
    }

    public Item clone() {
        return new Item(description.getValue(), dueDateString.getValue(), isComplete.getValue());
    }

    public void restore(Item i) {
        description.setValue(i.getDescription());
        dueDateString.setValue(i.getDueDateString());
        isComplete.setValue(i.isComplete());
    }

    public boolean isComplete() {
        return isComplete.get();
    }

    public SimpleBooleanProperty isCompleteProperty() {
        return isComplete;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDueDateString() {
        return dueDateString.get();
    }

    public SimpleStringProperty dueDateStringProperty() {
        return dueDateString;
    }
}
