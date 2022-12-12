package agh.ics.oop;

import java.util.ArrayList;

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
        switch(direction1) {
            case FORWARD -> {
                moveIfPossible(position.add(direction.toUnitVector()));
            }
            case BACKWARD -> {
                moveIfPossible(position.subtract(direction.toUnitVector()));
            }
            case RIGHT -> {
                direction = (MapDirection) direction.next();
            }
            case LEFT -> {
                direction = (MapDirection) direction.previous();
            }
            default -> {
            }
        }
    }

    private void moveIfPossible(Vector2d destination) {
        if(map.canMoveTo(destination))
            position = destination;
    }
}