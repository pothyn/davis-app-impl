/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

// This class is basically the controller for the project

package baseline;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class OpenAppController {

    private ToDoList app;
    private Stage window;

    private Scene saveAsScene;

//    @FXML
//    TextField fileNameTextBox;


    public void OpenAppController(Stage window) {

        app = new ToDoList();
        this.window = window;

    }

    public void fileOpen(ActionEvent event) throws IOException {

//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.showOpenDialog(stage);

    }


    public void createNewSetOfLists(ActionEvent event) throws IOException {

//        System.out.println(fileNameTextBox.getText());
        System.out.println();

//        saveAsScene

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SaveAs.fxml")));

        ControllerSaveAs saCont = new ControllerSaveAs();

        // attach file to scene
        saveAsScene = new Scene(root);
        // change title
        window.setTitle("Save As");
        // attach scene to the stage
        window.setScene(saveAsScene);

    }

    public void loadSetOfLists(ActionEvent event) throws IOException {

        System.out.println("load process");


    }

}
