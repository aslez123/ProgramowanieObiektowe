package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    public Map<Vector2d, Animal> animalList = new HashMap<>();
    public int grassNumber;
    Map<Vector2d,Grass> grassList = new HashMap<>();
    MapBoundary mapBoundary;
    public GrassField(int grassNumber){
        this.grassNumber = grassNumber;
        this.mapBoundary = new MapBoundary();
    }
    public GrassField(MapBoundary mapBoundray, int grassNumber){
        this.grassNumber = grassNumber;
        this.mapBoundary = mapBoundray;
    }


    @Override
    public Vector2d getLowerLeft() {
        return mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d getUpperRight() {
        return mapBoundary.getUpperRight();
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {return true;}
        return (grassList.get(position) != null);
    }
    @Override
    public void place(Animal animal) throws IllegalArgumentException{
        super.place(animal);
        mapBoundary.add(animal);
    }

    @Override
    public Object objectAt(Vector2d position) {  // ma zwracać trawę lub zwierzę, zwierzę ważniejsze
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        return grassList.get(position);
    }

    public Vector2d[] setPrintBounds() {
        return new Vector2d[]{getLowerLeft(), getUpperRight()};
    }

    public void add_grass(){
        while(grassList.size() != grassNumber)
        {
            Random random = new Random();
            int temp = Math.abs((int)sqrt(grassNumber*10));
            int x = random.nextInt(temp);
            int y = random.nextInt(temp);
            Grass grass = new Grass(new Vector2d(x, y));
            if(!isOccupied(grass.getPosition())){
                grassList.put(new Vector2d(x, y),new Grass(new Vector2d(x, y)));
                mapBoundary.add(grass);
            }
        }
    }
}
