package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;

public abstract class World {
    public static void main(String[] args){

        try {
            MapBoundary mapBoundary = new MapBoundary();
            GrassField grassMap = new GrassField(mapBoundary,7);
            grassMap.add_grass();
            System.out.println(mapBoundary.set_x);
            System.out.println(mapBoundary.set_y);
            List<Direction> directions = OptionsParser.parse(/*new String[]{"f", "b", "f"}*/ args);
            List<Vector2d> positions = List.of(new Vector2d(3, 4), new Vector2d(1, 4));
            SimulationEngine engine = new SimulationEngine(directions, grassMap, positions);
            grassMap.animalList = engine.run();
            System.out.println(grassMap.toString());
            Application.launch(App.class, args);
        } catch (IllegalArgumentException e){
            System.out.println("incorrect input, " + e.getMessage());
        }
    }
}

