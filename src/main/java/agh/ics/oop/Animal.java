package agh.ics.oop;

import static agh.ics.oop.Direction.*;
import static agh.ics.oop.MapDirection.NORTH;

public class Animal {
    private MapDirection direction = NORTH;
    Vector2d position = new Vector2d(2, 2);
    IWorldMap map;

    //public Animal(){} konstruktor bez parametrowy nie ma sensu ponieważ aby użyć metody move potrzebujemy mieć dostęp do map
    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return switch (direction) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    private boolean isAt(Vector2d position1) {
        return position1 == position;
    }

    public Vector2d move(Direction direction1) {
        Vector2d oldPosition = new Vector2d(position.x, position.y);
        if (direction1 == RIGHT) {
            direction = (MapDirection) direction.next();
        }
        if (direction1 == LEFT) {
            direction = (MapDirection) direction.previous();
        }
        if (direction1 == BACKWARD) {
            switch (direction) {
                case NORTH -> position.y -= 1;
                case SOUTH -> position.y += 1;
                case EAST -> position.x -= 1;
                case WEST -> position.x += 1;
            }
        }
        if (direction1 == FORWARD) {
            switch (direction) {
                case NORTH -> position.y += 1;
                case SOUTH -> position.y -= 1;
                case EAST -> position.x += 1;
                case WEST -> position.x -= 1;
            }
        }

        if (map.canMoveTo(position)) {
            return position;
        }
        return oldPosition;
    }
}