package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    int width;
    int height;
    List<Animal>listOfAnimals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperRight = new Vector2d(this.width, this.height);
        this.lowerLeft = new Vector2d(0,0);
    }
    @Override
    public void setPrintBounds() {
        printLowerLeft = this.lowerLeft;
        printUpperRight = this.upperRight;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (!isOccupied(position))
            return new Animal(this, position);
        return null;
    }
}
