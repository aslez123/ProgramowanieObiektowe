package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {

    Vector2d printLowerLeft, printUpperRight;
    Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    protected ArrayList<Animal> listOfAnimals = new ArrayList<>();

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
        for (Animal i: this.listOfAnimals) {
            if (i.isAt(position)) {
                return true;
            }
        }
        return false;
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
        this.listOfAnimals.add(animal); //dodaje zwierzaka
        return true;
    }

    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        setPrintBounds();
        return visualization.draw(printLowerLeft, printUpperRight);
    }
    abstract public void setPrintBounds();
}