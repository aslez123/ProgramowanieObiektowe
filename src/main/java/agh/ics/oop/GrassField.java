package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    public Vector2d lowerGrass;
    public Vector2d upperGrass;
    public int grassNumber;

    public Vector2d printLowerLeft, printUpperRight;
    ArrayList<Animal> listOfAnimals;
    ArrayList<Grass> grassList;

    public GrassField(int grassNumber){
        this.grassNumber = grassNumber;
        this.lowerGrass = new Vector2d(0,0);
        this.upperGrass = new Vector2d((int)sqrt(this.grassNumber*10),(int)sqrt(this.grassNumber*10));
        this.grassList = new ArrayList<>();
        this.listOfAnimals= new ArrayList<>();
    }

    public void setPrintBounds() {
        if (!this.listOfAnimals.isEmpty()) {
            printLowerLeft = printUpperRight = this.listOfAnimals.get(0).getPosition();
        }
        else if (!this.grassList.isEmpty()) {
            printLowerLeft = printUpperRight = this.grassList.get(0).getPosition();
        }
        else {
            printLowerLeft = new Vector2d(0,0);
            printUpperRight = new Vector2d(0,0);
            return;
        }
        for (Animal i: this.listOfAnimals) {
            printLowerLeft = printLowerLeft.lowerLeft(i.getPosition());
            printUpperRight = printUpperRight.upperRight(i.getPosition());
        }
        for (Grass i: this.grassList) {
            printLowerLeft = printLowerLeft.lowerLeft(i.getPosition());
            printUpperRight = printUpperRight.upperRight(i.getPosition());
        }
    }
    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        setPrintBounds();
        return visualization.draw(this.printLowerLeft, this.printUpperRight);
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
                grassList.add(grass);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)){return true;}
        for (Grass grass: this.grassList) {
            if (position.equals(grass.position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {  // ma zwracać trawę lub zwierzę, zwierzę ważniejsze
        for (Animal i: this.listOfAnimals) {
            if (i.isAt(position)) {
                return i;
            }
        }
        for (Grass i: this.grassList) {
            if (position.equals(i.position)) {
                return i;
            }
        }
        return null;
    }
}
