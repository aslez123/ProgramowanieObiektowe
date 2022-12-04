package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.precedes(this.upperRight) && position.follows(this.lowerLeft))
            return false;
        if(isOccupied(position))
            return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {  // true jak pole jest zajęte
        return animalList.get(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position) {
        return animalList.get(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) { // sprawdza czy nowa pozycja jest w ogóle in bounds
            return false;
        }
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {
            //sprawdza czy pole jest zajęte przez zwierzaka, ignoruje inne rzeczy
            return false;
        }
        this.animalList.put(animal.getPosition(),animal); //dodaje zwierzaka
        return true;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalList.put(newPosition, animalList.get(oldPosition));
        animalList.remove(oldPosition);
    }

    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        Vector2d[] bounds = setPrintBounds();
        return visualization.draw(bounds[0], bounds[1]);
    }
    abstract public Vector2d[] setPrintBounds();
}
