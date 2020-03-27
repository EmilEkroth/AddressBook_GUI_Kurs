package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 600));
        //primaryStage.getIcons().add(new Image("Addressbook_GUI_Kurs/resources/frameIcon32.gif"));
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