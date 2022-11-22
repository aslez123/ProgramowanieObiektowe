package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.size;
import java.lang.*;
public class SimulationEngine implements IEngine{
    List<Direction> directions;
    IWorldMap map;
    List<Vector2d> vectorList;
    List<Animal> animalList = new ArrayList<>();

    public SimulationEngine(List<Direction> directions, IWorldMap map, List<Vector2d> vectorList){
        this.directions = directions;
        this.map = map;
        this.vectorList = vectorList;
    }


    @Override
    public void run() {
        ArrayList<Animal> animalList = new ArrayList<>();
        for (Vector2d vector : vectorList) {
            Animal newAnimal = new Animal(map, vector);
            animalList.add(newAnimal);
        }
        int temp = (int) size(directions) / size(animalList);
        int rest = size(directions) % size(animalList);
        for (int j = 0; j < temp; j++) {
            for (int i = 0; i < size(animalList); i++)
                animalList.get(i).move(directions.get(i + temp-1));
        }
        if (rest != 0) {
            for (int i = 0; i < rest; i++)
                animalList.get(i).move(directions.get(temp * size(animalList) + i));
        }

    }

//    public void run(String directions) {
//
//    }

}
