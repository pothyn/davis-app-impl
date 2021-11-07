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

public class App extends javafx.application.Application {
    private Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;
        goToHomePage();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void goToHomePage() throws IOException {

        // Open Load.fxml
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/HomePage.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        window.setTitle("To Do List");
        window.setScene(scene);
        window.show();

    }
}
