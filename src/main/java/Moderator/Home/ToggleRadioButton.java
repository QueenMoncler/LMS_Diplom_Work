package Moderator.Home;

import Teacher.Send.FileLib;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ToggleRadioButton {


    public void toggleRadioGender(RadioButton radioButtonMen, RadioButton radioButtonWomen){
        ToggleGroup group = new ToggleGroup();
        radioButtonMen.setToggleGroup(group);
        radioButtonMen.setSelected(true);
        radioButtonWomen.setToggleGroup(group);
    }
    public void toggleRadioDiscipline(RadioButton r1, RadioButton r2, RadioButton r3){
        ToggleGroup groupr = new ToggleGroup();
        r1.setToggleGroup(groupr);
        //r1.setSelected(false);
        r2.setToggleGroup(groupr);
        r3.setToggleGroup(groupr);

    }
    public void toggleRadioSend(RadioButton r1, RadioButton r2){
        ToggleGroup groupr = new ToggleGroup();
        r1.setToggleGroup(groupr);
        //r1.setSelected(false);
        r2.setToggleGroup(groupr);
    }
    public RadioButton radioButton(RadioButton r1, RadioButton r2){
        ToggleGroup groupr = new ToggleGroup();
        r1.setToggleGroup(groupr);
        r2.setToggleGroup(groupr);
        if(r1.isSelected()){
            return r1;
        }
        if(r2.isSelected()){
            return r2;
        }
        return null;
    }

    public RadioButton t(RadioButton r1, RadioButton r2, RadioButton r3){
        ToggleGroup groupr = new ToggleGroup();
        r1.setToggleGroup(groupr);
        //r1.setSelected(false);
        r2.setToggleGroup(groupr);
        r3.setToggleGroup(groupr);
        if(r1.isSelected()){
            return r1;
        }
        if(r2.isSelected()){
            return r2;
        }
        if(r3.isSelected()){
            return r3;
        }
        return null;
    }


}
