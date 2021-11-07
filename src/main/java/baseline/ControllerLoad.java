package baseline;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ControllerLoad {
    ObservableList<Item> list;

    @FXML
    TextField fileTextBox;

    @FXML
    public void filePick() {
        System.out.println("filePick");

        // get box location
        Stage stage = (Stage) fileTextBox.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);

//        list = parse(file);
    }

    @FXML
    public void loadFile() {
        System.out.println("Load File");
    }
}
