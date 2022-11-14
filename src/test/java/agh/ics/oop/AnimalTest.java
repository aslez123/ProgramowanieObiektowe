package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
//import org.testng.annotations.Test;

import static agh.ics.oop.Direction.*;

public class AnimalTest {
    IWorldMap map = new RectangularMap(4,4);
    @Test
    public void AnimTest(){
        Animal animal = new Animal(map);
        /*
        *         Assert.assertEquals(animal.toString(), "Polnoc (2,3)");
        animal.move(RIGHT);
        Assert.assertEquals(animal.toString(), "Zachod (2,3)");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "Zachod (1,4)");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "Zachod (0,4)");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "Zachod (0,4)");
        * */
        animal.move(FORWARD);
        Assert.assertEquals(animal.toString(), "N");
        animal.move(RIGHT);
        Assert.assertEquals(animal.toString(), "E");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "E");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "E");
        animal.move(BACKWARD);
        Assert.assertEquals(animal.toString(), "E");
    }
}
