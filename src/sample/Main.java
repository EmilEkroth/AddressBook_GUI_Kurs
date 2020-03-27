package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 600));

        Image i = new Image(new FileInputStream("E:/AddressBook_GUI_Kurs/Resources/frameIcon32.gif"));
        primaryStage.getIcons().add(i);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                //Model.getInstance().shutDown();
            }
        }));
    }


}