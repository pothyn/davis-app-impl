/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ControllerEdit {
    private Item item;
    private boolean isValid;

    @FXML
    TextField descriptionBox;

    @FXML
    DatePicker dueDateBox;

    @FXML
    CheckBox isCompleteBox;

    @FXML
    Button submitButton;

    @FXML
    private void handleSubmit() {
        // validation stuff
        // ensure text is within 1-256 characters
        if (descriptionBox.getText() != null && descriptionBox.getText().length() < 256) {
            if (dueDateBox.getValue() != null)
                item.dueDateStringProperty().setValue(dueDateBox.getValue().toString());
            if (dueDateBox.getEditor().textProperty().getValue().equals(""))
                item.dueDateStringProperty().setValue(null);
            isValid = true;
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setItem(Item item) {
        // set item equal to class'
        this.item = item;
        // check for due date not being empty and set it if it is
        if (item.dueDateStringProperty().getValue() != null)
            dueDateBox.setValue(LocalDate.parse(item.getDueDateString()));
        // set other values equal
        descriptionBox.textProperty().bindBidirectional(item.descriptionProperty());
        isCompleteBox.selectedProperty().bindBidirectional(item.isCompleteProperty());
    }

    public boolean getIsValid() {
        return isValid;
    }
}
