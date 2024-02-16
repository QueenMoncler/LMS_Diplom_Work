package Moderator.Task;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

public class SelectList {
//    static ListView<String> listView = new ListView<>();
//    static Label label = new Label();

    public SelectList(ListView<String> listView, Label label){
//        this.listView = listView;
//        this.label = label;

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                label.setText(newValue);
            }
        });

    }

//    public MultipleSelectionModel<String> multipleSelectionModel = listView.getSelectionModel();
//
//    public MultipleSelectionModel<String> getMultipleSelectionModel(){
//        return multipleSelectionModel;
//    }





}
