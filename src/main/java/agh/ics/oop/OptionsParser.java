package agh.ics.oop;

import java.util.*;
import static agh.ics.oop.Direction.BACKWARD;
import static agh.ics.oop.Direction.FORWARD;

public class OptionsParser {

    public List<Direction> parse(String[] tab){
        List<Direction> dir = new ArrayList<>();

        for(String argument: tab){
            switch (argument){
                case "f", "forward" -> dir.add(FORWARD);
                case "b", "backword" -> dir.add(BACKWARD);
            }
        }
        return dir;
    }
}
