package agh.ics.oop;

import org.testng.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static agh.ics.oop.Direction.*;

public class MapTest {
    List<Direction> directions;
    IWorldMap map = new RectangularMap(10, 5);
    List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4)) ;

    OptionsParser op = new OptionsParser();

    @Test
    public void Test(){
        Animal animal1 = new Animal(map, positions.get(0) );
        Animal animal2 = new Animal(map, positions.get(1));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.addAnimal(animal1);
        engine.addAnimal(animal2);
        Assert.assertEquals(
                op.parse(new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"}),
                List.of(FORWARD, BACKWARD, RIGHT, LEFT, FORWARD, FORWARD, RIGHT, RIGHT, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD)
        );
        // Assert.assertEquals(directions.parse(new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"}), List.of(FORWARD, BACKWARD, RIGHT, LEFT, FORWARD, FORWARD, RIGHT, RIGHT, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, FORWARD));
        // Assert.assertEquals(engine.run(), "GIt");
    }
}
