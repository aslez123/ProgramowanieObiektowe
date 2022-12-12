package agh.ics.oop;

import java.util.*;

import static agh.ics.oop.Direction.*;

public class OptionsParser {

    public static List<Direction> parse(String[] tab){
        List<Direction> dir = new ArrayList<>();

        for(String argument: tab){
            String text = "f b r l forward backward right left";
            if(text.contains(argument)){
                switch (argument) {
                    case "f", "forward" -> dir.add(FORWARD);
                    case "b", "backward" -> dir.add(BACKWARD);
                    case "r", "right" -> dir.add(RIGHT);
                    case "l", "left" -> dir.add(LEFT);
                }
            }
            else
            {
                throw new IllegalArgumentException(argument + " is not legal move specification");
            }
        }
        return dir;
    }
}
