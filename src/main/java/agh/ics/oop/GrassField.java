package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    Map<Vector2d, Animal> animalList = new HashMap<>();
    public Vector2d lowerGrass;
    public Vector2d upperGrass;
    public int grassNumber;
    public Vector2d printLowerLeft, printUpperRight;
    Map<Vector2d,Grass> grassList;
    public GrassField(int grassNumber){
        this.grassNumber = grassNumber;
        this.lowerGrass = new Vector2d(0,0);
        this.upperGrass = new Vector2d((int)sqrt(this.grassNumber*10),(int)sqrt(this.grassNumber*10));
        this.grassList = new HashMap<>();
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {return true;}
        return (grassList.get(position) != null);
    }

    @Override
    public Object objectAt(Vector2d position) {  // ma zwracać trawę lub zwierzę, zwierzę ważniejsze
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        return grassList.get(position);
    }

    public Vector2d[] setPrintBounds() {
        Set<Vector2d> temp = this.animalList.keySet();
        ArrayList<Vector2d> positions = new ArrayList<>(temp);
        if (!this.animalList.isEmpty()) {
            printLowerLeft = printUpperRight = positions.get(0);
        }
        else if (!this.grassList.isEmpty()) {
            printLowerLeft = printUpperRight = this.grassList.get(0).getPosition();
        }
        else {
            printLowerLeft = new Vector2d(0,0);
            printUpperRight = new Vector2d(0,0);
            return new Vector2d[]{printLowerLeft, printUpperRight};
        }
        for (Animal i: animalList.values()) {
            printLowerLeft = printLowerLeft.lowerLeft(i.getPosition());
            printUpperRight = printUpperRight.upperRight(i.getPosition());
        }
        for (Grass i: grassList.values()) {
            printLowerLeft = printLowerLeft.lowerLeft(i.getPosition());
            printUpperRight = printUpperRight.upperRight(i.getPosition());
        }
        return new Vector2d[]{printLowerLeft, printUpperRight};
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
            }
        }
    }
}
