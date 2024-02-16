package Moderator.Home;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ToggleRadioButton {
    public ToggleRadioButton(RadioButton radioButtonMen, RadioButton radioButtonWomen){
        ToggleGroup group = new ToggleGroup();
        radioButtonMen.setToggleGroup(group);
        radioButtonMen.setSelected(true);
        radioButtonWomen.setToggleGroup(group);
    }

}
