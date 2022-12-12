package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    void canMoveToTest() {
        RectangularMap map = new RectangularMap(4, 4);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1000, -4)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(5, 4)));
    }
    @Test
    void testIsOccupied() {
        RectangularMap map = new RectangularMap(4,4);
        Vector2d pos = new Vector2d(1, 2);

        map.place(new Animal(map, pos));
        Assertions.assertTrue(map.isOccupied(pos));
    }
    @Test
    void objectAtTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2,3);
        Animal a = new Animal(map, position);
        map.place(a);
        Assertions.assertEquals(a, map.objectAt(position)); // powinien być ten sam adres w pamięci
        Assertions.assertNull(map.objectAt(new Vector2d(0, 1)));
    }

}