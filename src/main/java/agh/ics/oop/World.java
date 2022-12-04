package agh.ics.oop;
import static agh.ics.oop.Direction.*;
import static agh.ics.oop.SimulationEngine.*;
import static java.lang.System.clearProperty;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public abstract class World {
    public static void main(String[] args){

        //LAB 5
        GrassField grassMap = new GrassField(10);
        grassMap.add_grass();
        List<Direction> directions = OptionsParser.parse(args); //"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4)) ;
        SimulationEngine engine = new SimulationEngine(directions, grassMap, positions);
        grassMap.animalList = engine.run();
        out.println(grassMap.toString());
    }

    abstract String toString(int x, int y);
}
