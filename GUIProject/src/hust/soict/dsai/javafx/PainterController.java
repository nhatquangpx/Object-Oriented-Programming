package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ nội dung vẽ trên Pane
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Chọn màu vẽ dựa trên trạng thái của RadioButton
        Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;

        // Tạo hình tròn và thêm vào Pane
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
