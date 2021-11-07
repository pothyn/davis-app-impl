/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControllerSaveAs {
    private ObservableList<Item> itemList;
    private File file;


    @FXML
    TextField fileLocationTextBox;

    @FXML
    public void filePick() {
        // get box location
        Stage stage = (Stage) fileLocationTextBox.getScene().getWindow();

        FileChooser choose = new FileChooser();
        choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File f = choose.showSaveDialog(stage);
        if (f != null) {
            file = f;
            fileLocationTextBox.textProperty().setValue(f.getPath());
        }
    }

    @FXML
    public void saveFile() {
        clearText();
        for(int i = 0; i < itemList.size(); i++)
            addLine(i);

        Stage stage = (Stage) fileLocationTextBox.getScene().getWindow();
        stage.close();
    }

    public void setItemList(ObservableList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addLine(int index) {
        String line = itemList.get(index).getDescription() + "|"
                + itemList.get(index).getDueDateString() + "|"
                + itemList.get(index).isComplete() + "|\n";

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Add line failed!!" +e);
        }
    }

    public void clearText() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Add line failed!!" +e);
        }
    }
}
