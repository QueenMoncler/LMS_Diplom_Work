package Teacher;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenDesktop {
    public void openFile(String discipline, String typeDiscipline, String fileName){
        File file = new File("LMS_Diplom_Work/lib/discipline/"+discipline+"/"+typeDiscipline+"/" + fileName);
        try {
            //Open the file using Desktop class

            Desktop.getDesktop().open(file);

        }catch (
                IOException exception){
            exception.printStackTrace();
        }
    }
    public void openFileDZ(String discipline, String fileName){
        File file = new File("LMS_Diplom_Work/lib/discipline/"+discipline+"/"+"На проверку"+"/МП4120/" + fileName);
        try {
            //Open the file using Desktop class

            Desktop.getDesktop().open(file);

        }catch (
                IOException exception){
            exception.printStackTrace();
        }
    }

}
