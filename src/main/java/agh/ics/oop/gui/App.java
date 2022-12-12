package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("xD");
        MapBoundary mapBoundary = new MapBoundary();
        GrassField grassMap = new GrassField(mapBoundary,3);
        grassMap.add_grass();
        String[] args = getParameters().getRaw().toArray(new String[0]);
        List<Direction> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(3, 4), new Vector2d(1, 4));
        SimulationEngine engine = new SimulationEngine(directions, grassMap, positions);
        grassMap.animalList = engine.run();
//
//
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 10, 10, 10));
//
        drawHeader(grassMap, grid);
        drawObjects(grassMap, grid);
//
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void drawHeader(AbstractWorldMap map, GridPane grid) {


        Label label = new Label("y\\x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);
        for (int i = map.getLowerLeft().x; i <= map.getUpperRight().x; i++) {
            label = new Label(String.format("%d", i));
            grid.add(label, i - map.getLowerLeft().x + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);

        }
        for (int i = map.getUpperRight().y; i >= map.getLowerLeft().y; i--) {
            label = new Label(String.format("%d", map.getUpperRight().y - i));
            grid.add(label, 0, i - map.getLowerLeft().y + 1);
            grid.getRowConstraints().add(new RowConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    void drawObjects(AbstractWorldMap map, GridPane grid) {
        for (int i = map.getLowerLeft().x; i <= map.getUpperRight().x; i++) {
            for (int j = map.getUpperRight().y; j >= map.getLowerLeft().y; j--) {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
                Label label = new Label(toAdd.toString());
                grid.add(label, i + 1, map.getUpperRight().y - j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }

}
