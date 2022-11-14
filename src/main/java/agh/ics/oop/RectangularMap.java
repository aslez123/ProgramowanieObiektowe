package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    int width;
    int height;
    List<Animal>listOfAnimals = new ArrayList<>();
    IWorldMap map;
    public RectangularMap(int width, int height){
    this.width = width;
    this.height = height;

    }
    @Override
    public String toString(){
        MapVisualizer obj = new MapVisualizer(map);
        return obj.draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x > width || position.y > height || position.x < 0 || position.y < 0)
            return false;
        if(isOccupied(position))
            return false;
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.position)){
            return false;
        }
        listOfAnimals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: listOfAnimals){
            return animal.position == position;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (!isOccupied(position))
            return new Animal(map, position);
        return null;
    }
}
