import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GUI extends Application
{
    Stage window;
    HashMap<String, String> wordCollection;
    Iterator<String> iterator;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        window = stage;
        mainStage();
    }
    public void mainStage()
    {
        Button enter = new Button("Start");
        enter.setFont(new Font((40)));
        enter.setPrefSize(200, 200);
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
                    wordDisplay(TxtReader.read(file.toString()));
                }
            }
        });
        VBox layout = new VBox();
        layout.getChildren().add(enter);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,400,400);
        window.setScene(scene);
        window.show();
    }
    public void wordDisplay(HashMap<String, String> wordCollection)
    {
        this.wordCollection = wordCollection;
        Set keys = wordCollection.keySet();
        iterator = keys.iterator();
        processNextWord();
    }

    public void processNextWord()
    {
        if(iterator.hasNext())
        {
            String key = iterator.next();
            wordScene(key, wordCollection.get(key));
        }
        else
        {
            System.out.println("Finished Processing, well done.");
            window.close();
        }
    }

    public void wordScene(String character, String ans)
    {
        System.out.println(ans);
        Font font = new Font(25);
        Label hanyi = new Label("Hanyi: "+character);
        hanyi.setFont(font);
        TextField inputPinyin = new TextField();
        inputPinyin.setFont(font);
        Button enter = new Button("Enter");
        enter.setFont(font);
        enter.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if(inputPinyin.getText().equals(ans))
                {
                    processNextWord();
                }
                else
                {
                    WrongAns.displayAns(ans);
                }
            }
        });
        HBox layout = new HBox();
        layout.getChildren().addAll(hanyi, inputPinyin, enter);
        layout.setAlignment(Pos.CENTER);
        Scene wordForm = new Scene(layout, 700, 300);
        window.setScene(wordForm);
    }

}
