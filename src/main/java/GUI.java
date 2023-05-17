import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;

public class GUI extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Stage window = stage;
        Button enter = new Button("Start");
        enter.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                JFileChooser fileChooser = new JFileChooser();
                int response = fileChooser.showSaveDialog(null);
                if(response == JFileChooser.APPROVE_OPTION)
                {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(file.toString());
                }
            }
        });
        VBox layout = new VBox();
        layout.getChildren().add(enter);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,300,300);
        window.setScene(scene);
        window.show();
        window.show();
    }

    public void wordDisplay()
    {

    }


}
