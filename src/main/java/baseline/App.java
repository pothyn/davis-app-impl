package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.plaf.OptionPaneUI;
import java.io.IOException;
import java.util.Objects;

public class App extends javafx.application.Application {

    private ToDoList app;
    private OpenAppController oaCont;
    private Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        // Initialize app
        app = new ToDoList();
        oaCont = new OpenAppController();

        goToOpenApp();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void goToOpenApp() throws IOException {

//        // Open OpenApp
//        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("OpenApp.fxml"));
//        Parent root = (Parent) loader.load();
//
//        window.setTitle("To Do List");
//        OpenAppController scene = loader.getController();
//        scene.setList(listsList);
//        window.setScene(new Scene(root));

    }

    public void goToHomePage() {



    }

    public void goToAddToDoListItem() {



    }

    public void goToSaveAs() {



    }

    public void goToLoad() throws IOException {

        // Open Load.fxml
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("load.fxml"));
        Parent root = (Parent) loader.load();

        window.setTitle("To Do List");
        OpenAppController scene = loader.getController();
        scene.setList(listsList);
        window.setScene(new Scene(root));

    }

}
