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

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }


    @Override
    public void run() {
        int temp = (int)size(directions)/size(animalList);
        int rest = size(directions)%size(animalList);
        for(int j = 0; j < temp; j++){
            for(int i = 0; i<size(animalList); i++)
                animalList.get(i).move(directions.get(i + temp));
        }
        if(rest!=0){
            for(int i = 0; i<rest; i++)
                animalList.get(i).move(directions.get(temp*size(animalList)+i));
        }

    }

    @Override
    public void run(String directions) {
        String correctDirections = directions.trim();
        int temp = (int)correctDirections.length()/size(animalList);
        int rest = correctDirections.length()%size(animalList);
        for(int j = 0; j < temp; j++){
            for(int i = 0; i<size(animalList); i++)
                animalList.get(i).move(World.convert(correctDirections).get(i + temp));
            }
        if(rest!=0){
            for(int i = 0; i<rest; i++)
                animalList.get(i).move(World.convert(correctDirections).get(temp*size(animalList)+i));
        }
    }
}
