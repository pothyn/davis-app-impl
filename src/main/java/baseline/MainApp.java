package baseline;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    private AllToDoLists alltoDoLists;

    @Override
    public void start(Stage stage) throws Exception {

        // Create new AllToDoLists

        sceneSetup("CreateList", "Create List");

        //

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sceneSetup(String fileName, String windowTitle){

        // Open <fileName>.fxml file

        // attach file to scene
        // change title
        // attach scene to the stage
        // display stage to user

    }



}
