package agh.ics.oop;

import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine{
    Map<Vector2d, Animal> animalList;
    public List<Direction> directions;
    public IWorldMap map;
    public List<Vector2d> vectorList;
    public SimulationEngine(List<Direction> directions, IWorldMap map, List<Vector2d> vectorList){
        this.directions = directions;
        this.map = map;
        this.vectorList = vectorList;
        this.animalList = map.animalList;
    }
    
    @Override
    public Map<Vector2d, Animal> run() {
        for (Vector2d vector : vectorList) {
            Animal newAnimal = new Animal(map, vector);
            map.place(newAnimal);
            animalList.put(vector, newAnimal);
        }
        int current = 0;

        for (Direction direction: directions) {
            Vector2d pom = vectorList.get(current);
            if(animalList.get(pom) != null)
                animalList.get(pom).move(direction);
            current += 1;
            current = current % animalList.size();
        }
        return animalList;
    }

}
