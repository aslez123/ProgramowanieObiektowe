package agh.ics.oop;

import static agh.ics.oop.Direction.*;
import static agh.ics.oop.MapDirection.*;

public class Animal {
    private MapDirection direction = NORTH;
    private Vector2d location = new Vector2d(2, 2);

    @Override
    public String toString(){
        return direction.toString() + ' ' + location;
    }

    private boolean isAt(Vector2d position){
        return position == location;
    }

    public void move(Direction direction1) {
        if (direction1 == RIGHT) {
            direction = (MapDirection) direction.next();
        }
        if (direction1 == LEFT) {
            direction = (MapDirection) direction.previous();
        }
        if(location.x < 4 && location.y < 4 && location.x > 0 && location.y > 0){
            if (direction1 == BACKWARD) {
                switch (direction) {
                    case NORTH -> location.y -= 1;
                    case SOUTH -> location.y += 1;
                    case EAST -> location.x -= 1;
                    case WEST -> location.x += 1;
                }
            }
            if (direction1 == FORWARD) {
                switch (direction) {
                    case NORTH -> location.y += 1;
                    case SOUTH -> location.y -= 1;
                    case EAST -> location.x += 1;
                    case WEST -> location.x -= 1;
                }
            }
        }

        if(location.x == 4 || location.y == 4 ){
            if (direction1 == BACKWARD) {
                switch (direction) {
                    case NORTH -> location.y -= 1;
                    case EAST -> location.x -= 1;
                }
            }
            if (direction1 == FORWARD) {
                switch (direction) {
                    case SOUTH -> location.y -= 1;
                    case WEST -> location.x -= 1;
                }
            }
        }

        if(location.x == 0 || location.y == 0 ){
            if (direction1 == BACKWARD) {
                switch (direction) {
                    case SOUTH -> location.y += 1;
                    case WEST -> location.x += 1;
                }
            }
            if (direction1 == FORWARD) {
                switch (direction) {
                    case NORTH -> location.y += 1;
                    case EAST -> location.x += 1;
                }
            }
        }
    }
}
