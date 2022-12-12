package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertThrows;

public class GrassFieldTest {
    @Test
    void canMoveToTest() {
        IWorldMap map = new GrassField(4);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(-1000, -4)));
    }

    @Test
    void testPLaceAnimal() {
        GrassField map = new GrassField(10);
        assertDoesNotThrow(() -> map.place(new Animal(map, new Vector2d(1, 1))));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, new Vector2d(1, 1))));
    }
    @Test
    void testMoveAnimalOnOtherAnimalPlace() {
        GrassField map = new GrassField(0);
        Vector2d pos = new Vector2d(1, 3);

        map.place(new Animal(map, pos));

        Assertions.assertFalse(map.canMoveTo(pos));
    }
    @Test
    void testIsOccupied() {
        GrassField map = new GrassField(0);
        Vector2d pos = new Vector2d(1, 2);

        map.place(new Animal(map, pos));
        Assertions.assertTrue(map.isOccupied(pos));
    }
    @Test
    void objectAtTest() {
        IWorldMap map = new GrassField(1);
        Vector2d position = new Vector2d(5,3);
        Animal a = new Animal(map, position);
        map.place(a);
        Assertions.assertEquals(map.objectAt(position), a);
        Assertions.assertNull(map.objectAt(new Vector2d(-10,3)));
        Object newObject;
        Vector2d testVector;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testVector = new Vector2d(i, j);
                if (map.isOccupied(testVector)) {
                    newObject = map.objectAt(testVector);
                    Assertions.assertTrue(newObject instanceof Grass);
                    return;
                }
            }
        }

    }
}