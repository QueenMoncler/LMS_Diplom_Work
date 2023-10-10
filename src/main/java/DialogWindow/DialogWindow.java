package DialogWindow;

import javafx.scene.control.Alert;

public class DialogWindow {

    public void tryAddTheme(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Диалоговое окно");
        alert.setHeaderText(null);
        alert.setContentText("Информация успешно добавлена");
        alert.showAndWait();
    }
    public void falseAddTheme(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Ошибка добавления новой темы");
        alert.setContentText("Возможно вы не выбрали преподавателя, либо тема не соответствует нормам");

        alert.showAndWait();
    }
}
