package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class resource extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(resource.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Excalibur 6738");
        stage.setScene(scene);
        stage.show();
        Group root = new Group();
        Scene Scene = new Scene(root, Color.AQUA);
        Image image = new Image("Excalibur.png");
        //ImageView imageView = new ImageView(image);
        //imageView.setX(50.0);
        //imageView.setY(50.0);
        //Image icon = new Image("Excalibur.png");
        //stage.getIcons().add(icon);


    }

    public static void main(String[] args) {
        launch();
    }
}