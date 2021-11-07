package baseline;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Predicate;

public class ControllerHomePage {
    private ObservableList<Item> itemList;
    private FilteredList<Item> filteredList;

    @FXML
    private ToggleButton radioButtonAll;

    @FXML
    private ToggleButton radioButtonIncomplete;

    @FXML
    private ToggleButton radioButtonComplete;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Item, Boolean> tableComplete;

    @FXML
    private TableColumn<Item, String> tableDescription;

    @FXML
    private TableColumn<Item, String> tableDueDate;

    private void initializeRadioButtons() {
        HashMap<ToggleButton, Predicate<Item>> radioButtonToPredicate = new HashMap<>();
        radioButtonToPredicate.put(radioButtonAll, item -> {
            return true;
        });
        radioButtonToPredicate.put(radioButtonIncomplete, item -> {
            return !item.isComplete();
        });
        radioButtonToPredicate.put(radioButtonComplete, item -> {
            return item.isComplete();
        });

        ToggleGroup group = new ToggleGroup();
        radioButtonAll.setToggleGroup(group);
        radioButtonIncomplete.setToggleGroup(group);
        radioButtonComplete.setToggleGroup(group);

        System.out.println(group.getProperties());

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                System.out.println("changed");
                filteredList.setPredicate(radioButtonToPredicate.get(ov.getValue()));
            }
        });

    }

    @FXML
    public void handleAdd(ActionEvent e) throws IOException {
        Item newItem = new Item();

        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/AddEdit.fxml"));
        Parent root = (Parent) loader.load();
        ControllerEdit editController = loader.getController();
        editController.setItem(newItem);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add");
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (editController.getIsValid()) {
                    itemList.add(0, newItem);
                    tableView.getSelectionModel().selectFirst();
                }
            }
        });
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleEdit() throws IOException {
        Item selectedItem = (Item) tableView.getFocusModel().getFocusedItem();
        if (selectedItem == null)
            return;

        itemList.remove(selectedItem);
        Item backup = selectedItem.clone();

        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/AddEdit.fxml"));
        Parent root = (Parent) loader.load();
        ControllerEdit editController = loader.getController();
        editController.setItem(selectedItem);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Edit");
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (!editController.getIsValid())
                    selectedItem.restore(backup);

                itemList.add(0, selectedItem);
                tableView.getFocusModel().focus(0);
            }
        });
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleRemove() {
        Item selectedItem = (Item) tableView.getFocusModel().getFocusedItem();
        itemList.remove(selectedItem);
    }

    @FXML
    private void handleClear() {
        itemList = FXCollections.observableArrayList();
        filteredList = new FilteredList<>(itemList);
        tableView.setItems(filteredList);
    }

    private void initializeList() {
        itemList = FXCollections.observableArrayList();
        filteredList = new FilteredList<>(itemList);
        tableView.setItems(filteredList);

        itemList.add(new Item("ASDF", "2002-12-02", true));
        itemList.add(new Item("ASDdsfeF", "2003-12-02", false));
        itemList.add(new Item("ABCDE", "2005-12-02", false));

        tableDescription.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        tableComplete.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isComplete"));
        tableDueDate.setCellValueFactory(new PropertyValueFactory<Item, String>("dueDateString"));
    }


    @FXML
    private void initialize() {
        initializeRadioButtons();
        initializeList();
    }
}
