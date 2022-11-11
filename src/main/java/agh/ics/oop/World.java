package agh.ics.oop;
import static agh.ics.oop.Direction.*;
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
        Animal animal = new Animal();
        out.println("----------'-'----------");
        animal.move(FORWARD);
        animal.move(LEFT);
        out.println(animal);
        out.println("----------'-'----------");

        OptionsParser abc = new OptionsParser();
        String[] tab = {"f", "forward", "b", "f"};
        List<Direction> dir = abc.parse(tab);

        for(Direction arg: dir){
            animal.move(arg);
            out.println(animal);
        }
        out.println(animal);



    }

    abstract String toString(int x, int y);
}
