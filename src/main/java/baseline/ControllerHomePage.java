package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHomePage {

    private ToDoList list;
    private FilteredList<ToDoListItem> filteredList;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ListView<ToDoListItem> listView;

    @FXML
    private Button addItemButton;

//    private void configureListView() {
//        listView.setCellFactory(new Callback<ListView<ToDoListItem>, ListCell<ToDoListItem>>() {
//            @Override
//            public ListCell<ToDoListItem> call(ListView<ToDoListItem> listView) {
//                return new ItemCell();
//            }
//        });
//        listView.setItems(filteredList);
//    }

//    public void setList(ToDoList list) {
//        this.list = list;
//        filteredList = new FilteredList<ToDoListItem>(list.getItems());
//        configureListView();
//    }
//
//    public void handleAddNewClick(ActionEvent actionEvent) {
//        list.getItems().add(new Item(list));
//    }
//
//    public void initializeChoiceBox() {
//        ObservableList<String> choices = FXCollections.observableArrayList();
//        choices.addAll("All", "Completed", "Todo");
//        choiceBox.setItems(choices);
//    }
//
//    public void handleChoiceBox(ActionEvent actionEvent) {
//        String choice = choiceBox.getValue();
//        System.out.println(choice);
//        if (choice.equals("All")) {
//            addItemButton.setDisable(false);
//            filteredList.setPredicate(item -> {
//                return true;
//            });
//        } else if (choice.equals("Completed")) {
//            addItemButton.setDisable(true);
//            filteredList.setPredicate(item -> item.getIsComplete() == null || item.getIsComplete());
//        } else if (choice.equals("Todo")) {
//            addItemButton.setDisable(false);
//            filteredList.setPredicate(item -> item.getIsComplete() == null || !item.getIsComplete());
//        }
//    }
//
//    public void handleBackButton(ActionEvent actionEvent) throws IOException {
//        App.goToListsScene(list.getParentList());
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        initializeChoiceBox();
//    }

}
