import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WrongAns
{
    static public void displayAns(String correctAns)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Correct Answer");
        Label labelAns = new Label("Correct Answer:  "+correctAns);
        labelAns.setFont(new Font(20));
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(labelAns);
        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.showAndWait();
    }
}
