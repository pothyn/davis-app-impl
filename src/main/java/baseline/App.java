package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.plaf.OptionPaneUI;
import java.io.IOException;
import java.util.Objects;

public class App extends javafx.application.Application {

    private ToDoList app;
    private Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        // Initialize app
        app = new ToDoList();

        window = stage;
        goToHomePage();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void goToHomePage() throws IOException {

        // Open Load.fxml
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/HomePage.fxml"));
        Parent root = (Parent) loader.load();

        Scene scene = new Scene(root);

        window.setTitle("To Do List");
        window.setScene(scene);
        window.show();

    }

    public void goToAdd() {

    }

    public void goToEdit(Item i) {

    }

    public void goToSaveAs() {



    }

    public void goToLoad() throws IOException {

//        // Open Load.fxml
//        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("Load.fxml"));
//        Parent root = (Parent) loader.load();
//
//        window.setTitle("To Do List");
//         scene = loader.getController();
//        window.setScene(new Scene(root));

    }

}
