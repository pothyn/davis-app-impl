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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControllerLoad {
    private ObservableList<Item> itemList;
    private File file;

    @FXML
    TextField fileTextBox;

    @FXML
    public void filePick() {
        // get box location
        Stage stage = (Stage) fileTextBox.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File f = fileChooser.showOpenDialog(stage);
        if (f != null) {
            file = f;
            fileTextBox.textProperty().setValue(f.getPath());
        }
    }

    @FXML
    public void loadFile() throws FileNotFoundException {
        getDataFromText();

        Stage stage = (Stage) fileTextBox.getScene().getWindow();
        stage.close();
    }

    public void getDataFromText() throws FileNotFoundException {
        Scanner in = new Scanner(file);

        while(in.hasNextLine()) {
            String line = in.nextLine();
            parseData(line);
        }
    }

    public void parseData(String line) {
        Item newItem = new Item();
        int round = 0;
        int beginIndex = 0;

        for(int i=0; i < line.length(); i++) {
            if(line.charAt(i) == '|') {
                if(round == 0)
                    newItem.descriptionProperty().setValue(line.substring(beginIndex,i));
                else if(round == 1) {
                    if(line.substring(beginIndex, i).equals(""))
                        newItem.dueDateStringProperty().setValue("");
                    else
                        newItem.dueDateStringProperty().setValue(line.substring(beginIndex, i));
                }
                else if(round == 2)
                    newItem.isCompleteProperty().setValue(line.substring(beginIndex,i).equals("true"));

                round++;
                beginIndex = i+1;
            }
        }
        itemList.add(newItem);
    }

    public void setItemList(ObservableList<Item> itemList) {
        this.itemList = itemList;
    }
}
