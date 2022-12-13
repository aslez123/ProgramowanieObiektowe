package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;

public class App extends Application {
    private double gridSize = 40;
    private int moveDelay = 300;
    GridPane grid = new GridPane();
    MapBoundary mapBoundary = new MapBoundary();
    GrassField map = new GrassField(mapBoundary,3);
    Button startButton = new Button("Start");
    TextField inputField = new TextField();


    @Override
    public void start(Stage primaryStage) throws Exception {

        map.add_grass();
        String[] args = getParameters().getRaw().toArray(new String[0]);
        List<Direction> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(3, 4), new Vector2d(1, 4));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        map.animalList = engine.run();
//
//
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 10, 10, 10));
//
        drawHeader(map, grid);
        drawObjects(map, grid);
//
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void draw() throws FileNotFoundException {
        System.out.println(map.getLowerLeft().toString() + " " + map.getUpperRight().toString());
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 10, 10, 10));
        drawHeader(map, grid);
        drawObjects(map, grid);

    }


    public void render() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            grid.setGridLinesVisible(false);
            try {
                draw();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
    void drawHeader(AbstractWorldMap map, GridPane grid) {


        Label label = new Label("y\\x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(this.gridSize));
        grid.getRowConstraints().add(new RowConstraints(this.gridSize));
        GridPane.setHalignment(label, HPos.CENTER);
        for (int i = map.getLowerLeft().x; i <= map.getUpperRight().x; i++) {
            label = new Label(String.format("%d", i));
            grid.add(label, i - map.getLowerLeft().x + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(this.gridSize));
            GridPane.setHalignment(label, HPos.CENTER);

        }
        int rowIndex = 0;
        for (int i = map.getUpperRight().y; i >= map.getLowerLeft().y; i--) {
            label = new Label(String.format("%d", i));
            rowIndex = map.getUpperRight().y - i + 1;
            grid.add(label, 0, rowIndex );
            grid.getRowConstraints().add(new RowConstraints(this.gridSize));
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    void drawObjects(AbstractWorldMap map, GridPane grid) {
        for (int i = map.getLowerLeft().x; i <= map.getUpperRight().x; i++) {
            for (int j = map.getLowerLeft().y; j <= map.getUpperRight().y; j++)  {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
//                IMapElement toAddElement = (IMapElement) toAdd;
//                GuiElementBox box = new GuiElementBox(toAddElement);
//                grid.add(box, i + 1 + Math.abs(map.getLowerLeft().x), map.getUpperRight().y - j + 1);
//                GridPane.setHalignment(box.vbox, HPos.CENTER);
                Label label = new Label(toAdd.toString());
                grid.add(label, i + 1, map.getUpperRight().y - j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }

}
