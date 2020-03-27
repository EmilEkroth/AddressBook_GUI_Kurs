package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;


public class Main extends Application {
    protected File file=new File("Resources");
    private String filePath= file.getAbsolutePath();


    @Override
    public void start(Stage primaryStage) throws Exception{
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("sample.AddressBook");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"), bundle);
        primaryStage.setTitle(bundle.getString("application.name") + bundle.getString("application.version"));
        primaryStage.setScene(new Scene(root, 500, 600));

        Image i = new Image(new FileInputStream(filePath+"/frameIcon32.gif"));
        primaryStage.getIcons().add(i);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}