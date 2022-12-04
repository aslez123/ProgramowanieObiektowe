package agh.ics.oop;

import java.util.ArrayList;

import static agh.ics.oop.Direction.*;
import static agh.ics.oop.MapDirection.NORTH;

public class Animal {

    private MapDirection direction = NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private final IWorldMap map;
    ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d position) {
        this.map = map;
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
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
    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver i: observers) {
            i.positionChanged(oldPosition, newPosition);
        }
    }
    public boolean isAt(Vector2d otherPosition) {
        return otherPosition.equals(this.position);
    }

    public void move(Direction direction1) {
        Vector2d oldPosition = new Vector2d(this.position.x, this.position.y);
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

        if (!map.canMoveTo(position)) {
            position = oldPosition;
        }
    }
}