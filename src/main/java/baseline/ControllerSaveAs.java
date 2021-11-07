package baseline;

import com.sun.javafx.tk.FileChooserType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    TextField fileNameTextBox;

    @FXML
    public void filePick() {
        System.out.println("filePick");

        // get box location
        Stage stage = (Stage) fileLocationTextBox.getScene().getWindow();

//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.showSaveDialog(stage);

        FileChooser choose = new FileChooser();
        choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File f = choose.showSaveDialog(stage);
        if(!f.getName().contains(".")) {
            file = new File(f.getAbsolutePath() + ".txt");
        }
    }

    @FXML
    public void loadFile() {
        addLine(file,0);
    }

    public void addLine(File file, int index) {
        String line = "add line";

//        String line = itemList.get(index).getDescription() + "|"
//                + itemList.get(index).getDueDateString() + "|"
//                + itemList.get(index).isComplete() + "|";

        FileWriter file_writer;
        try {
            file_writer = new FileWriter(file,false);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(line);
            buffered_Writer.flush();
            buffered_Writer.close();

        } catch (IOException e) {
            System.out.println("Add line failed!!" +e);
        }
    }
}
