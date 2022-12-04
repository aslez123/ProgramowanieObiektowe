package agh.ics.oop;

import java.util.*;

import static agh.ics.oop.Direction.*;

public class OptionsParser {

    public static List<Direction> parse(String[] tab){
        List<Direction> dir = new ArrayList<>();

        for(String argument: tab){
            switch (argument){
                case "f", "forward" -> dir.add(FORWARD);
                case "b", "backword" -> dir.add(BACKWARD);
                case "r", "right" -> dir.add(RIGHT);
                case "l", "left" -> dir.add(LEFT);
            }
        }
        return dir;
    }
}
