package Teacher.Send;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLib {

    public List<String> t(String disciplines, String materials){
        File f = new File("LMS_Diplom_Work/lib/discipline/"+disciplines+"/"+materials+"/");
        List<String> list = new ArrayList<>();
        for(File file:f.listFiles()){
            list.add(file.getName());
        }
        return list;
    }
}
