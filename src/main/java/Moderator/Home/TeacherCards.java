package Moderator.Home;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TeacherCards {
    public URL urlTeacherZhilina = getClass().getResource("/Images/zhilina.png");
    final URL urlTeacherKnyazev = getClass().getResource("/Images/knyazev.png");
    final URL urlVornikova = getClass().getResource("/Images/vornikova.png");





    Map<Image, Integer> teacherStaff = new HashMap<>();

    public void setStaff(){
        teacherStaff.put(new Image(urlTeacherZhilina.toExternalForm()), 1);
        teacherStaff.put(new Image(urlTeacherKnyazev.toExternalForm()), 2);
        teacherStaff.put(new Image(urlVornikova.toExternalForm()), 3);
    }





}
