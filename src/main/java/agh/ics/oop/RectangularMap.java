package agh.ics.oop;


import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    int width;
    int height;
    Map<Vector2d, Animal> animalList = new HashMap<>();
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2d getLowerLeft() {
        return new Vector2d(0,0);
    }

    @Override
    public Vector2d getUpperRight() {
        return new Vector2d(this.width, this.height);
    }

    @Override
    public Vector2d[] setPrintBounds() {
        return new Vector2d[]{getLowerLeft(), getUpperRight()};
    }

}
