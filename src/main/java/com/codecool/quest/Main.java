package com.codecool.quest;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.GameMap;
import com.codecool.quest.logic.MapLoader;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.actors.Enemy;
import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.logic.items.Item;
import com.codecool.quest.logic.items.Milka;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label enemyHealthLabel = new Label();
    Label inventoryLabel = new Label();
    ListView listView = new ListView();
    final long timeInterval = 2000;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane playerData = new BorderPane();
        GridPane ui = new GridPane();
        VBox inventorybox = new VBox();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));


        ui.add(new Label("Name: "), 0, 0);
        TextField textField = new TextField(map.getPlayer().getName());
        ui.add(textField, 1, 0);
        ui.add(new Label("Health: "), 0, 1);
        ui.add(healthLabel, 1, 1);
        ui.add(new Label("Current enemy Health: "), 0, 2);
        ui.add(enemyHealthLabel, 1, 2);
        inventoryLabel = new Label("Inventory: ");
        Button pickUpButton = new Button("Pick up");
        inventorybox.getChildren().add(inventoryLabel);
        inventorybox.getChildren().add(pickUpButton);
        inventorybox.getChildren().add(listView);


        BorderPane borderPane = new BorderPane();


        borderPane.setCenter(canvas);
        playerData.setTop(ui);
        playerData.setBottom(inventorybox);
        borderPane.setRight(playerData);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(this::onKeyPressed);
        Timeline timeline = setup();

        pickUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                map.getPlayer().acquireItem(getCurrentItem());
                refresh();
            }
        });

        primaryStage.setTitle("Hell in a Cell");
        primaryStage.show();
        timeline.play();

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            map.getPlayer().setName(newValue);
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
    }



    private Timeline setup() {
        Timeline timer = new Timeline();
        double frameTime = 0.017;

        timer.setCycleCount( Timeline.INDEFINITE );

        KeyFrame kf = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> stepGame());

        timer.getKeyFrames().add( kf );

        return timer;
    }

    private void stepGame() {
        Enemy.getEnemies().forEach(Enemy::generateMove);
        map.getPlayer().generateMove();
        refresh();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        map.getPlayer().setLastKeyPressed(keyCode);
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        enemyHealthLabel.setText("" + map.getPlayer().getEnemyHealth());
        listView.getItems().clear();

        for (Map.Entry<String, Integer> entry : map.getPlayer().getInventory().getPlayerInventory().entrySet()) {
            listView.getItems().add(entry.getKey() + " : " + entry.getValue());
        }

    }

    public Item getCurrentItem() {
        return map.getPlayer().getCell().getItem();
    }
}
