/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Hunter Davis
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        radioButtonToPredicate.put(radioButtonAll, item -> true);
        radioButtonToPredicate.put(radioButtonIncomplete, item -> !item.isComplete());
        radioButtonToPredicate.put(radioButtonComplete, Item::isComplete);

        ToggleGroup group = new ToggleGroup();
        radioButtonAll.setToggleGroup(group);
        radioButtonIncomplete.setToggleGroup(group);
        radioButtonComplete.setToggleGroup(group);

        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) ->
            filteredList.setPredicate(radioButtonToPredicate.get(ov.getValue())));

    }

    @FXML
    public void handleSaveAs() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/SaveAs.fxml"));
        Parent root = loader.load();
        ControllerSaveAs controllerSaveAs = loader.getController();
        controllerSaveAs.setItemList(itemList);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Save As");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleLoad() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/Load.fxml"));
        Parent root = loader.load();
        clearList();
        ControllerLoad controllerLoad = loader.getController();
        controllerLoad.setItemList(itemList);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Load");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleHelp() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/Help.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Help");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleAdd() throws IOException {
        Item newItem = new Item();

        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("baseline/AddEdit.fxml"));
        Parent root = loader.load();
        ControllerEdit editController = loader.getController();
        editController.setItem(newItem);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add");
        stage.setOnHidden(event -> {
            if (editController.getIsValid()) {
                itemList.add(0, newItem);
                tableView.getSelectionModel().selectFirst();
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
        Parent root = loader.load();
        ControllerEdit editController = loader.getController();
        editController.setItem(selectedItem);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Edit");
        stage.setOnHidden(event -> {
            if (!editController.getIsValid())
                selectedItem.restore(backup);

            itemList.add(0, selectedItem);
            tableView.getFocusModel().focus(0);
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

    private void clearList() {
        itemList = FXCollections.observableArrayList();
        filteredList = new FilteredList<>(itemList);
        tableView.setItems(filteredList);
    }
    @FXML
    private void handleClear() {
        clearList();
    }

    private void initializeList() {
        itemList = FXCollections.observableArrayList();
        filteredList = new FilteredList<>(itemList);
        tableView.setItems(filteredList);

        tableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableComplete.setCellValueFactory(new PropertyValueFactory<>("isComplete"));
        tableDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
    }


    @FXML
    private void initialize() {
        initializeRadioButtons();
        initializeList();
    }
}
