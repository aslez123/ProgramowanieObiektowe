package agh.ics.oop;
import static agh.ics.oop.Direction.*;
import static agh.ics.oop.SimulationEngine.*;
import static java.lang.System.clearProperty;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class World {

    static void run(List<Direction> dir){
        out.println("Start");
        for(Direction argument: dir) {
            switch (argument) {
                case FORWARD -> out.println("Zwierzak idzie do przodu ");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu ");
                case RIGHT -> out.println("Zwierzak skręca w prawo ");
                case LEFT -> out.println("Zwierzak skręca w lewo");
                default -> out.println("Błąd");
            }
        }
        out.println("Stop");
    }

    static List<Direction> convert(String str){
        List<Direction> dir = new ArrayList<>();
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if(c == 'f'){
                dir.add(Direction.FORWARD);
            }
            if(c == 'b'){
                dir.add(Direction.BACKWARD);
            }
            if(c == 'r'){
                dir.add(RIGHT);
            }
            if(c == 'l'){
                dir.add(LEFT);
            }
        }
        return dir;
    }


    public static void main(String[] args){

        //LAB 5
        GrassField grassMap = new GrassField(10);
        grassMap.add_grass();
        grassMap.listOfAnimals.add(new Animal(grassMap, new Vector2d(3,5)));
        grassMap.listOfAnimals.add(new Animal(grassMap, new Vector2d(4,7)));
        RectangularMap map = new RectangularMap(4,9);
        List<Direction> directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"}); //"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(6,7),new Vector2d(6,9)) ;
        SimulationEngine engine = new SimulationEngine(directions, grassMap, positions);
        engine.run();
        grassMap.listOfAnimals.add(new Animal(map,new Vector2d(2,4)));
        out.println(grassMap.listOfAnimals);

        out.println(map.toString());
        out.println(grassMap.toString());

    }
    abstract String toString(int x, int y);
}
