/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends javafx.application.Application {

    private AllToDoLists app;

    @Override
    public void start(Stage stage) throws IOException {

        // Initialize app
        app = new AllToDoLists();

        sceneSetup(stage, "CreateList", "Create List");

        // while
            // check for the AddButton press
                // move to AddToDo.fxml and wait for input (data must be entered before!)
                // addToDoFxml(<entered data>)
            // check for the ViewListButton press
                // move to ViewList.fxml
                // viewListFxml()




    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sceneSetup(Stage stage, String fileName, String windowTitle) throws IOException {

        // Just to clarify, this is the most basic code possible to load the scene
        // I didn't want to go too far with it because that would break out of pseudocode...
        // however, I was told it needed to run, so this was the only way to do it without an error


        // Open <fileName>.fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileName + ".fxml")));

        // attach file to scene
        Scene scene = new Scene(root);
        // change title
        stage.setTitle(windowTitle);
        // attach scene to the stage
        stage.setScene(scene);
        // display stage to user
        stage.show();

    }

    public void addToDoFxml(String listTitle) {

        // Allow user to input data about the list

        // Create a new ToDoList in app using the listTitle and now this information

    }

    public void viewListFxml() {

        // wait for input to go back

    }

}
