package Moderator.Task;

import javafx.scene.control.RadioButton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SetFiles {
    private final String PATH = "LMS_Diplom_Work/lib/discipline/";
    File pathFile = new File(PATH);
    public boolean setFilesDirect(String discipline, File file, RadioButton radioButton) {
        try {
            if (Arrays.stream(pathFile.list()).toList().contains(discipline)) {
                Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(PATH + discipline+"/"+radioButton.getText()+"/"+file.getName()));
                return true;

            } else {
                Files.createDirectories(Paths.get(PATH + discipline));
                Files.createDirectories(Paths.get(PATH + discipline + "/" + "Домашнее задание"));
                Files.createDirectories(Paths.get(PATH + discipline + "/" + "Самостоятельная работа"));
                Files.createDirectories(Paths.get(PATH + discipline + "/" + "Методички"));
                Files.createDirectories(Paths.get(PATH + discipline + "/" + "На проверку"));
                Files.createDirectories(Paths.get(PATH + discipline + "/" + "На проверку" + "/" + "МП4120"));
                Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(PATH + discipline+"/"+radioButton.getText()+"/"+file.getName()));
                return true;
            }
        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
    public boolean setFilesOnProverka(String discipline, File file) {
        try {
            Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(PATH + discipline+"/На проверку/МП4120/"+file.getName()));
            return true;
        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
