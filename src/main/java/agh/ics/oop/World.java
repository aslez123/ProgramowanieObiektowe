package agh.ics.oop;
import static agh.ics.oop.Direction.*;
import static agh.ics.oop.SimulationEngine.*;
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
        //LAB 1
        /*
        out.println("System wystartował");
        run(convert(Arrays.toString(args)));
        out.println("System zakończył działanie");

        //LAB 2
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.SOUTH;
        out.println(direction.next());
        out.println(direction.previous());
        out.println(direction.toUnitVector());
        out.println(direction.toString());*/



        //LAB 3

        // Animal animal = new Animal(null);
//        out.println("----------'-'----------");
//        animal.move(FORWARD);
//        animal.move(LEFT);
//        out.println(animal);
//        out.println("----------'-'----------");
//
//        OptionsParser abc = new OptionsParser();
//        String[] tab = {"f", "forward", "b", "f"};
//        List<Direction> dir = abc.parse(tab);
//
//        for(Direction arg: dir){
//            animal.move(arg);
//            out.println(animal);
//        }
//        out.println(animal);

        //LAB 4

        List<Direction> directions = new OptionsParser().parse(args); //"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4)) ;
        Animal animal1 = new Animal(map, positions.get(0) );
        Animal animal2 = new Animal(map, positions.get(1));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.addAnimal(animal1);
        engine.addAnimal(animal2);
        engine.run();

    }

    abstract String toString(int x, int y);
}
